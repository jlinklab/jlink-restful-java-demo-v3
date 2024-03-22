package jlink.restful.java.demo;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.HashMap;
import java.util.Map;


public class LoginTokenCase {
    public static void main(String[] args) {

        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");
        String url = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.LOGIN_TOKEN.get(), jDevice.getDeviceToken());
        Map<String, String> bodyParam = new HashMap<>();
        bodyParam.put("sn", "1234567890123456");

        String loginToken = JLinkHttpUtil.httpsRequest(url, "POST", JLinkHeaderUtil.map(jClient), new Gson().toJson(bodyParam));

        JLinkLog.i("loginToken:" + loginToken);
    }
}
