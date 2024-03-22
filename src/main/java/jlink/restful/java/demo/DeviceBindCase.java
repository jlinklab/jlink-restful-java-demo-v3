package jlink.restful.java.demo;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.HashMap;
import java.util.Map;


public class DeviceBindCase {
    public static void main(String[] args) {

        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        String url = String.format("%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_BIND.get());
        Map<String, String> bodyParam = new HashMap<>();
        //Required Parameters
        bodyParam.put("sn", "1234567890123456");
        //Optional parameters
        bodyParam.put("username", "admin");
        bodyParam.put("password", "");
        bodyParam.put("type", "");
        bodyParam.put("nickname", "test device");
        bodyParam.put("port", "");
        bodyParam.put("ip", "");
        //bind device
        JLinkHttpUtil.httpsRequest(url, "POST", JLinkHeaderUtil.map(jClient), new Gson().toJson(bodyParam));
    }
}
