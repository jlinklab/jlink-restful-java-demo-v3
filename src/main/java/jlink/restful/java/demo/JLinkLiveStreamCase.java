package jlink.restful.java.demo;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.module.livestream.DeviceLiveStreamEnum;
import jlink.restful.java.sdk.util.JLinkLog;

public class JLinkLiveStreamCase {

    public static void main(String[] args) {
        JLinkClient jClient = new JLinkClient(
                "your uuid",
                "your appKey",
                "your appSecret",
                6);
        JLinkDevice jDevice = new JLinkDevice(jClient, "your sn", "your device username", "your device password");


        String liveStream = jDevice.deviceLivestream(
                0,
                DeviceLiveStreamEnum.STREAM_EXTRA.get(),
                DeviceLiveStreamEnum.PROTOCOL_FLV.get(),
                "1757421726000"
        );
        JLinkLog.i(liveStream);
    }
}
