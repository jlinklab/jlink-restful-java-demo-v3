package jlink.restful.java.sdk.util;

import jlink.restful.java.sdk.JLinkClient;

import java.util.HashMap;
import java.util.Map;

public class JLinkHeaderUtil {

    public static Map<String, String> map(JLinkClient jClient) {

        String timeMillis = JLinkTimeMillisUtil.getTimMillis();
        String signature = "";
        try {
            signature = JLinkSignatureUtil.getEncryptStr(jClient.getUuid(), jClient.getAppKey(), jClient.getAppSecret(), timeMillis, jClient.getMoveCard());
        } catch (Exception e) {
            JLinkLog.e("signature error " + e.getMessage());
        }

        Map<String, String> headerParam = new HashMap<>();
        headerParam.put("uuid", jClient.getUuid());
        headerParam.put("appKey", jClient.getAppKey());
        headerParam.put("timeMillis", timeMillis);
        headerParam.put("signature", signature);
        return headerParam;
    }
}
