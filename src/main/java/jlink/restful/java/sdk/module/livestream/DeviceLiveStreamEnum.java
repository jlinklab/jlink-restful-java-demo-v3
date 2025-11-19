package jlink.restful.java.sdk.module.livestream;

/**
 * Device LiveStream Enum
 *
 * @author hjm
 * @date 2022/04/21
 */
public enum DeviceLiveStreamEnum {
    STREAM_MAIN("0"),
    STREAM_EXTRA("1"),
    PROTOCOL_FLV("flv"),
    PROTOCOL_FLV_ENHANCED("flv-enhanced"),
    PROTOCOL_HLS_TS("hls-ts"),
    PROTOCOL_HLS_MP4("hls-fmp4"),
    PROTOCOL_MP4("mp4"),
    PROTOCOL_WS_PRI("ws-pri"),
    PROTOCOL_WS_FLV("ws-flv"),
    PROTOCOL_WS_FLV_ENHANCED("ws-flv-enhanced"),
    PROTOCOL_RTSP_SDP("rtsp-sdp"),
    PROTOCOL_RTSP_PRI("rtsp-pri"),
    PROTOCOL_RTMP_FLV("rtmp"),
    PROTOCOL_RTMP_ENHANCED("rtmp-enhanced"),
    PROTOCOL_WEBRTC("webrtc"),
    ;

    private String streamParam;

    DeviceLiveStreamEnum(String streamParam) {
        this.streamParam = streamParam;
    }

    public static DeviceLiveStreamEnum get(String streamParam) {
        for (DeviceLiveStreamEnum value : values()) {
            if (streamParam.equals(value.get())) {
                return value;
            }
        }
        return PROTOCOL_HLS_TS;
    }

    public String get() {
        return streamParam;
    }
}
