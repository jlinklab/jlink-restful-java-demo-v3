package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

/**
 * PassengerFlow Request
 *
 * @author hwl
 * @date 2023/02/19
 */
public class PassengerFlowRequest {

    /**
     * Get PassengerFlow
     */
    public GetPassengerFlowResponse.PassengerFlowInfo getPassengerFlow(String devToken, String date, int countCycles, int cycleNum, JLinkClient mJLinkClient) {
        String requestDeviceInfoUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_INFO.get(), devToken);
        CustomerFlowDTO customerFlowDTO = new CustomerFlowDTO();
        customerFlowDTO.setName(JLinkCustomerFlowEnum.CustomerFlowData.get());
        CustomerFlowDTO.CustomerFlowData customerFlowData = new CustomerFlowDTO.CustomerFlowData();
        customerFlowData.setAction(JLinkCustomerFlowEnum.GetInOutCount.get());

        customerFlowData.setBeginTime(date);
        customerFlowData.setCountCycles(countCycles);
        customerFlowData.setCycleNum(cycleNum);
        customerFlowDTO.setCustomerFlowData(customerFlowData);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceInfoUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(customerFlowDTO));
        try {
            GetPassengerFlowResponse getPassengerFlowResponse = new Gson().fromJson(res, GetPassengerFlowResponse.class);
            if (getPassengerFlowResponse.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (getPassengerFlowResponse.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return getPassengerFlowResponse.getData();
                } else {
                    throw new JLinkDeviceInfoException(getPassengerFlowResponse.getData().getRet(), JLinkDeviceResponseCode.get(getPassengerFlowResponse.getData().getRet()).getMsg());
                }
            } else {
                throw new JLinkDeviceInfoException(getPassengerFlowResponse.getData().getRet(), JLinkDeviceResponseCode.get(getPassengerFlowResponse.getData().getRet()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }

    }

    /**
     * Clear Passenger info
     */

    public ClearPassengerFlowResponse.ClearPassengerInfo clearPassengerFlownInfo(String devToken, JLinkClient mJLinkClient) {
        String requestDeviceInfoUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_INFO.get(), devToken);


        ClearPassengerFlowDTO clearPassengerFlowDTO = new ClearPassengerFlowDTO();
        clearPassengerFlowDTO.setName(JLinkCustomerFlowEnum.CustomerFlowData.get());
        ClearPassengerFlowDTO.CustomerFlowData customerFlowData = new ClearPassengerFlowDTO.CustomerFlowData();
        customerFlowData.setAction(JLinkCustomerFlowEnum.ClearInOutCount.get());
        clearPassengerFlowDTO.setCustomerFlowData(customerFlowData);

        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceInfoUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(clearPassengerFlowDTO));
        try {
            ClearPassengerFlowResponse clearPassengerFlowResponse = new Gson().fromJson(res, ClearPassengerFlowResponse.class);

            if (clearPassengerFlowResponse.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (clearPassengerFlowResponse.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return clearPassengerFlowResponse.getData();
                } else {
                    throw new JLinkDeviceInfoException(clearPassengerFlowResponse.getData().getRet(), JLinkDeviceResponseCode.get(clearPassengerFlowResponse.getData().getRet()).getMsg());
                }
            } else {
                throw new JLinkDeviceInfoException(clearPassengerFlowResponse.getData().getRet(), JLinkDeviceResponseCode.get(clearPassengerFlowResponse.getData().getRet()).getMsg());
            }

        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


    /**
     * Reset OSD
     */

    public ResetOSDResponse.RestOSD resetOSD(String devToken, JLinkClient mJLinkClient) {
        String requestDeviceInfoUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_INFO.get(), devToken);


        ResetOSDReDTO resetOSDReDTO = new ResetOSDReDTO();
        resetOSDReDTO.setName(JLinkCustomerFlowEnum.CustomerFlowData.get());
        ResetOSDReDTO.OSDFlowData osdFlowData = new ResetOSDReDTO.OSDFlowData();
        osdFlowData.setAction(JLinkCustomerFlowEnum.ResetFlowOsd.get());
        resetOSDReDTO.setCustomerFlowData(osdFlowData);


        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceInfoUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(resetOSDReDTO));
        try {
            ResetOSDResponse resetOSDResponse = new Gson().fromJson(res, ResetOSDResponse.class);

            if (resetOSDResponse.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (resetOSDResponse.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return resetOSDResponse.getData();
                } else {
                    throw new JLinkDeviceInfoException(resetOSDResponse.getData().getRet(), JLinkDeviceResponseCode.get(resetOSDResponse.getData().getRet()).getMsg());
                }
            } else {
                throw new JLinkDeviceInfoException(resetOSDResponse.getData().getRet(), JLinkDeviceResponseCode.get(resetOSDResponse.getData().getRet()).getMsg());
            }

        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


    /**
     * Get Year Report
     */

    public GetYearReportResponse.PassengerYearFlowInfo getYearFlowInfo(String devToken, String date, int cycleNum, JLinkClient mJLinkClient) {
        String requestDeviceInfoUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_INFO.get(), devToken);

        GetYearReportDTO getYearReportDTO = new GetYearReportDTO();
        getYearReportDTO.setName(JLinkCustomerFlowEnum.CustomerFlowData.get());
        GetYearReportDTO.YearReportData yearReportData = new GetYearReportDTO.YearReportData();
        yearReportData.setBeginTime(date);
        yearReportData.setCycleNum(cycleNum);
        yearReportData.setAction(JLinkCustomerFlowEnum.GetYearReportByM.get());
        getYearReportDTO.setYearReportData(yearReportData);


        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceInfoUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(getYearReportDTO));
        try {
            GetYearReportResponse getYearReportResponse = new Gson().fromJson(res, GetYearReportResponse.class);

            if (getYearReportResponse.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (getYearReportResponse.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return getYearReportResponse.getData();
                } else {
                    throw new JLinkDeviceInfoException(getYearReportResponse.getData().getRet(), JLinkDeviceResponseCode.get(getYearReportResponse.getData().getRet()).getMsg());
                }
            } else {
                throw new JLinkDeviceInfoException(getYearReportResponse.getData().getRet(), JLinkDeviceResponseCode.get(getYearReportResponse.getData().getRet()).getMsg());
            }

        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


}
