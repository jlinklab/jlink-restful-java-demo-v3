package jlink.restful.java.sdk.module.cloudstorage;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * Device cloud storage request
 *
 * @author hjm
 * @date 2024/05/29
 */
public class DeviceCloudStorageRequest {

    /**
     * @param sn
     * @param duration
     * @param devToken
     * @param mJLinkClient
     * @return {@link DeviceCloudStorageResponse}
     */
    public DeviceCloudStorageResponse startRecording(String sn, int duration, String devToken, JLinkClient mJLinkClient) {
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.START_RECORDING_VIDEO.get(), devToken);
        CloudStorageStartParam param = new CloudStorageStartParam();
        param.setSn(sn);
        param.setDuration(duration);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            return new Gson().fromJson(res, DeviceCloudStorageResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * @param sn
     * @param devToken
     * @param mJLinkClient
     * @return {@link DeviceCloudStorageResponse}
     */
    public DeviceCloudStorageResponse stopRecording(String sn, String devToken, JLinkClient mJLinkClient) {
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.STOP_RECORDING_VIDEO.get(), devToken);
        CloudStorageStartParam param = new CloudStorageStartParam();
        param.setSn(sn);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            return new Gson().fromJson(res, DeviceCloudStorageResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


    private static class CloudStorageStartParam {
        @SerializedName("sn")
        private String sn;
        @SerializedName("duration")
        private int duration;

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }

    private static class CloudStorageStopParam {
        @SerializedName("sn")
        private String sn;

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }
    }
}
