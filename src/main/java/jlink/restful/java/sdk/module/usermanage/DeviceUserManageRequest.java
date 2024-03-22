package jlink.restful.java.sdk.module.usermanage;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceUserManageException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * Device User Management Request
 *
 * @author hjm
 * @date 2022/04/21
 */
public class DeviceUserManageRequest {

    /**
     * User Management
     *
     * @param userManage
     * @param devToken
     * @param mJLinkClient
     * @return boolean
     */
    public static DeviceUserManageResponse userManage(DeviceUserManage userManage, String devToken, JLinkClient mJLinkClient) {
        DeviceUserManageResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_USERMANAGE.get(), devToken);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(userManage));
        try {
            response = new Gson().fromJson(res, userManage.getUserManageEnum().getType());
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceUserManageException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }
}
