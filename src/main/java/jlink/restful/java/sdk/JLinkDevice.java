package jlink.restful.java.sdk;

import com.google.gson.Gson;
import jlink.restful.java.sdk.competent.*;
import jlink.restful.java.sdk.databind.JLinkServerResponse;
import jlink.restful.java.sdk.exception.*;
import jlink.restful.java.sdk.module.ability.DeviceAbilityRequest;
import jlink.restful.java.sdk.module.ability.DeviceAbilityResponse;
import jlink.restful.java.sdk.module.alarm.DeviceAlarmListRequest;
import jlink.restful.java.sdk.module.alarm.DeviceAlarmListResponse;
import jlink.restful.java.sdk.module.capture.DeviceCaptureRequest;
import jlink.restful.java.sdk.module.cloudstorage.*;
import jlink.restful.java.sdk.module.config.CustomerFlowConfig;
import jlink.restful.java.sdk.module.config.DetectHumanDetectionConfig;
import jlink.restful.java.sdk.module.config.DeviceConfig;
import jlink.restful.java.sdk.module.devicetoken.DeviceTokenRequest;
import jlink.restful.java.sdk.module.info.DeviceInfoRequest;
import jlink.restful.java.sdk.module.info.DeviceInfoResponse;
import jlink.restful.java.sdk.module.iot.doorlock.DoorLockRequest;
import jlink.restful.java.sdk.module.iot.doorlock.DoorLockResponse;
import jlink.restful.java.sdk.module.iot.feeder.DeviceFeederRequest;
import jlink.restful.java.sdk.module.iot.feeder.DeviceFeederResponse;
import jlink.restful.java.sdk.module.iot.feeder.DeviceFeederSwitchResponse;
import jlink.restful.java.sdk.module.keepalive.DeviceKeepAliveEnum;
import jlink.restful.java.sdk.module.keepalive.DeviceKeepaliveResponse;
import jlink.restful.java.sdk.module.livestream.*;
import jlink.restful.java.sdk.module.localpic.DeviceLocalPicRequest;
import jlink.restful.java.sdk.module.login.DeviceLoginData;
import jlink.restful.java.sdk.module.login.DeviceLoginRequest;
import jlink.restful.java.sdk.module.login.DeviceSession;
import jlink.restful.java.sdk.module.opdev.DeviceOperate;
import jlink.restful.java.sdk.module.opdev.DeviceOperateRequest;
import jlink.restful.java.sdk.module.opdev.DeviceOperateResponse;
import jlink.restful.java.sdk.module.opdev.opdiskmanager.OPStorageFormatDTO;
import jlink.restful.java.sdk.module.passengerFlow.*;
import jlink.restful.java.sdk.module.playback.DevicePlaybackRequest;
import jlink.restful.java.sdk.module.status.DeviceGetStatusRequest;
import jlink.restful.java.sdk.module.status.DeviceStatusData;
import jlink.restful.java.sdk.module.subscribe.DeviceSubscribeMessageRequest;
import jlink.restful.java.sdk.module.subscribe.DeviceUnSubscribeMessageRequest;
import jlink.restful.java.sdk.module.tailored.TailoredConfigRequest;
import jlink.restful.java.sdk.module.tailored.TailoredConfigResponse;
import jlink.restful.java.sdk.module.usermanage.DeviceUserManage;
import jlink.restful.java.sdk.module.usermanage.DeviceUserManageRequest;
import jlink.restful.java.sdk.module.usermanage.DeviceUserManageResponse;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * device Object
 */
public class JLinkDevice {
    /**
     * devise serial number
     */
    private String mDeviceSn;

    private JLinkClient mJLinkClient = null;

    /**
     * device UserName
     */
    private String mDeviceUser;

    /**
     * device Password
     */
    private String mDevicePass;
    /**
     * loginToken
     */
    private String mLoginToken;

    /**
     * session
     */
    private final DeviceSession session = new DeviceSession();

    /**
     * @param sn      devise serial number
     * @param jClient
     */
    public JLinkDevice(JLinkClient jClient, String sn) {
        this.mJLinkClient = jClient;
        this.mDeviceSn = sn;
    }

    public JLinkDevice(JLinkClient jClient, String sn, String mLoginToken) {
        this.mJLinkClient = jClient;
        this.mDeviceSn = sn;
        this.mLoginToken = mLoginToken;
    }

