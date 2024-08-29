package jlink.restful.java.sdk.competent;

/**
 * RESTFul API Enum
 */
public enum JLinkDeviceRequestUrl {
    /**
     * bind device
     */
    DEVICE_BIND("v3/rtc/device/bind"),
    /**
     * unbind device
     */
    DEVICE_UNBIND("v3/rtc/device/unbind"),
    /**
     * AMS DeviceToken
     */
    DEVICE_TOKEN("v3/deviceToken"),
    /**
     * loginToken
     */
    LOGIN_TOKEN("v3/rtc/device/queryLoginToken"),

    /**
     * Device LIST
     */
    DEVICE_LIST("v3/rtc/device/list"),
    /**
     * capture
     */
    DEVICE_CAPTURE("v3/rtc/device/capture"),
    /*
     * get pic url
     */
    DEVICE_GETPICURL("v3/rtc/device/getPicUrl"),
    /**
     * get video url
     */
    DEVICE_GETVIDEOURL("v3/rtc/device/getVideoUrl"),
    /**
     * get video list
     */
    DEVICE_GETVIDEOLIST("v3/rtc/device/getVideoList"),
    /**
     * get playback video thumbnail
     */
    DEVICE_GETVIDEOPICURL("v3/rtc/device/getVideoPicUrl"),
    /**
     * getability
     */
    DEVICE_GETABILITY("v3/rtc/device/getability"),
    /**
     * getconfig
     */
    DEVICE_GETCONFIG("v3/rtc/device/getconfig"),
    /**
     * getinfo
     */
    DEVICE_INFO("v3/rtc/device/getinfo"),
    /**
     * RESTFul API keepalive
     */
    DEVICE_KEEPALIVE("v3/rtc/device/keepalive"),
    /**
     * livestream
     */
    DEVICE_LIVESTREAM("v3/rtc/device/livestream"),
    /**
     * login
     */
    DEVICE_LOGIN("v3/rtc/device/login"),
    /**
     * opdev
     */
    DEVICE_OPDEV("v3/rtc/device/opdev"),
    /**
     * playbackUrl
     */
    DEVICE_PLAYBACKSTREAM("v3/rtc/device/playbackUrl"),
    /**
     * setconfig
     */
    DEVICE_SETCONFIG("v3/rtc/device/setconfig"),
    /**
     * status
     */
    DEVICE_STATUS("v3/rtc/device/status"),
    /**
     * user manage
     */
    DEVICE_USERMANAGE("v3/rtc/device/usermanage"),
    /**
     * wakeup
     */
    DEVICE_WAKEUP("v3/rtc/device/wakeup"),
    /**
     * subscribeMessage
     */
    SUBSCRIBE_MESSAGE("v3/rtc/device/subscribeMessage"),
    /**
     * unsubscribeMessage
     */
    UNSUBSCRIBE_MESSAGE("v3/rtc/device/unsubscribeMessage"),
    /**
     * alarm list
     */
    CLOUD_ALARM_LIST("v3/rtc/device/getDeviceAlarmList"),
    /**
     * device Local Pic
     */
    DEVICE_LOCAL_PIC("v3/rtc/device/getDeviceLocalPic"),
    /**
     * customConfiguration
     */
    TAILORED_CONFIG("v3/rtc/device/getTailoredConfig"),

    PLAYBACK_TIMELINELIST("v3/rtc/device/playbackTimelineList"),
    CARD_PLAYBACK_CALENDAR("v3/rtc/device/cardPlaybackCalendar"),
    TALKBACK_URL("v3/rtc/device/talkbackUrl"),

    MEDIA_CONVERT("v3/rtc/device/mediaConvert"),

    START_RECORDING_VIDEO("v3/rtc/device/startRecordingVideo"),
    STOP_RECORDING_VIDEO("v3/rtc/device/stopRecordingVideo");


    private String requestUrl;

    JLinkDeviceRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String get() {
        return requestUrl;
    }

    public void set(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
