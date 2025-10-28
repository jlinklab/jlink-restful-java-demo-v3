package jlink.restful.java.sdk.module.iot.doorlock;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;


/**
 * @author hjm
 * @date 2025/10/28
 */
public class DoorLockRequest {


    /**
     * GetDoorConfig
     *
     * @param devToken
     * @param mJLinkClient
     * @return {@link DoorLockResponse}
     */
    public DoorLockResponse getDoorConfig(String devToken, JLinkClient mJLinkClient) {
        DoorLockResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DOOR_LOCK_TRANSPARENT.get(), devToken);
        DoorLockConfigDTO dto = new DoorLockConfigDTO();
        DoorLockConfigDTO.OPDoorLockProCmd cmd = new DoorLockConfigDTO.OPDoorLockProCmd();
        cmd.setCmd("GetDoorConfig");
        dto.setProCmd(cmd);
        dto.setName("OPDoorLockProCmd");
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DoorLockResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response;
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public DoorLockResponse transportTransmission(String data,String devToken, JLinkClient mJLinkClient) {
        DoorLockResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DOOR_LOCK_TRANSPARENT.get(), devToken);
        DoorLockConfigDTO dto = new DoorLockConfigDTO();
        DoorLockConfigDTO.OPDoorLockProCmd cmd = new DoorLockConfigDTO.OPDoorLockProCmd();
        cmd.setCmd("TransportTransmission");
        cmd.setData(data);
        dto.setProCmd(cmd);
        dto.setName("OPDoorLockProCmd");
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DoorLockResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response;
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public DoorLockResponse remoteUnlock(String sn, String password, String devToken, JLinkClient mJLinkClient) {
        DoorLockResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DOOR_LOCK_REMOTE_UNLOCK.get(), devToken);
        RemoteUnlockDTO dto = new RemoteUnlockDTO(sn,password);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DoorLockResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response;
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }
}
