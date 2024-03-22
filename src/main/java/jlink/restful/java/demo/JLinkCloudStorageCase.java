package jlink.restful.java.demo;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.JLinkUser;
import jlink.restful.java.sdk.competent.JLinkDeviceResponseCode;
import jlink.restful.java.sdk.module.cloudstorage.DeviceCloudStorageAlarmRequest;
import jlink.restful.java.sdk.module.login.DeviceLoginData;
import jlink.restful.java.sdk.module.opdev.opfilequery.OPFileQueryDTO;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.Arrays;

public class JLinkCloudStorageCase {
    public static void main(String[] args) {
        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");
        DeviceLoginData login = jDevice.login();
        jDevice.getDeviceToken();
        if (login.getRet() != JLinkDeviceResponseCode.SUCCESS.getCode()) {
            JLinkLog.i("login failed");
        }
        jDevice.getVideoPicUrl(Arrays.asList(new DeviceCloudStorageAlarmRequest.GetVideoPicUrlParam("c4f75aff9e622643_220630144544_1656571545.jpeg", "OBS_obs-cn-vid-01"),
                new DeviceCloudStorageAlarmRequest.GetVideoPicUrlParam("b11ffe8d6b812473_220701102122_1656642082.jpeg", "OBS_obs-cn-vid-01")));
    }

    private static void fileQuery(JLinkDevice jDevice){
        OPFileQueryDTO queryDTO = new OPFileQueryDTO();
        OPFileQueryDTO.OPFileQuery query = new OPFileQueryDTO.OPFileQuery();
        queryDTO.setOpFileQuery(query);
        query.setChannel(0);
        query.setType("jpg");
        query.setEvent("M");
//        query.setDriverTypeMask("0x0100");
        query.setDriverTypeMask("0x0000FFFF");
        query.setBeginTime("2022-04-28 18:00:00");
        query.setEndTime("2022-06-28 10:30:00");
        query.setStreamType(null);
        jDevice.deviceOperate(queryDTO);
    }
}
