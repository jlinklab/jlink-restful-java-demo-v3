package jlink.restful.java.demo;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.JLinkUser;
import jlink.restful.java.sdk.competent.JLinkDeviceAbilityEnum;
import jlink.restful.java.sdk.competent.JLinkDeviceConfigTypeEnum;
import jlink.restful.java.sdk.competent.JLinkDeviceResponseCode;
import jlink.restful.java.sdk.exception.*;
import jlink.restful.java.sdk.module.ability.DeviceAbilityResponse;
import jlink.restful.java.sdk.module.cloudstorage.DeviceCloudStorageAlarmRequest;
import jlink.restful.java.sdk.module.cloudstorage.DeviceCloudStoragePicResponse;
import jlink.restful.java.sdk.module.config.NetWorkDasConfig;
import jlink.restful.java.sdk.module.livestream.DeviceLiveStreamEnum;
import jlink.restful.java.sdk.module.login.DeviceLoginData;
import jlink.restful.java.sdk.module.opdev.PtzControl.PTZControlEnum;
import jlink.restful.java.sdk.module.opdev.PtzControl.PtzDirectionControlDTO;
import jlink.restful.java.sdk.module.status.DeviceStatusData;
import jlink.restful.java.sdk.module.usermanage.group.GroupsDTO;
import jlink.restful.java.sdk.module.usermanage.group.GroupsResponse;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JLinkDemo {

    public static void main(String[] args) {

        /**
         * uuid/appKey/appSecret/moveCard Apply for an application through the open platform (https://open.jftech.com) console, and obtain it after successful review
         */
        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        /**
         * account is the open platform appKey
         * pass is the open platform appSecret
         */
        JLinkUser jUser = new JLinkUser(jClient,"account","pass");

        /**
         * sn devise serial number；
         * devUsername Device login user name;
         * devPassword Device login password
         */
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");


        /**
         * Query device status
         */
        DeviceStatusData statusResponse;
        try {
            statusResponse = jDevice.deviceStatus();
            if (!statusResponse.getStatus().equals("online")) {
                JLinkLog.i("Device Offline");
                return;
            }
        } catch (JLinkDeviceStatusException e) {
            JLinkLog.e(e.toString());
            return;
        }

        /**
         * Get the live broadcast address; the device is online, no need to call the login interface
         * Advanced features require the use of JLinkUser
         */
        try {
            String liveStream = jDevice.deviceLivestream(DeviceLiveStreamEnum.STREAM_EXTRA.get(), DeviceLiveStreamEnum.MEDIATYPE_HLS.get(), DeviceLiveStreamEnum.PROTOCOL_TS.get());
            JLinkLog.i(liveStream);
        } catch (JLinkDeviceLiveStreamException e) {
            JLinkLog.e(e.toString());
        }

        /**
         * device login
         */
        DeviceLoginData loginResponse;
        try {
            loginResponse = jDevice.login();
            if (loginResponse.getRet() != JLinkDeviceResponseCode.SUCCESS.getCode()) {
                JLinkLog.i("Login Error:" + new Gson().toJson(loginResponse));
                return;
            } else {
                //Timing keep alive after successful login
                ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
                scheduledThreadPool.scheduleAtFixedRate(() -> jDevice.keepalive(), 1, 20, TimeUnit.SECONDS);
            }
        } catch (JLinkDeviceLoginException e) {
            JLinkLog.e(e.toString());
            return;
        }

        /**
         * Obtain the device capability set (take the system capability set as an example)
         */
        try {
            DeviceAbilityResponse.DevAbility response = jDevice.deviceAbility(JLinkDeviceAbilityEnum.SYSTEMFUNCTION);
            JLinkLog.i(new Gson().toJson(response));
        } catch (JLinkDeviceAbilityException e) {

        }

        /**
         * Get device configuration Take NetWorkDasConfig as an example
         */
        try {
            NetWorkDasConfig dasConfig;
            dasConfig = (NetWorkDasConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.NETWORKDAS);
            JLinkLog.i(new Gson().toJson(dasConfig));
            /**
             * Set the device configuration Take NetWorkDasConfig as an example
             * Get dasConfig from GetConfig request
             */
            try {
                dasConfig.getNetWorkDAS().setServerAddr("127.0.0.1");
                jDevice.setConfig(dasConfig);
            } catch (JLinkDeviceSetConfigException e) {
                JLinkLog.e("SetConfig Error:" + e);
            }
        } catch (JLinkDeviceGetConfigException e) {
            JLinkLog.e("GetConfig Error:" + e);
        }

        /**
         * Device operation: Take the gimbal steering as an example
         */
        try {
            PtzDirectionControlDTO ptzDirectionControlDTO = new PtzDirectionControlDTO();
            //Turn left on the gimbal
            ptzDirectionControlDTO.getOpptzControl().setCommand(PTZControlEnum.DirectionRight);
            //channel 1
            ptzDirectionControlDTO.getOpptzControl().getParameter().setChannel(0);
            //0~65535: start exercising -1: stop exercising
            ptzDirectionControlDTO.getOpptzControl().getParameter().setPreset(65535);
            //rotation speed
            ptzDirectionControlDTO.getOpptzControl().getParameter().setStep(6);
            jDevice.deviceOperate(ptzDirectionControlDTO);
        } catch (JLinkDeviceOperateException e) {
            JLinkLog.e("Operate Error:" + e);
        }

        /**
         * Device snapshot
         * channel
         * Advanced features require the use of JLinkUser
         */
        try {
            String picUrl = jDevice.capture(0);
            JLinkLog.i(picUrl);
        } catch (JLinkDeviceCaptureException e) {
            JLinkLog.e(e.toString());
        }

        /**
         * Get device cloud storage alarm pictures and videos
         */
        try {
            List<DeviceCloudStoragePicResponse.UrlDto> picUrl = jDevice.getPicUrl(Arrays.asList("135465"));
            String videoUrl = jDevice.getVideoUrl("2024-04-15 18:36:27", "2024-04-16 18:36:27");
        } catch (Exception e) {
            JLinkLog.e(e.toString());
        }

        /**
         * get device cloud storage alarm video list
         */
        try {
            jDevice.getVideoList("2024-03-21 13:11:35", "2024-03-22 13:13:35");
        } catch (Exception e) {
            JLinkLog.e(e.toString());
        }

        /**
         * get playback video thumbnail
         */
        try {
            jDevice.getVideoPicUrl(Arrays.asList(new DeviceCloudStorageAlarmRequest.GetVideoPicUrlParam("12341ffe886b812473_220701102122_1656642082.jpeg", "vid-01"),
                    new DeviceCloudStorageAlarmRequest.GetVideoPicUrlParam("12341ffe886b812473_220701102122_1656642082.jpeg", "vid-01")));
        } catch (Exception e) {
            JLinkLog.e(e.toString());
        }

        /**
         * Modify user information: Take obtaining user groups as an example
         * Advanced features require the use of JLinkUser
         */
        try {
            GroupsDTO dto = new GroupsDTO();
            GroupsResponse groups = (GroupsResponse) jDevice.userManage(dto);
            JLinkLog.i(new Gson().toJson(groups));
        } catch (JLinkDeviceUserManageException e) {
            JLinkLog.e(e.toString());
        }

        /**
         * Subscribe and unsubscribe to alert messages; no device online required
         * Advanced features require the use of JLinkUser
         */
        try {
            String callbackUrl = "https://subscribedemo.example.com";
            boolean subscribe = jDevice.subscribe(callbackUrl, jUser);
            JLinkLog.i("SubScribe:" + subscribe);
            boolean unSubscribe = jDevice.unSubscribe(jUser);
            JLinkLog.i("unSubScribe:" + unSubscribe);
        } catch (JLinkSubscribeException e) {
            JLinkLog.e(e.toString());
        }
    }
}