    public JLinkDevice(JLinkClient jClient, String sn, String devUsername, String devPassword) {
        this.mJLinkClient = jClient;
        this.mDeviceSn = sn;
        this.mDeviceUser = devUsername;
        this.mDevicePass = devPassword;
    }

    /******************************basic Method*********************************/
    /**
     * getDeviceToken
     *
     * @return {@link String}
     */
    public String getDeviceToken() {
        String deviceToken = session.getDeviceToken();
        if (deviceToken == null) {
            deviceToken = new DeviceTokenRequest().getDeviceToken(mJLinkClient, mDeviceSn, "");
            session.setDeviceToken(deviceToken);
        }
        if (deviceToken == null || "".equals(deviceToken)) {
            throw new JLinkDeviceTokenException(JLinkResponseCode.DEVICE_TOKEN_ERROR.getCode(), JLinkResponseCode.DEVICE_TOKEN_ERROR.getMsg());
        }
        return deviceToken;
    }

    /**
     * access to device State
     */
    public DeviceStatusData deviceStatus() {
        return new DeviceGetStatusRequest().getDeviceStatus(getDeviceToken(), this.mJLinkClient);
    }

    public DeviceStatusData deviceLocalStatus() {
        return new DeviceGetStatusRequest().getDeviceStatus(JLinkDeviceStatusType.Local.get(), getDeviceToken(), this.mJLinkClient);
    }

    public DeviceStatusData deviceStatus(List<String> deviceTokenList) {
        return new DeviceGetStatusRequest().getDeviceStatus(deviceTokenList, this.mJLinkClient);
    }

    public DeviceStatusData deviceLocalStatus(List<String> deviceTokenList) {
        return new DeviceGetStatusRequest().getDeviceStatus(JLinkDeviceStatusType.Local.get(), deviceTokenList, this.mJLinkClient);
    }

    /**
     * Low-power device wakeup
     */
    public boolean wakeUp() {
        String url = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_WAKEUP.get(), getDeviceToken());
        String res = JLinkHttpUtil.post(url, JLinkHeaderUtil.map(mJLinkClient), "");
        try {
            JLinkServerResponse<String> response = new Gson().fromJson(res, JLinkServerResponse.class);
            return response.getCode() == 2000;
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public boolean checkLogin() {
        return session.isLogin();
    }

    /**
     * Get device information
     *
     * @param infoEnum informationEnumeration
     * @return {@link DeviceInfoResponse.DevInfo}
     */
    public DeviceInfoResponse.DevInfo deviceInfo(JLinkDeviceInfoEnum infoEnum) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2、getting information
        return new DeviceInfoRequest().deviceInfo(infoEnum, getDeviceToken(), mJLinkClient);
    }

    /**
     * automatic Login device
     *
     * @return {@link DeviceLoginData}
     */
    public DeviceLoginData login() {
        DeviceLoginData loginData = deviceLoginByUser(mDeviceUser, mDevicePass, false);
        if (loginData.getRet() == 100) {
            session.setLogin(true);
            //todo Login successful keep heartbeat
        }
        return loginData;
    }

    public DeviceLoginData loginByMD5Pass() {
        DeviceLoginData loginData = deviceLoginNoneEncrypted(mDeviceUser, mDevicePass);
        if (loginData.getRet() == 100) {
            session.setLogin(true);
            //todo Login successful keep heartbeat
        }
        return loginData;
    }

    /**
     * @param share share's device
     * @return {@link DeviceLoginData}
     */
    public DeviceLoginData login(Boolean share) {
        DeviceLoginData loginData = deviceLoginByUser(mDeviceUser, mDevicePass, share);
        if (loginData.getRet() == 100) {
            session.setLogin(true);
            //todo Login successful keep heartbeat
        }
        return loginData;
    }

    public Boolean logout() {
        return new DeviceLoginRequest().deviceLogout(getDeviceToken(), mJLinkClient);
    }

