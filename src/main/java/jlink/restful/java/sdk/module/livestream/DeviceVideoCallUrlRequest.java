package jlink.restful.java.sdk.module.livestream;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceLiveStreamException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Device VideoCall Request
 *
 * @author hjm
 * @date 2026/01/15
 */
public class DeviceVideoCallUrlRequest {

    /**
     * @param protocol
     * @param channel
     * @param user
     * @param pass
     * @param audioCodePlayer
     * @param audioAccuracyPlayer
     * @param videoPlayer
     * @param widthPlayer
     * @param heightPlayer
     * @param fpsPlayer
     * @param audioKHZPlayer
     * @param devToken
     * @param jClient
     * @return {@link String}
     */
    public String deviceVideoCallUrl(String protocol, String channel, String user, String pass, String audioCodePlayer, String audioAccuracyPlayer,
                                     String videoPlayer, String widthPlayer, String heightPlayer, String fpsPlayer, String audioKHZPlayer, String devToken, JLinkClient jClient) {
        DeviceVideoCallUrlResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.VIDEO_CALL_URL.get(), devToken);
        VideoCallParam param = new VideoCallParam();
        param.setProtocol(protocol);
        param.setChannel(channel);
        param.setUsername(user);
        param.setPassword(pass);
        param.setAudioCodePlayer(StringUtils.isNotBlank(audioCodePlayer) ? audioCodePlayer : "g711a");
        param.setAudioAccuracyPlayer(StringUtils.isNotBlank(audioAccuracyPlayer) ? audioAccuracyPlayer : "16");
        param.setVideoPlayer(StringUtils.isNotBlank(videoPlayer) ? videoPlayer : "h264");
        param.setWidthPlayer(StringUtils.isNotBlank(widthPlayer) ? widthPlayer : "360");
        param.setHeightPlayer(StringUtils.isNotBlank(heightPlayer) ? heightPlayer : "640");
        param.setFpsPlayer(StringUtils.isNotBlank(fpsPlayer) ? fpsPlayer : "12");
        param.setAudioKHZPlayer(StringUtils.isNotBlank(audioKHZPlayer) ? audioKHZPlayer : "8000");

        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceVideoCallUrlResponse.class);
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
     * @date 2026/01/15
     */
    private static class VideoCallParam {
        /**
         * protocol
         */
        private String protocol;
        /**
         * channel
         */
        private String channel;

        /**
         * userName
         */
        private String username;

        private String password;

        public String audioCodePlayer;
        public String audioAccuracyPlayer;
        public String videoPlayer;
        public String widthPlayer;
        public String heightPlayer;
        public String fpsPlayer;
        public String audioKHZPlayer;

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
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

        public String getAudioCodePlayer() {
            return audioCodePlayer;
        }

        public void setAudioCodePlayer(String audioCodePlayer) {
            this.audioCodePlayer = audioCodePlayer;
        }

        public String getAudioAccuracyPlayer() {
            return audioAccuracyPlayer;
        }

        public void setAudioAccuracyPlayer(String audioAccuracyPlayer) {
            this.audioAccuracyPlayer = audioAccuracyPlayer;
        }

        public String getVideoPlayer() {
            return videoPlayer;
        }

        public void setVideoPlayer(String videoPlayer) {
            this.videoPlayer = videoPlayer;
        }

        public String getWidthPlayer() {
            return widthPlayer;
        }

        public void setWidthPlayer(String widthPlayer) {
            this.widthPlayer = widthPlayer;
        }

        public String getHeightPlayer() {
            return heightPlayer;
        }

        public void setHeightPlayer(String heightPlayer) {
            this.heightPlayer = heightPlayer;
        }

        public String getFpsPlayer() {
            return fpsPlayer;
        }

        public void setFpsPlayer(String fpsPlayer) {
            this.fpsPlayer = fpsPlayer;
        }

        public String getAudioKHZPlayer() {
            return audioKHZPlayer;
        }

        public void setAudioKHZPlayer(String audioKHZPlayer) {
            this.audioKHZPlayer = audioKHZPlayer;
        }
    }
}
