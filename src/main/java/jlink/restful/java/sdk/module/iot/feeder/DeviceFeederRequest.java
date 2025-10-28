package jlink.restful.java.sdk.module.iot.feeder;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Device Feeder
 *
 * @author hjm
 * @date 2025/10/28
 */
public class DeviceFeederRequest {

    /**
     * Device Feeder
     *
     * @param feed         //Number of feeding portions
     * @param devToken
     * @param mJLinkClient
     * @return {@link DeviceFeederResponse}
     */
    public DeviceFeederResponse feed(String sn, int feed, String devToken, JLinkClient mJLinkClient) {
        DeviceFeederResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.FEEDER.get(), devToken);
        FeederDTO dto = new FeederDTO();
        dto.setSn(sn);
        FeederDTO.PropsDTO props = new FeederDTO.PropsDTO();
        props.setFeed(feed);
        dto.setProps(props);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DeviceFeederResponse.class);
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

    public DeviceFeederResponse getFeedPlan(String sn, String devToken, JLinkClient mJLinkClient) {
        DeviceFeederResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.IOT_PROP_SET.get(), devToken);
        FeedPlanDTO dto = new FeedPlanDTO();
        dto.setSn(sn);
        List<String> str = new ArrayList<>();
        str.add("feedPlan");
        dto.setProps(str);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DeviceFeederResponse.class);
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

    public DeviceFeederResponse setFeedPlan(String sn, boolean enable, String cron, int feed, String devToken, JLinkClient mJLinkClient) {
        DeviceFeederResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.IOT_PROP_SET.get(), devToken);
        SetFeedPlanDTO dto = new SetFeedPlanDTO();
        dto.setSn(sn);
        SetFeedPlanDTO.PropsDTO props = new SetFeedPlanDTO.PropsDTO();
        List<SetFeedPlanDTO.PropsDTO.FeedPlanDTO> feedPlanDTOS = new ArrayList<>();
        SetFeedPlanDTO.PropsDTO.FeedPlanDTO feedPlanDTO = new SetFeedPlanDTO.PropsDTO.FeedPlanDTO();
        SetFeedPlanDTO.PropsDTO.FeedPlanDTO.ActionDTO actionDTO = new SetFeedPlanDTO.PropsDTO.FeedPlanDTO.ActionDTO();
        actionDTO.setFeed(feed);
        feedPlanDTO.setAction(actionDTO);
        feedPlanDTO.setCron(cron);
        feedPlanDTO.setEnable(enable);
        feedPlanDTOS.add(feedPlanDTO);
        props.setFeedPlan(feedPlanDTOS);
        dto.setProps(props);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(dto));
        try {
            response = new Gson().fromJson(res, DeviceFeederResponse.class);
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

    public DeviceFeederSwitchResponse getPetDetectionSwitchStatus(String devToken, JLinkClient mJLinkClient) {
        DeviceFeederSwitchResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.PET_DETECTION_SWITCH_STATUS.get(), devToken);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), "");
        try {
            response = new Gson().fromJson(res, DeviceFeederSwitchResponse.class);
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

    public DeviceFeederSwitchResponse setPetDetectionSwitchStatus(String switchStatus, String devToken, JLinkClient mJLinkClient) {
        DeviceFeederSwitchResponse response;
        String requestDeviceFeederUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.PET_DETECTION_SWITCH_SETTING.get(), devToken);
        Map<String, String> map = new HashMap<>();
        map.put("Switch", switchStatus);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceFeederUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(map));
        try {
            response = new Gson().fromJson(res, DeviceFeederSwitchResponse.class);
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
