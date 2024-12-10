package jlink.restful.java.demo;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.competent.JLinkDeviceConfigTypeEnum;
import jlink.restful.java.sdk.competent.JLinkDeviceResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceGetConfigException;
import jlink.restful.java.sdk.exception.JLinkDeviceLoginException;
import jlink.restful.java.sdk.module.config.NetWorkNetDDNSConfig;
import jlink.restful.java.sdk.module.login.DeviceLoginData;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NetDDNSCase {

    public static void main(String[] args) {

        /**
         * uuid/appKey/appSecret/moveCard Apply for an application through the open platform (https://open.jftech.com) console, and obtain it after successful review
         */
        JLinkClient jClient = new JLinkClient(
                "${uuid}",
                "${appKey}",
                "${appSecret}",
                0);
        /**
         * sn devise serial number；
         * devUsername Device login user name;
         * devPassword Device login password
         */
        JLinkDevice jDevice = new JLinkDevice(jClient, "${sn}", "${username}", "${password}");


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
         * Get device configuration Take NetWorkDasConfig as an example
         */
        try {
            NetWorkNetDDNSConfig config = (NetWorkNetDDNSConfig) jDevice.getConfig(JLinkDeviceConfigTypeEnum.NETWORKNETDDNS);
            //set your config
            config.getNetWorkNetDDNSDTO().get(0).setdDNSKey("${xxx}");
            config.getNetWorkNetDDNSDTO().get(0).setHostName("${xxx}");
            config.getNetWorkNetDDNSDTO().get(0).getServer().setName("${xxx}");
            config.getNetWorkNetDDNSDTO().get(0).getServer().setAddress("${xxx}");
            config.getNetWorkNetDDNSDTO().get(0).getServer().setPort(0);
            jDevice.setConfig(config);
            //get new config
            jDevice.getConfig(JLinkDeviceConfigTypeEnum.NETWORKNETDDNS);
        } catch (JLinkDeviceGetConfigException e) {
            JLinkLog.e("GetConfig Error:" + e);
        }
    }
}