    /**
     * device Capability
     *
     * @param abilityEnum abilityToEnumerate
     * @return {@link DeviceAbilityResponse.DevAbility}
     */
    public DeviceAbilityResponse.DevAbility deviceAbility(JLinkDeviceAbilityEnum abilityEnum) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2、accessToSet
        return new DeviceAbilityRequest().deviceAbility(abilityEnum, getDeviceToken(), mJLinkClient);
    }

    /**
     * device ToKeepAlive
     */
    public boolean keepalive() {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        String url = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_KEEPALIVE.get(), getDeviceToken());
        Map<String, String> param = new HashMap<>(1);
        param.put("Name", DeviceKeepAliveEnum.KEEPALIVE.get());
        String res = JLinkHttpUtil.post(url, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            DeviceKeepaliveResponse response = new Gson().fromJson(res, DeviceKeepaliveResponse.class);
            return response.getCode() == 2000 && response.getData().getRet() == 100;
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * accessToConfiguration
     */
    public Object getConfig(JLinkDeviceConfigTypeEnum configTypeEnum) {
        DeviceConfig wrapper = getConfigWrapper(configTypeEnum);
        return wrapper;
    }


    /**
     * setDeviceConfiguration
     */
    public Boolean setConfig(DeviceConfig setConfig) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        String url = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_SETCONFIG.get(), getDeviceToken());
        return post(setConfig, url, mJLinkClient);
    }

    private Boolean post(DeviceConfig setConfig, String url, JLinkClient mJLinkClient) {
        String body = JLinkHttpUtil.post(url, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(setConfig));
        DeviceConfig res = new Gson().fromJson(body, DeviceConfig.class);
        if (res.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
            return true;
        } else {
            throw new JLinkDeviceGetConfigException(res.getCode(), res.getMsg());
        }
    }

    public Object tailoredConfig() {
        TailoredConfigResponse response = TailoredConfigRequest.tailoredConfig(getSn(), getDeviceToken(), mJLinkClient);
        if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
            return response.getData();
        } else {
            throw new JLinkException(response.getCode(), response.getMsg());
        }
    }

    /**
     * device Operation
     *
     * @return boolean
     */
    public Object deviceOperate(DeviceOperate operate) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2.device Operation
        DeviceOperateResponse response = DeviceOperateRequest.operate(operate, getDeviceToken(), this.mJLinkClient);
        if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
            return response.getData();
        } else {
            throw new JLinkDeviceOperateException(response.getCode(), response.getMsg());
        }
    }

    public DeviceOperateResponse deviceStorageFormat(int partNo, int serialNo) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2.device Operation
        OPStorageFormatDTO operate = new OPStorageFormatDTO();
        OPStorageFormatDTO.OPStorageManager manager = new OPStorageFormatDTO.OPStorageManager();
        manager.setAction("Clear");
        manager.setPartNo(partNo);
        manager.setSerialNo(serialNo);
        operate.setOpStorageManager(manager);
        return DeviceOperateRequest.operate(operate, getDeviceToken(), this.mJLinkClient);
    }


    /**
     * deviceMediaConvert
     * <p>
     * Custom interface, can only be used in limited scenarios
     *
     * @param alogAppUuid
     * @param sn
     * @param protocol
     * @param sliceType
     * @param videoCode
     * @param audioCode
     * @param protocolSrc
     * @param expireTime
     * @param type
     * @param url
     * @return {@link DeviceMediaConvertResponse}
     */
    public DeviceMediaConvertResponse deviceMediaConvert(String alogAppUuid, String sn, String protocol, String sliceType, String videoCode, String audioCode, String protocolSrc, String expireTime, String type, String url) {
        return new DeviceMediaConvertRequest().deviceMediaConvert(alogAppUuid, sn, protocol, sliceType, videoCode, audioCode, protocolSrc, expireTime, type, url, mJLinkClient);
    }

    /**
     * device liveStream
     *
     * @return boolean
     */
    public String deviceLivestream(String stream, String protocol) {
        return deviceLivestream(0, stream, protocol);
    }

    /**
     * deviceLivestream
     *
     * @param channel  channel
     * @param stream   stream
     * @param protocol protocol
     * @return {@link String}
     */
    public String deviceLivestream(int channel, String stream, String protocol) {
        return new DeviceLiveStreamRequest().deviceLivestream(mDeviceUser, mDevicePass, String.valueOf(channel), stream, protocol, null, null, null, getDeviceToken(), this.mJLinkClient);
    }

    public String deviceLivestream(int channel, String stream, String protocol, String expireTime) {
        return new DeviceLiveStreamRequest().deviceLivestream(mDeviceUser, mDevicePass, String.valueOf(channel), stream, protocol, expireTime, null, null, getDeviceToken(), this.mJLinkClient);
    }

    public String deviceLivestream(int channel, String stream, String protocol, String expireTime, String videoCode) {
        return new DeviceLiveStreamRequest().deviceLivestream(mDeviceUser, mDevicePass, String.valueOf(channel), stream, protocol, expireTime, videoCode, null, getDeviceToken(), this.mJLinkClient);
    }

    public String deviceLivestream(int channel, String stream, String protocol, String expireTime, String videoCode, String audioCode) {
        return new DeviceLiveStreamRequest().deviceLivestream(mDeviceUser, mDevicePass, String.valueOf(channel), stream, protocol, expireTime, videoCode, audioCode, getDeviceToken(), this.mJLinkClient);
    }


    /**
     * Get Media Urls
     *
     * @param user
     * @param pass
     * @param userMax
     * @param expireTime
     * @param mediaInfos
     * @return {@link DeviceMediaUrlsResponse}
     */
    public DeviceMediaUrlsResponse getMediaUrls(String user, String pass, int userMax, String expireTime, List<DeviceMediaUrlsRequest.MediaInfo> mediaInfos) {
        return new DeviceMediaUrlsRequest().getMediaUrls(user, pass, userMax, expireTime, mediaInfos, getDeviceToken(), this.mJLinkClient);
    }

    public DeviceMediaUrlsResponse getMediaUrls(int userMax, String expireTime, List<DeviceMediaUrlsRequest.MediaInfo> mediaInfos) {
        return getMediaUrls(mDeviceUser, mDevicePass, userMax, expireTime, mediaInfos);
    }

    public DeviceMediaUrlsResponse getAllDefaultMediaUrls() {
        return new DeviceMediaUrlsRequest().getAllDefaultMediaUrls(mDeviceUser, mDevicePass, getDeviceToken(), this.mJLinkClient);
    }

    /**
     * device Capture
     */
    public String capture(int channel, int timeout) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2、设备抓图
        return new DeviceCaptureRequest().deviceCapture(channel, getDeviceToken(), mJLinkClient, timeout);

    }

    public String capture() {
        return capture(0);
    }

    public String capture(int channel) {
        return capture(0, 60000);
    }

    /**
     * capture with timeout, timeout>=20000ms && timeout<=60000ms
     *
     * @param timeout
     * @return {@link String}
     */
    public String captureWithTimeout(int timeout) {
        return capture(0, timeout);
    }

    /**
     * cloud storage start recording video
     */
    public DeviceCloudStorageResponse startCloudRecord(int duration) {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceCloudStorageRequest().startRecording(mDeviceSn, duration, getDeviceToken(), mJLinkClient);
    }

    /**
     * cloud storage stop recording video
     */
    public DeviceCloudStorageResponse stopCloudRecord() {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceCloudStorageRequest().stopRecording(mDeviceSn, getDeviceToken(), mJLinkClient);
    }

    /**
     * cloud storage alarm pic
     */
    public List<DeviceCloudStoragePicResponse.UrlDto> getPicUrl(List<String> alarmIds) {
        return new DeviceCloudStorageAlarmRequest().getPicUrl(alarmIds, getDeviceToken(), mJLinkClient);
    }

    /**
     * cloud storage alarm video
     */
    public String getVideoUrl(String startTime, String stopTime) {
        return new DeviceCloudStorageAlarmRequest().getVideoUrl(startTime, stopTime, getDeviceToken(), mJLinkClient);
    }


    /**
     * cloud storage alarm video,support download
     *
     * @param channel
     * @param fileFormat
     * @param startTime
     * @param stopTime
     * @return {@link String}
     */
    public String getVideoUrl(int channel, String fileFormat, String startTime, String stopTime) {
        return new DeviceCloudStorageAlarmRequest().getVideoUrl(mDeviceSn, channel, fileFormat, startTime, stopTime, getDeviceToken(), mJLinkClient);
    }

    /**
     * cloud storage alarm video
     */
    public List<DeviceCloudStorageVideoListResponse.DataDTO.VideoDTO> getVideoList(String startTime, String stopTime) {
        return new DeviceCloudStorageAlarmRequest().getVideoList(startTime, stopTime, getDeviceToken(), mJLinkClient);
    }

    /**
     * get playback video thumbnail
     */
    public List<DeviceCloudStoragePicResponse.UrlDto> getVideoPicUrl(List<DeviceCloudStorageAlarmRequest.GetVideoPicUrlParam> param) {
        return new DeviceCloudStorageAlarmRequest().getVideoPicUrl(param, getDeviceToken(), mJLinkClient);
    }

    /**
     * Device subscribes to alarm messages
     */
    public boolean subscribe(String callbackUrl) {
        return new DeviceSubscribeMessageRequest().subscribeMessage(callbackUrl, getDeviceToken(), mJLinkClient);
    }

    /**
     * Device unsubscribes from alarm messages
     */
    public boolean unSubscribe() {
        return new DeviceUnSubscribeMessageRequest().unSubscribeMessage(getDeviceToken(), mJLinkClient);
    }

    public Object userManage(DeviceUserManage userManage) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2、User action
        DeviceUserManageResponse response = DeviceUserManageRequest.userManage(userManage, getDeviceToken(), mJLinkClient);
        if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
            return response.getData();
        } else {
            throw new JLinkDeviceUserManageException(response.getCode(), response.getMsg());
        }
    }

    /**
     * Device playback address
     *
     * @return boolean
     */
    public String devicePlayback(int stream, String protocol, String startTime, String endTime, String fileName) {
        return devicePlayback(0, stream, protocol, startTime, endTime, fileName, "", "", 0, 0);
    }

    public String devicePlayback(int stream, String protocol, String startTime, String endTime, String fileName, int download, int playPrioritize) {
        return devicePlayback(0, stream, protocol, startTime, endTime, fileName, "", "", download, playPrioritize);
    }

    public String devicePlayback(int stream, String protocol, String startTime, String endTime, String fileName, String encryptType, String loginToken) {
        return devicePlayback(0, stream, protocol, startTime, endTime, fileName, encryptType, loginToken, 0, 0);
    }

    public String devicePlayback(int channel, int stream, String protocol, String startTime, String endTime, String fileName, String encryptType, String loginToken, int download, int playPrioritize) {
        return new DevicePlaybackRequest().devicePlayback(channel, stream, protocol, startTime, endTime, fileName, encryptType, mDeviceUser, mDevicePass, loginToken, download, playPrioritize, getDeviceToken(), mJLinkClient);
    }

    /**
     * Device playback timeline (SD Card)
     *
     * @param sn
     * @param beginTime
     * @param endTime
     * @return {@link String}
     */
    /**
     * Device playback timeline (SD Card)
     *
     * @param sn
     * @param beginTime
     * @param endTime
     * @return {@link String}
     */
    public String playbackTimelineList(String sn, String beginTime, String endTime) {
        return new DevicePlaybackRequest().playbackTimelineListImpl(sn, beginTime, endTime, null, 1, null, 0, null, null, getDeviceToken(), mJLinkClient);
    }

    public String playbackTimelineList(String sn, String beginTime, String endTime, String event) {
        return new DevicePlaybackRequest().playbackTimelineListImpl(sn, beginTime, endTime, event, 1, null, 0, null, null, getDeviceToken(), mJLinkClient);
    }

    public String playbackTimelineList(String sn, String beginTime, String endTime, String event, int lowChannel, String lowStreamType) {
        return new DevicePlaybackRequest().playbackTimelineListImpl(sn, beginTime, endTime, event, lowChannel, lowStreamType, 0, null, null, getDeviceToken(), mJLinkClient);
    }

    public String playbackTimelineList(String sn, String beginTime, String endTime, String event, int lowChannel, String lowStreamType, int highChannel, String highStreamType) {
        return new DevicePlaybackRequest().playbackTimelineListImpl(sn, beginTime, endTime, event, lowChannel, lowStreamType, highChannel, highStreamType, null, getDeviceToken(), mJLinkClient);
    }

    public String playbackTimelineList(String sn, String beginTime, String endTime, String event, int lowChannel, String lowStreamType, int highChannel, String highStreamType, String type) {
        return new DevicePlaybackRequest().playbackTimelineListImpl(sn, beginTime, endTime, event, lowChannel, lowStreamType, highChannel, highStreamType, type, getDeviceToken(), mJLinkClient);
    }

    public String cardPlaybackCalendarImpl(String sn, String event, int channel, int month, int year, String type) {
        return new DevicePlaybackRequest().cardPlaybackCalendarImpl(sn, event, channel, month, year, type, getDeviceToken(), mJLinkClient);
    }

    /**
     * Alarm List
     *
     * @param sn
     * @param startTime
     * @param endTime
     * @return {@link DeviceAlarmListResponse}
     */
    public DeviceAlarmListResponse getAlarmList(String sn, String startTime, String endTime) {
        return new DeviceAlarmListRequest().getDeviceAlarmList(sn, startTime, endTime, getDeviceToken(), mJLinkClient);
    }

    public String deviceLocalPic(String startTime, String endTime, String fileName, JLinkUser jUser) {
        return new DeviceLocalPicRequest().deviceLocalPic(mDeviceSn, startTime, endTime, fileName, getDeviceToken(), mJLinkClient);
    }

    public String deviceLocalPic(String fileName) {
        return new DeviceLocalPicRequest().deviceLocalPic(mDeviceSn, "", "", fileName, getDeviceToken(), mJLinkClient);
    }

    /******************************basic Method*********************************/

    /******************************getter and setter*********************************/
    public String getSn() {
        return mDeviceSn;
    }

    public String getDeviceUser() {
        return mDeviceUser;
    }

    public void setDeviceUser(String mDeviceUser) {
        this.mDeviceUser = mDeviceUser;
    }

    public String getDevicePass() {
        return mDevicePass;
    }

    public void setDevicePass(String mDevicePass) {
        this.mDevicePass = mDevicePass;
    }

    /******************************method*********************************/


    /**
     * Log in to the device by username and password
     *
     * @param userName
     * @param passWord
     * @return
     */
    public DeviceLoginData deviceLoginByUser(String userName, String passWord) {
        return new DeviceLoginRequest().deviceLoginByUser(userName, passWord, getDeviceToken(), this.mJLinkClient);
    }

    public DeviceLoginData deviceLoginByUser(String userName, String passWord, Boolean share) {
        return new DeviceLoginRequest().deviceLoginByUser(userName, passWord, getDeviceToken(), share, this.mJLinkClient);
    }

    public DeviceLoginData deviceLoginNoneEncrypted(String md5UserName, String md5PassWord) {
        return new DeviceLoginRequest().deviceLoginNoneEncrypted(md5UserName, md5PassWord, getDeviceToken(), this.mJLinkClient);
    }

    /**
     * Log in to the device with the Token obtained from device sharing（Token：xxxx）
     *
     * @param devLoginToken
     * @return
     */
    public DeviceLoginData deviceLoginByToken(String devLoginToken) {
        DeviceLoginData loginData = new DeviceLoginRequest().deviceLoginByToken(devLoginToken, getDeviceToken(), this.mJLinkClient);
        if (loginData.getRet() == 100) {
            session.setLogin(true);
            //todo Login successful keep heartbeat
        }
        return loginData;
    }

    public <T> T getConfigWrapper(JLinkDeviceConfigTypeEnum configTypeEnum) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        //todo 2、accessToConfiguration
        String url = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETCONFIG.get(), getDeviceToken());
        Map<String, String> param = new HashMap<>(1);
        param.put("Name", configTypeEnum.getConfigName());

        String body = JLinkHttpUtil.post(url, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        DeviceConfig setConfigCommon = new Gson().fromJson(body, configTypeEnum.getType());
        if (setConfigCommon.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
            return (T) setConfigCommon.getData();
        } else {
            throw new JLinkDeviceGetConfigException(setConfigCommon.getCode(), setConfigCommon.getMsg());
        }
    }


    /**
     * Get  passenger flow
     *
     * @param date,countCycles,cycleNum
     * @return {@link GetPassengerFlowResponse}
     */
    public GetPassengerFlowResponse.PassengerFlowInfo getPassengerFlowInfo(String date, int countCycles, int cycleNum) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        return new PassengerFlowRequest().getPassengerFlow(getDeviceToken(), date, countCycles, cycleNum, mJLinkClient);

    }


    /**
     * Clear  passenger flow
     *
     * @param
     * @return {@link ClearPassengerFlowResponse.ClearPassengerInfo}
     */
    public ClearPassengerFlowResponse.ClearPassengerInfo clearPassengerFlowInfo() {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        return new PassengerFlowRequest().clearPassengerFlownInfo(getDeviceToken(), mJLinkClient);

    }


    /**
     * resetOSD
     *
     * @param
     * @return {@link ResetOSDResponse.RestOSD}
     */
    public ResetOSDResponse.RestOSD resetOSD() {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        return new PassengerFlowRequest().resetOSD(getDeviceToken(), mJLinkClient);

    }


    /**
     * getPassengerFlowInfo
     *
     * @param date,cycleNum
     * @return {@link GetPassengerFlowResponse}
     */
    public GetYearReportResponse.PassengerYearFlowInfo getYearFlowInfo(String date, int cycleNum) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        return new PassengerFlowRequest().getYearFlowInfo(getDeviceToken(), date, cycleNum, mJLinkClient);

    }


    /**
     * ROISet
     *
     * @param regionPtsDTOS
     * @return {@link GetPassengerFlowResponse}
     */
    public boolean setROI(List<DetectHumanDetectionConfig.DetectHumanDetectionDTO.PedRuleDTO.RuleRegionDTO.RegionPtsDTO> regionPtsDTOS) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }
        DetectHumanDetectionConfig config = (DetectHumanDetectionConfig) getConfig(JLinkDeviceConfigTypeEnum.DETECTHUMANDETECTION);
        if (config.getRet() == 100) {
            config.getDetectHumanDetectionDTOS().get(0).getPedRuleDTOS().get(0).getRuleRegionDTO().setRegionPtsDTOS(regionPtsDTOS);
            return setConfig(config);
        } else {
            throw new JLinkDeviceInfoException(config.getRet(), config.getRetMsg());
        }

    }


    /**
     * ROISet
     *
     * @param customerFlow
     * @return {@link GetPassengerFlowResponse}
     */
    public boolean setCustomerFlowConfig(CustomerFlowConfig.CustomerFlow customerFlow) {
        //todo 1、determineLogin
        if (!session.isLogin()) {
            login();
        }

        CustomerFlowConfig config = (CustomerFlowConfig) getConfig(JLinkDeviceConfigTypeEnum.CustomerFlow);
        if (config.getRet() == 100) {
            config.setCustomerFlow(customerFlow);
            return setConfig(config);
        } else {
            throw new JLinkDeviceInfoException(config.getRet(), config.getRetMsg());
        }

    }


    /**
     * @param feed
     * @return {@link DeviceFeederResponse}
     */
    public DeviceFeederResponse feed(int feed) {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceFeederRequest().feed(mDeviceSn, feed, getDeviceToken(), mJLinkClient);
    }

    /**
     * Get FeedPlan
     *
     * @return {@link DeviceFeederResponse}
     */
    public DeviceFeederResponse getFeedPlan() {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceFeederRequest().getFeedPlan(mDeviceSn, getDeviceToken(), mJLinkClient);
    }

    /**
     * Set FeedPlan
     *
     * @param enable
     * @param cron
     * @param feed
     * @return {@link DeviceFeederResponse}
     */
    public DeviceFeederResponse setFeedPlan(boolean enable, String cron, int feed) {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceFeederRequest().setFeedPlan(mDeviceSn, enable, cron, feed, getDeviceToken(), mJLinkClient);
    }

    /**
     * Get PetDetectionSwitchStatus
     *
     * @return {@link DeviceFeederSwitchResponse}
     */
    public DeviceFeederSwitchResponse getPetDetectionSwitchStatus() {
        if (!session.isLogin()) {
            login();
        }
        return new DeviceFeederRequest().getPetDetectionSwitchStatus(getDeviceToken(), mJLinkClient);
    }

    /**
     * Set PetDetectionSwitchStatus
     *
     * @param switchStatus ON/OFF
     * @return {@link DeviceFeederSwitchResponse}
     */
    public DeviceFeederSwitchResponse setPetDetectionSwitchStatus(String switchStatus) {
        if (switchStatus.equals("ON") || switchStatus.equals("OFF")) {
            if (!session.isLogin()) {
                login();
            }
            return new DeviceFeederRequest().setPetDetectionSwitchStatus(switchStatus, getDeviceToken(), mJLinkClient);
        } else {
            throw new JLinkJsonException(JLinkResponseCode.PARAM_ERROR.getCode(), "Param Error");
        }
    }

    /**
     * GetDoorLockConfig
     *
     * @return {@link DoorLockResponse}
     */
    public DoorLockResponse getDoorLockConfig() {
        if (!session.isLogin()) {
            login();
        }
        return new DoorLockRequest().getDoorConfig(getDeviceToken(), mJLinkClient);

    }

    /**
     * @param data
     * @return {@link DoorLockResponse}
     */
    public DoorLockResponse transportTransmission(String data) {
        if (!session.isLogin()) {
            login();
        }
        return new DoorLockRequest().transportTransmission(data, getDeviceToken(), mJLinkClient);
    }

}
