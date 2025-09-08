package jlink.restful.java.sdk.module.livestream;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceLiveStreamException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Device Get MediaUrls Request
 *
 * @author hjm
 * @date 2024/11/25
 */
public class DeviceMediaUrlsRequest {

    public DeviceMediaUrlsResponse getMediaUrls(String user, String pass, int userMax, String expireTime, List<MediaInfo> mediaInfos, String devToken, JLinkClient jClient) {
        return urls(user, pass, userMax, expireTime, mediaInfos, devToken, jClient);
    }

    public DeviceMediaUrlsResponse getAllDefaultMediaUrls(String user, String pass, String devToken, JLinkClient jClient) {
        List<MediaInfo> mediaInfos = new ArrayList<>();
        //HLS
        MediaInfo m1 = new MediaInfo();
        m1.setMediaType(DeviceLiveStreamEnum.PROTOCOL_HLS_TS.get());
        mediaInfos.add(m1);
        //RTSP
        MediaInfo m2 = new MediaInfo();
        m2.setMediaType(DeviceLiveStreamEnum.PROTOCOL_RTSP_SDP.get());
        mediaInfos.add(m2);
        //RTMP
        MediaInfo m3 = new MediaInfo();
        m3.setMediaType(DeviceLiveStreamEnum.PROTOCOL_RTMP_FLV.get());
        mediaInfos.add(m3);
        //FLV
        MediaInfo m4 = new MediaInfo();
        m4.setMediaType(DeviceLiveStreamEnum.PROTOCOL_FLV.get());
        mediaInfos.add(m4);
        //WEBRTC
        MediaInfo m5 = new MediaInfo();
        m5.setMediaType(DeviceLiveStreamEnum.PROTOCOL_WEBRTC.get());
        mediaInfos.add(m5);
        //WS
        MediaInfo m6 = new MediaInfo();
        m6.setMediaType(DeviceLiveStreamEnum.PROTOCOL_WS_FLV.get());
        mediaInfos.add(m6);
        return urls(user, pass, 10, String.valueOf(System.currentTimeMillis() + 36000000), mediaInfos, devToken, jClient);
    }


    /**
     * @param user
     * @param pass
     * @param userMax
     * @param expireTime
     * @param mediaInfos
     * @param devToken
     * @param jClient
     * @return {@link String}
     */
    private DeviceMediaUrlsResponse urls(String user, String pass, int userMax, String expireTime, List<MediaInfo> mediaInfos, String devToken, JLinkClient jClient) {
        DeviceMediaUrlsResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETMEDIAURLS.get(), devToken);
        MediaUrlsParam param = new MediaUrlsParam();
        param.setUsername(user);
        param.setPassword(pass);
        param.setUserMax(userMax);
        param.setExpireTime(expireTime);

        param.setMediaInfos(mediaInfos);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceMediaUrlsResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceLiveStreamException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * MediaUrlsParam
     */
    public static class MediaUrlsParam {
        /**
         * userName
         */
        private String username;
        /**
         * dev pwd
         */
        private String password;
        /**
         * userMax
         */
        private int userMax;
        /**
         * dueToTime
         */
        private String expireTime;

        private List<MediaInfo> mediaInfos;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getUserMax() {
            return userMax;
        }

        public void setUserMax(int userMax) {
            this.userMax = userMax;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public List<MediaInfo> getMediaInfos() {
            return mediaInfos;
        }

        public void setMediaInfos(List<MediaInfo> mediaInfos) {
            this.mediaInfos = mediaInfos;
        }
    }

    public static class MediaInfo {
        private String mediaType;
        private String type;
        private int channel;
        private int stream;
        @SerializedName("vcode")
        private String vCode;
        @SerializedName("acode")
        private String aCode;

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public int getStream() {
            return stream;
        }

        public void setStream(int stream) {
            this.stream = stream;
        }

        public String getvCode() {
            return vCode;
        }

        public void setvCode(String vCode) {
            this.vCode = vCode;
        }

        public String getaCode() {
            return aCode;
        }

        public void setaCode(String aCode) {
            this.aCode = aCode;
        }
    }
}
