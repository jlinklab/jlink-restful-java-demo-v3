package jlink.restful.java.demo;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.JLinkUser;
import jlink.restful.java.sdk.module.opdev.opfilequery.OPFileQueryDTO;
import jlink.restful.java.sdk.module.opdev.opfilequery.OPFileQueryResponse;
import jlink.restful.java.sdk.util.JLinkLog;

public class JLinkLocalPicCase {

    public static void main(String[] args) {
        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkUser jUser = new JLinkUser(jClient);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");

        jDevice.deviceStatus();
        //get file list
        OPFileQueryDTO dto = new OPFileQueryDTO();
        dto.getOpFileQuery().setBeginTime("2024-02-16 16:11:06");
        dto.getOpFileQuery().setEndTime("2024-02-18 16:11:06");
        dto.getOpFileQuery().setChannel(0);
        dto.getOpFileQuery().setType("jpg");
        dto.getOpFileQuery().setStreamType("0x00000000");
        OPFileQueryResponse response = (OPFileQueryResponse) jDevice.deviceOperate(dto);

        if (null != response.getOPFileQuery() && response.getOPFileQuery().size() > 0) {
            String fileName = response.getOPFileQuery().get(0).getFileName();
            String startTime = response.getOPFileQuery().get(0).getBeginTime();
            String endTime = response.getOPFileQuery().get(0).getEndTime();
            String image = jDevice.deviceLocalPic(
                    startTime,
                    endTime,
                    fileName,
                    jUser
            );
            JLinkLog.i(image);
        }
    }
}
