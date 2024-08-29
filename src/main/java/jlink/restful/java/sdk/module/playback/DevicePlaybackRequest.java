package jlink.restful.java.sdk.module.playback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import org.apache.commons.lang3.StringUtils;


/**
 * Playback
 *
 * @author hjm
 * @date 2024/04/24
 */
public class DevicePlaybackRequest {

    /**
     * playback Request
     *
     * @param channel
     * @param stream
     * @param protocol
     * @param startTime
     * @param endTime
     * @param fileName
     * @param encryptType
     * @param devUser
     * @param devPass
     * @param loginToken
     * @param download
     * @param playPrioritize
     * @param devToken
     * @param mJLinkClient
     * @return {@link String}
     */
    public String devicePlayback(int channel, int stream, String protocol, String startTime, String endTime, String fileName, String encryptType, String devUser, String devPass, String loginToken, int download, int playPrioritize, String devToken, JLinkClient mJLinkClient) {
        DevicePlaybackResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_PLAYBACKSTREAM.get(), devToken);
        PlayBackParam param = new PlayBackParam();
        param.setChannel(channel);
        param.setStreamType(stream);
        if (null != protocol && !"".equals(protocol)) param.setProtocol(protocol);
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setFileName(fileName);
        if (null != encryptType && encryptType.equals("TOKEN")) {
            param.setEncryptType(encryptType);
            param.setLoginToken(loginToken);
        } else {
            param.setUsername(devUser);
            param.setDevPwd(devPass);
        }
        param.setDownload(download);
        param.setPlayPrioritize(playPrioritize);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DevicePlaybackResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response.getData().getUrl();
            } else {
                //RESTFul API request status code judgment
                throw new JLinkException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public String playbackTimelineListImpl(String sn, String beginTime, String endTime, String event, int lowChannel, String lowStreamType, int highChannel, String highStreamType, String type, String devToken, JLinkClient mJLinkClient) {
        DevicePlaybackTimeLineResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.PLAYBACK_TIMELINELIST.get(), devToken);
        PlaybackTimeline param = new PlaybackTimeline();
        param.setSn(sn);
        PlaybackTimeline.OPFileQueryTempDto dto = new PlaybackTimeline.OPFileQueryTempDto();
        dto.setBeginTime(beginTime);
        dto.setEndTime(endTime);
        dto.setEvent(StringUtils.isNotBlank(event) ? event : "*");
        dto.setLowChannel(lowChannel);
        dto.setLowStreamType(StringUtils.isNotBlank(lowStreamType) ? lowStreamType : "0x00000000");
        dto.setHighChannel(highChannel);
        dto.setHighStreamType(StringUtils.isNotBlank(highStreamType) ? highStreamType : "0x00000000");
        dto.setType(StringUtils.isNotBlank(type) ? type : "h264");
        param.setDto(dto);
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DevicePlaybackTimeLineResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return new Gson().toJson(response);
            } else {
                throw new JLinkException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    private static class PlaybackTimeline {
        /**
         * Device Sn
         */
        @SerializedName("Sn")
        private String sn;
        @SerializedName("Name")
        private String name = "OPFileQuery";
        @SerializedName("OPFileQuery")
        private OPFileQueryTempDto dto;

        public static class OPFileQueryTempDto {
            @SerializedName("BeginTime")
            private String beginTime;
            @SerializedName("EndTime")
            private String endTime;
            @SerializedName("Event")
            private String event = "*";
            @SerializedName("HighChannel")
            private int highChannel = 0;
            @SerializedName("HighStreamType")
            private String highStreamType = "0x00000000";
            @SerializedName("LowChannel")
            private int lowChannel = 1;
            @SerializedName("LowStreamType")
            private String lowStreamType = "0x00000000";
            @SerializedName("Sync")
            private int sync = 0;
            @SerializedName("Type")
            private String type = "h264";

            public String getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(String beginTime) {
                this.beginTime = beginTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getEvent() {
                return event;
            }

            public void setEvent(String event) {
                this.event = event;
            }

            public int getHighChannel() {
                return highChannel;
            }

            public void setHighChannel(int highChannel) {
                this.highChannel = highChannel;
            }

            public String getHighStreamType() {
                return highStreamType;
            }

            public void setHighStreamType(String highStreamType) {
                this.highStreamType = highStreamType;
            }

            public int getLowChannel() {
                return lowChannel;
            }

            public void setLowChannel(int lowChannel) {
                this.lowChannel = lowChannel;
            }

            public String getLowStreamType() {
                return lowStreamType;
            }

            public void setLowStreamType(String lowStreamType) {
                this.lowStreamType = lowStreamType;
            }

            public int getSync() {
                return sync;
            }

            public void setSync(int sync) {
                this.sync = sync;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OPFileQueryTempDto getDto() {
            return dto;
        }

        public void setDto(OPFileQueryTempDto dto) {
            this.dto = dto;
        }
    }

    /**
     * playbackParameters
     *
     * @author hjm
     * @date 2022/04/22
     */
    private static class PlayBackParam {

        /**
         * protocol     hls/rtsp(default)/rtsp-pri/flv
         */
        private String protocol;
        /**
         * fileName
         */
        private String fileName;
        /**
         * channel
         */
        private int channel;
        /**
         * advocateComplementaryCodeFlow
         */
        private int streamType;
        /**
         * userName
         */
        private String username;
        /**
         * dev pwd
         */
        private String devPwd;
        /**
         * encryptType
         */
        private String encryptType;

        /**
         * loginToken    encryptType == "TOKEN",need loginToken
         */
        private String loginToken;

        /**
         * startTime    YYYY-mm-dd HH:MM:SS
         */
        private String startTime;

        /**
         * endOfTime   YYYY-mm-dd HH:MM:SS
         */
        private String endTime;

        /**
         * download    0:play(default)    1:download
         */
        private int download;

        /**
         * playPrioritize   0~2;
         */
        private int playPrioritize;

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getEncryptType() {
            return encryptType;
        }

        public void setEncryptType(String encryptType) {
            this.encryptType = encryptType;
        }

        public String getLoginToken() {
            return loginToken;
        }

        public void setLoginToken(String loginToken) {
            this.loginToken = loginToken;
        }

        public int getDownload() {
            return download;
        }

        public void setDownload(int download) {
            this.download = download;
        }

        public int getPlayPrioritize() {
            return playPrioritize;
        }

        public void setPlayPrioritize(int playPrioritize) {
            this.playPrioritize = playPrioritize;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public int getStreamType() {
            return streamType;
        }

        public void setStreamType(int streamType) {
            this.streamType = streamType;
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

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }

    public String cardPlaybackCalendarImpl(String sn, String event, int channel, int month, int year, String type, String devToken, JLinkClient mJLinkClient) {
        CardPlaybackCalendarResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.CARD_PLAYBACK_CALENDAR.get(), devToken);
        CardPlaybackCalendar param = new CardPlaybackCalendar();
        param.setSn(sn);
        CardPlaybackCalendar.OPSCalendar dto = new CardPlaybackCalendar.OPSCalendar();
        dto.setEvent(StringUtils.isNotBlank(event) ? event : "*");
        dto.setChannel(channel);
        dto.setMonth(month);
        dto.setYear(year);
        dto.setFileType(StringUtils.isNotBlank(type) ? type : "h264");
        param.setOpsCalendar(dto);
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, CardPlaybackCalendarResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return new Gson().toJson(response);
            } else {
                throw new JLinkException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public static class CardPlaybackCalendar {
        @SerializedName("Sn")
        private String sn;
        @SerializedName("Name")
        private String name = "OPSCalendar";
        @SerializedName("OPSCalendar")
        private OPSCalendar opsCalendar;

        private static class OPSCalendar {

            @SerializedName("Event")
            private String event;
            @SerializedName("Channel")
            private Integer channel;
            @SerializedName("FileType")
            private String fileType;
            @SerializedName("Month")
            private Integer month;
            @SerializedName("Year")
            private Integer year;

            public String getEvent() {
                return event;
            }

            public void setEvent(String event) {
                this.event = event;
            }

            public Integer getChannel() {
                return channel;
            }

            public void setChannel(Integer channel) {
                this.channel = channel;
            }

            public String getFileType() {
                return fileType;
            }

            public void setFileType(String fileType) {
                this.fileType = fileType;
            }

            public Integer getMonth() {
                return month;
            }

            public void setMonth(Integer month) {
                this.month = month;
            }

            public Integer getYear() {
                return year;
            }

            public void setYear(Integer year) {
                this.year = year;
            }
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OPSCalendar getOpsCalendar() {
            return opsCalendar;
        }

        public void setOpsCalendar(OPSCalendar opsCalendar) {
            this.opsCalendar = opsCalendar;
        }
    }
}
