package jlink.restful.java.sdk.module.devicetoken;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.exception.JLinkSignatureException;
import jlink.restful.java.sdk.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DeviceToken Request
 */
public class DeviceTokenRequest {
    /**
     * @param sn devise serial number
     * @return
     * @throws Exception
     */
    public String getDeviceToken(JLinkClient jClient, String sn) {
        //getTimestamp
        String timeMillis = JLinkTimeMillisUtil.getTimMillis();
        String signature = "";
        try {
            signature = JLinkSignatureUtil.getEncryptStr(jClient.getUuid(), jClient.getAppKey(), jClient.getAppSecret(), timeMillis, jClient.getMoveCard());
        } catch (Exception e) {
            JLinkLog.e("signature error " + e.getMessage());
            throw new JLinkSignatureException(JLinkResponseCode.SIGN_ERROR.getCode(), JLinkResponseCode.SIGN_ERROR.getMsg());
        }
        String url = String.format("%s/%s/%s/%s.rs", JLinkDomain.AMS_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_TOKEN.get(), timeMillis, signature);
        JLinkAesUtil aesUtils = new JLinkAesUtil();
        //body aes
        DeviceTokenDto dto = new DeviceTokenDto();
        List<String> strSn = new ArrayList<>();
        strSn.add(sn);
        dto.setSns(strSn);
        JLinkLog.i("GetDeviceToken Param:" + new Gson().toJson(dto));
        String key = aesUtils.keyFilter(timeMillis, jClient.getAppSecret());
        //body aes string
        String aesData = "";
        try {
            aesData = aesUtils.encryptToHexString(new Gson().toJson(dto), key);
        } catch (Exception e) {
            JLinkLog.e("aes error " + e.getMessage());
        }

        Map<String, String> headerParam = new HashMap<>();
        headerParam.put("uuid", jClient.getUuid());
        headerParam.put("appKey", jClient.getAppKey());
        String deviceTokenAes = JLinkHttpUtil.httpsRequest(url, "POST", headerParam, aesData);
        return decryptDeviceToken(deviceTokenAes, key, aesUtils);
    }

    private static class DeviceTokenDto {
        /**
         * devise serial number set
         */
        private List<String> sns;
        /**
         * Additional parameter accessToken; the current version can pass an empty string
         */
        private String accessToken;

        public List<String> getSns() {
            return sns;
        }

        public void setSns(List<String> sns) {
            this.sns = sns;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }

    private static String decryptDeviceToken(String deviceToken, String key, JLinkAesUtil aesUtils) {
        try {
            JLinkLog.i("AesDeviceToken:" + deviceToken);
            deviceToken = aesUtils.decryptToHexString(deviceToken, key);
            JLinkLog.i("DecryptDeviceToken:" + deviceToken);
        } catch (Exception e) {
            throw new JLinkException(JLinkResponseCode.AES_ERROR.getCode(), JLinkResponseCode.AES_ERROR.getMsg());
        }
        try {
            DeviceTokenResponse v3 = new Gson().fromJson(deviceToken, DeviceTokenResponse.class);
            return v3.getData().get(0).getToken();
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), deviceToken);
        }
    }


    public static class DeviceTokenV3 {

        private String msg;
        private Integer code;
        private List<DataDTO> data;

        public class DataDTO {
            private String sn;
            private String token;

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public List<DataDTO> getData() {
            return data;
        }

        public void setData(List<DataDTO> data) {
            this.data = data;
        }
    }


    public String getDeviceToken(JLinkClient jClient, String sn, String accessToken) {
        String url = String.format("%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_TOKEN_V3.get());
        DeviceTokenDto dto = new DeviceTokenDto();
        List<String> strSn = new ArrayList<>();
        strSn.add(sn);
        dto.setSns(strSn);
        dto.setAccessToken(accessToken);
        JLinkLog.i("GetDeviceToken Param:" + new Gson().toJson(dto));
        String res = JLinkHttpUtil.httpsRequest(url, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(dto));
        try {
            DeviceTokenV3 response = new Gson().fromJson(res, DeviceTokenV3.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response.getData().get(0).getToken();
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }
}
