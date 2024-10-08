package jlink.restful.java.sdk.module.livestream;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceLiveStreamException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * Device LiveStream Request
 *
 * @author hjm
 * @date 2022/04/21
 */
public class DeviceLiveStreamRequest {

    public String deviceLivestream(String user, String pass, String channel, String stream, String mediaType, String protocol, String userToken, String devToken, JLinkClient jClient) {
        return deviceLivestream(user, pass, channel, stream, mediaType, protocol, null, null, null, userToken, devToken, jClient);
    }

    public String deviceLivestream(String user, String pass, String channel, String stream, String mediaType, String protocol, String devToken, JLinkClient jClient) {
        return deviceLivestream(user, pass, channel, stream, mediaType, protocol, null, null, null, null, devToken, jClient);
    }

    public String deviceLivestream(String user, String pass, String channel, String stream, String mediaType, String protocol, String expireTime, String videoCode, String audioCode, String devToken, JLinkClient jClient) {
        return deviceLivestream(user, pass, channel, stream, mediaType, protocol, null, null, null, null, devToken, jClient);
    }


    /**
     * @param devToken
     * @param user
     * @param pass
     * @param channel
     * @param stream
     * @param mediaType
     * @param protocol
     * @param userToken
     * @return {@link DeviceLiveStreamResponse.DataDTO}
     */
    public String deviceLivestream(String user, String pass, String channel, String stream, String mediaType, String protocol, String expireTime, String videoCode, String audioCode, String userToken, String devToken, JLinkClient jClient) {
        DeviceLiveStreamResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_LIVESTREAM.get(), devToken);
        LiveStreamParam param = new LiveStreamParam();
        param.setMediaType(mediaType);
        param.setChannel(channel);
        param.setStream(stream);
        param.setProtocol(protocol);
        param.setUsername(user);
        param.setDevPwd(pass);
        if (null != expireTime && !"".equals(expireTime)) param.setExpireTime(expireTime);
        if (null != videoCode && !"".equals(videoCode)) param.setVideoCode(videoCode);
        if (null != audioCode && !"".equals(audioCode)) param.setAudioCode(audioCode);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceLiveStreamResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response.getData().getUrl();
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceLiveStreamException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceLiveStreamException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * videoStreamParameters
     *
     * @author hjm
     * @date 2022/04/22
     */
    private static class LiveStreamParam {
        /**
         * mediaType
         */
        private String mediaType;
        /**
         * channel
         */
        private String channel;
        /**
         * flow
         */
        private String stream;
        /**
         * userName
         */
        private String username;
        /**
         * dev pwd
         */
        private String devPwd;
        private String password;
        /**
         * agreement
         */
        private String protocol;
        /**
         * userToken
         */
        private String userToken;

        /**
         * dueToTime
         */
        public String expireTime;

        public String videoCode;

        public String audioCode;

        public String getAudioCode() {
            return audioCode;
        }

        public void setAudioCode(String audioCode) {
            this.audioCode = audioCode;
        }

        public String getVideoCode() {
            return videoCode;
        }

        public void setVideoCode(String videoCode) {
            this.videoCode = videoCode;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getStream() {
            return stream;
        }

        public void setStream(String stream) {
            this.stream = stream;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDevPwd() {
            return devPwd;
        }

        public void setDevPwd(String devPwd) {
            this.devPwd = devPwd;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
