package jlink.restful.java.sdk.module.livestream;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceLiveStreamException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * Device Talkback Request
 *
 * @author hjm
 * @date 2024/08/30
 */
public class DeviceTalkbackUrlRequest {

    public String deviceTalkbackUrl(String mediaType, String user, String pass, String channel, String devToken, JLinkClient jClient) {
        return talkbackUrl(mediaType, user, pass, channel, "aac", devToken, jClient);
    }


    /**
     * @param mediaType
     * @param user
     * @param pass
     * @param channel
     * @param audioCode
     * @param devToken
     * @param jClient
     * @return {@link String}
     */
    public String talkbackUrl(String mediaType, String user, String pass, String channel, String audioCode, String devToken, JLinkClient jClient) {
        DeviceTalkbackUrlResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.TALKBACK_URL.get(), devToken);
        TalkbackParam param = new TalkbackParam();
        param.setMediaType(mediaType);
        param.setChannel(channel);
        param.setUsername(user);
        param.setPassword(pass);

        if (null != audioCode && !"".equals(audioCode)) param.setAudioCode(audioCode);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceTalkbackUrlResponse.class);
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
    private static class TalkbackParam {
        /**
         * mediaType
         */
        private String mediaType;
        /**
         * channel
         */
        private String channel;

        /**
         * userName
         */
        private String username;

        private String password;

        public String audioCode;

        public String getAudioCode() {
            return audioCode;
        }

        public void setAudioCode(String audioCode) {
            this.audioCode = audioCode;
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
    }
}
