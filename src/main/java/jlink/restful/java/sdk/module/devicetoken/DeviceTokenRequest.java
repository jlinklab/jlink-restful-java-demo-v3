package jlink.restful.java.sdk.module.devicetoken;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.ArrayList;
import java.util.List;

/**
 * DeviceToken Request
 */
public class DeviceTokenRequest {
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

    public String getDeviceToken(JLinkClient jClient, String sn) {
        return getDeviceToken(jClient, sn, "");
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
