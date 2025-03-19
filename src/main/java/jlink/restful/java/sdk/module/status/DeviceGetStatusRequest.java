package jlink.restful.java.sdk.module.status;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * DeviceGetStatusRequest
 */
public class DeviceGetStatusRequest {
    /**
     * getDeviceStatus
     *
     * @param token
     * @return {@link DeviceStatusData}
     */
    public DeviceStatusData getDeviceStatus(String token, JLinkClient jClient) {
        List<String> str = new ArrayList<>();
        str.add(token);
        return getDeviceStatus(str, jClient);
    }

    public DeviceStatusData getDeviceStatus(List<String> tokenList, JLinkClient jClient) {
        StatusDto dto = new StatusDto();
        dto.setDeviceTokenList(tokenList);
        dto.setOtherStatus(true);
        //Assemble the request address for obtaining the device ret requestDeviceStatusUrl
        String requestDeviceStatusUrl = String.format("%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_STATUS.get());
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceStatusUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(dto));
        //Convert the return string to a bean object
        try {
            DeviceStatusResponse response = new Gson().fromJson(res, DeviceStatusResponse.class);
            return response.getData().get(0);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }

    }

    private static class StatusDto {
        /**
         * Device Token Collection
         */
        private List<String> deviceTokenList;

        /**
         * The value is true to return rps, dss, p2p detailed ret; the default is false
         */
        private boolean otherStatus;

        public List<String> getDeviceTokenList() {
            return deviceTokenList;
        }

        public void setDeviceTokenList(List<String> deviceTokenList) {
            this.deviceTokenList = deviceTokenList;
        }

        public boolean isOtherStatus() {
            return otherStatus;
        }

        public void setOtherStatus(boolean otherStatus) {
            this.otherStatus = otherStatus;
        }
    }
}
