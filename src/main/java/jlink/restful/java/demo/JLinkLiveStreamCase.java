package jlink.restful.java.demo;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.JLinkUser;
import jlink.restful.java.sdk.module.livestream.DeviceLiveStreamEnum;
import jlink.restful.java.sdk.util.JLinkLog;

public class JLinkLiveStreamCase {

    public static void main(String[] args) {
        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkUser jUser = new JLinkUser(jClient);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");


        String liveStream = jDevice.deviceLivestream(
                0,
                DeviceLiveStreamEnum.STREAM_EXTRA.get(),
                DeviceLiveStreamEnum.MEDIATYPE_HLS.get(),
                DeviceLiveStreamEnum.PROTOCOL_TS.get(),
                jUser
        );
        JLinkLog.i(liveStream);
    }
}
