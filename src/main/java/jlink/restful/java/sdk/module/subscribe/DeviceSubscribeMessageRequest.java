package jlink.restful.java.sdk.module.subscribe;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.exception.JLinkSubscribeException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Device subscription message request
 *
 * @author hjm
 * @date 2022/04/21
 */
public class DeviceSubscribeMessageRequest {

    /**
     * Subscribe to news
     *
     * @param callbackUrl  callback Url
     * @param devToken     devToken
     * @param mJLinkClient
     * @return boolean
     */
    public boolean subscribeMessage(String callbackUrl, String devToken, JLinkClient mJLinkClient) {
        DeviceMessageResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.SUBSCRIBE_MESSAGE.get(), devToken);
        Map<String, String> map = new HashMap<>();
        map.put("callbackUrl", callbackUrl);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(map));
        try {
            response = new Gson().fromJson(res, DeviceMessageResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return true;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkSubscribeException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }
}
