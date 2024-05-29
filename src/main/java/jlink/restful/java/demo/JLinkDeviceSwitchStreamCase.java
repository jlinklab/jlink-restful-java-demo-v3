package jlink.restful.java.demo;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.competent.JLinkDeviceConfigTypeEnum;
import jlink.restful.java.sdk.module.config.ExtRecordConfig;
import jlink.restful.java.sdk.module.config.RecordConfig;

public class JLinkDeviceSwitchStreamCase {
    public static void main(String[] args) throws Exception {

        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");
        SwitchMainStream(jDevice, jClient);
        SwitchExtraStream(jDevice, jClient);
    }


    /**
     * Switch main stream
     *
     * @param jDevice
     * @param jClient
     * @return {@link Object}
     */
    private static void SwitchMainStream(JLinkDevice jDevice, JLinkClient jClient) {
        ExtRecordConfig extRecordConfig = (ExtRecordConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.EXTRECORD);
        extRecordConfig.getRecordDTOS().get(0).setRecordMode("ClosedRecord");
        jDevice.setConfig(extRecordConfig);
        RecordConfig recordConfig = (RecordConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.RECORD);
        recordConfig.getRecordDTOS().get(0).setRecordMode("ManualRecord");
        jDevice.setConfig(recordConfig);
    }

    /**
     * Switch extra stream
     *
     * @param jDevice
     * @param jClient
     * @return {@link Object}
     */
    private static void SwitchExtraStream(JLinkDevice jDevice, JLinkClient jClient) {
        RecordConfig recordConfig = (RecordConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.RECORD);
        recordConfig.getRecordDTOS().get(0).setRecordMode("ClosedRecord");
        jDevice.setConfig(recordConfig);
        ExtRecordConfig extRecordConfig = (ExtRecordConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.EXTRECORD);
        extRecordConfig.getRecordDTOS().get(0).setRecordMode("ManualRecord");
        jDevice.setConfig(extRecordConfig);
    }
}
