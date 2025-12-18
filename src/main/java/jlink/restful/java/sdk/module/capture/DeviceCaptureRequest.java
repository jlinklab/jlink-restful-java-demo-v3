package jlink.restful.java.sdk.module.capture;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDeviceResponseCode;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceCaptureException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * Device Capture Request
 *
 * @author hjm
 * @date 2022/04/21
 */
public class DeviceCaptureRequest {

    public String deviceCapture(int channel, String devToken, JLinkClient mJLinkClient) {
        return deviceCapture(channel, devToken, mJLinkClient, 60000);
    }

    public String deviceCapture(int channel, String devToken, JLinkClient mJLinkClient, int timeout) {
        DeviceCaptureResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_CAPTURE.get(), devToken);
        CaptureParam param = new CaptureParam();
        param.setName("OPSNAP");
        CaptureParam.OPSNAPDTO opsnapdto = new CaptureParam.OPSNAPDTO();
        opsnapdto.setChannel(channel);
        opsnapdto.setPicType(1);
        param.setOpsnapdto(opsnapdto);
        //send https request
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param), timeout);
        try {
            response = new Gson().fromJson(res, DeviceCaptureResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response.getData().getImage();
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceCaptureException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceCaptureException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public DeviceCaptureTimeConfigResponse setCaptureTimeConfig(boolean enable, int interval, String timeFrame, String week, String devToken, JLinkClient mJLinkClient) {
        DeviceCaptureTimeConfigResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_SET_CAPTURE_TIME_CONFIG.get(), devToken);
        TimeConfig param = new TimeConfig();
        param.setEnable(enable);
        param.setInterval(interval);
        param.setTimeFrame(timeFrame);
        param.setWeek(week);
        //send https request
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceCaptureTimeConfigResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceCaptureException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public DeviceCaptureTimeConfigResponse getCaptureTimeConfig(String devToken, JLinkClient mJLinkClient) {
        DeviceCaptureTimeConfigResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GET_CAPTURE_TIME_CONFIG.get(), devToken);
        //send https request
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), "");
        try {
            response = new Gson().fromJson(res, DeviceCaptureTimeConfigResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceCaptureException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    private static class TimeConfig {
        @SerializedName("Enable")
        private Boolean enable;
        @SerializedName("Interval")
        private Integer interval;
        @SerializedName("Week")
        private String week;
        @SerializedName("TimeFrame")
        private String timeFrame;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public Integer getInterval() {
            return interval;
        }

        public void setInterval(Integer interval) {
            this.interval = interval;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getTimeFrame() {
            return timeFrame;
        }

        public void setTimeFrame(String timeFrame) {
            this.timeFrame = timeFrame;
        }
    }

    /**
     * Capture Parameters
     *
     * @author hjm
     * @date 2022/04/22
     */
    private static class CaptureParam {
        @SerializedName("Name")
        private String name;
        @SerializedName("OPSNAP")
        private OPSNAPDTO opsnapdto;
        @SerializedName("userToken")
        private String userToken;

        private static class OPSNAPDTO {
            @SerializedName("Channel")
            private int channel;
            @SerializedName("picType")
            private int picType;

            public int getChannel() {
                return channel;
            }

            public void setChannel(int channel) {
                this.channel = channel;
            }

            public int getPicType() {
                return picType;
            }

            public void setPicType(int picType) {
                this.picType = picType;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OPSNAPDTO getOpsnapdto() {
            return opsnapdto;
        }

        public void setOpsnapdto(OPSNAPDTO opsnapdto) {
            this.opsnapdto = opsnapdto;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
