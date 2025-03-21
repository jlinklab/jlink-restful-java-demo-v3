package jlink.restful.java.sdk.competent;


import com.google.gson.reflect.TypeToken;
import jlink.restful.java.sdk.module.config.*;

import java.lang.reflect.Type;

/**
 * jlink device configuration enumeration type
 *
 * @author hjm
 * @date 2022/04/20
 */
public enum JLinkDeviceConfigTypeEnum {
    //Coding parameter configuration    
    AVENCENCODE("AVEnc.Encode", new TypeToken<DeviceConfig<AvEncEncodeConfig>>() {
    }.getType()),
    //Video Object Configuration
    AVENCVIDEOWIDGET("AVEnc.VideoWidget", new TypeToken<DeviceConfig<AVEncVideoWidgetConfig>>() {
    }.getType()),
    //Video Input Color Configuration
    AVENCVIDEOCOLOR("AVEnc.VideoColor", new TypeToken<DeviceConfig<AvEncVideoColorConfig>>() {
    }.getType()),
    //H.264+
    AVENCSMARTH264("AVEnc.SmartH264", new TypeToken<DeviceConfig<AVEncSmartH264Config>>() {
    }.getType()),
    //Multi-channel preview encoding configuration
    AVENCMULTICHANNELENCODE("AVEnc.MultiChannelEncode", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //TV Adjustment Settings (Audio)
    FVIDEOVOLUME("fVideo.Volume", new TypeToken<DeviceConfig<FVideoVolumeConfig>>() {
    }.getType()),
    //TV adjustment settings
    FVIDEOTVADJUST("fVideo.TVAdjust", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Video output related configuration
    FVIDEOVIDEOOUT("fVideo.VideoOut", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //play
    FVIDEOPLAY("fVideo.Play", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Voice intercom encoding configuration
    FVIDEOAUDIOINFORMAT("fVideo.AudioInFormat", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Screen tour configuration
    FVIDEOTOUR("fVideo.Tour", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //videoOutput
    FVIDEOVIDEOOUTPRIORITY("fVideo.VideoOutPriority", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //screenPromptInformation
    FVIDEOOSDINFO("fVideo.OSDInfo", new TypeToken<DeviceConfig<FVideoOSDInfoConfig>>() {
    }.getType()),
    //videoAnalysisConfiguration
    ANALYZE("Analyze", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //playbackConfiguration
    VIDEODEC("VideoDec", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //videoConfiguration
    RECORD("Record", new TypeToken<DeviceConfig<RecordConfig>>() {
    }.getType()),
    EXTRECORD("ExtRecord", new TypeToken<DeviceConfig<ExtRecordConfig>>() {
    }.getType()),
    //videoWindowConfiguration
    VIDEOCHANNEL("VideoChannel", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //BlindDetect Configuration
    DETECTBLINDDETECT("Detect.BlindDetect", new TypeToken<DeviceConfig<DetectBlindDetectConfig>>() {
    }.getType()),
    //MotionDetect Configuration
    DETECTMOTIONDETECT("Detect.MotionDetect", new TypeToken<DeviceConfig<DetectMotionDetectConfig>>() {
    }.getType()),
    //LossDetect Configuration
    DETECTLOSSDETECT("Detect.LossDetect", new TypeToken<DeviceConfig<DetectLossDetectConfig>>() {
    }.getType()),
    //Maximum Encoding Capability Supported
    ABILITYENCODEPOWER("Ability.EncodePower", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //get alarm sound list
    ABILITYVOICETIPTYPE("Ability.VoiceTipType", new TypeToken<DeviceConfig<AbilityVoiceTipTypeConfig>>() {
    }.getType()),
    //System State
    GENERALSYSTEMSTATE("General.SystemState", new TypeToken<DeviceConfig<NetWorkDasConfig>>() {
    }.getType()),
    //ChannelTitle
    CHANNELTITLE("ChannelTitle", new TypeToken<DeviceConfig<ChannelTitleConfig>>() {
    }.getType()),
    //DecodeParam
    MEDIADECODEPARAM("Media.DecodeParam", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Get Camera parameters
    CAMERA("Camera.Param", new TypeToken<DeviceConfig<CameraConfig>>() {
    }.getType()),
    //Get Camera extend parameters
    CAMERAPARAMEX("Camera.ParamEx", new TypeToken<DeviceConfig<CameraParamExConfig>>() {
    }.getType()),
    //HumanDetection
    DETECTHUMANDETECTION("Detect.HumanDetection", new TypeToken<DeviceConfig<DetectHumanDetectionConfig>>() {
    }.getType()),
    //HumanDetection.[0]
    DETECTHUMANDETECTION0("Detect.HumanDetection.[0]", new TypeToken<DeviceConfig<DetectHumanDetection0Config>>() {
    }.getType()),
    //LocalAlarm
    ALARMLOCALALARM("Alarm.LocalAlarm", new TypeToken<DeviceConfig<AlarmLocalAlarmConfig>>() {
    }.getType()),
    //AlarmOut
    ALARMALARMOUT("Alarm.AlarmOut", new TypeToken<DeviceConfig<AlarmAlarmOutConfig>>() {
    }.getType()),
    //Comm
    UARTCOMM("Uart.Comm", new TypeToken<DeviceConfig<UartCommConfig>>() {
    }.getType()),
    //PTZ
    UARTPTZ("Uart.PTZ", new TypeToken<DeviceConfig<UartPTZConfig>>() {
    }.getType()),
    //PTZPreset
    UARTPTZPRESET("Uart.PTZPreset", new TypeToken<DeviceConfig<UartPTZPresetConfig>>() {
    }.getType()),
    //PTZTour
    UARTPTZTOUR("Uart.PTZTour", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //RS485
    UARTRS485("Uart.RS485", new TypeToken<DeviceConfig<UartRS485Config>>() {
    }.getType()),
    //NetCommon
    NETWORKNETCOMMON("NetWork.NetCommon", new TypeToken<DeviceConfig<NetWorkNetCommonConfig>>() {
    }.getType()),
    NetWorkAlarmServer("NetWork.AlarmServer", new TypeToken<DeviceConfig<NetWorkAlarmServerConfig>>() {
    }.getType()),
    //NVR Digital Channel Protocol
    NETWORKREMOTEDEVICEV3("NetWork.RemoteDeviceV3", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //NetDHCP
    NETWORKNETDHCP("NetWork.NetDHCP", new TypeToken<DeviceConfig<NetWorkNetDHCPConfig>>() {
    }.getType()),
    //NetDDNS
    NETWORKNETDDNS("NetWork.NetDDNS", new TypeToken<DeviceConfig<NetWorkNetDDNSConfig>>() {
    }.getType()),
    //NetEmail
    NETWORKNETEMAIL("NetWork.NetEmail", new TypeToken<DeviceConfig<NetWorkNetEmailConfig>>() {
    }.getType()),
    //NetNTP
    NETWORKNETNTP("NetWork.NetNTP", new TypeToken<DeviceConfig<NetWorkNetNTPConfig>>() {
    }.getType()),
    //NetPPPOE
    NETWORKNETPPPOE("NetWork.NetPPPOE", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //NetDNS
    NETWORKNETDNS("NetWork.NetDNS", new TypeToken<DeviceConfig<NetWorkNetDNSConfig>>() {
    }.getType()),
    //NetFTP
    NETWORKNETFTP("NetWork.NetFTP", new TypeToken<DeviceConfig<NetWorkNetFTPConfig>>() {
    }.getType()),
    //NetARSP
    NETWORKNETARSP("NetWork.NetARSP", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //RemoteDevice
    NETWORKREMOTEDEVICE("NetWork.RemoteDevice", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Net3G
    NETWORKNET3G("NetWork.Net3G", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //NetIPConflict
    ALARMNETIPCONFLICT("Alarm.NetIPConflict", new TypeToken<DeviceConfig<AlarmNetIPConflictConfig>>() {
    }.getType()),
    //NetAbort
    ALARMNETABORT("Alarm.NetAbort", new TypeToken<DeviceConfig<AlarmNetAbortConfig>>() {
    }.getType()),
    //Upnp
    NETWORKUPNP("NetWork.Upnp", new TypeToken<DeviceConfig<NetWorkUpnpConfig>>() {
    }.getType()),
    //NetMobile
    NETWORKNETMOBILE("NetWork.NetMobile", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //NetIPFilter
    NETWORKNETIPFILTER("NetWork.NetIPFilter", new TypeToken<DeviceConfig<NetWorkNetIPFilterConfig>>() {
    }.getType()),
    //DigTimeSyn
    NETWORKDIGTIMESYN("NetWork.DigTimeSyn", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //NetOrder
    NETWORKNETORDER("NetWork.NetOrder", new TypeToken<DeviceConfig<NetWorkNetOrderConfig>>() {
    }.getType()),
    //ShortMsg
    NETWORKSHORTMSG("NetWork.ShortMsg", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //MultimediaMsg Configuration
    NETWORKMULTIMEDIAMSG("NetWork. MultimediaMsg", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //DAS
    NETWORKDAS("NetWork.DAS", new TypeToken<DeviceConfig<NetWorkDasConfig>>() {
    }.getType()),
    //PMS Configuration
    NETWORKPMS("NetWork.PMS", new TypeToken<DeviceConfig<NetWorkPMSConfig>>() {
    }.getType()),
    //Nat Configuration
    NETWORKNAT("NetWork.Nat", new TypeToken<DeviceConfig<NetWorkNATConfig>>() {
    }.getType()),
    NETWORKIPADAPTIVE("NetWork.IPAdaptive", new TypeToken<DeviceConfig<NetWorkIpAdaptiveConfig>>() {
    }.getType()),
    //digital channel alarmInput Configuration
    ALARMIPCALARM("Alarm.IPCAlarm", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //Wifi Configuration
    //"Auth"、"EncrypType"、"SSID"、"KeyType"和"NetType"
    NETWORKWIFI("NetWork.Wifi", new TypeToken<DeviceConfig<NetWorkWifiConfig>>() {
    }.getType()),
    NETWORKONVIFPWDCHECKOUT("NetWork.OnvifPwdCheckout", new TypeToken<DeviceConfig<NetworkOnvifPwdCheckoutConfig>>() {
    }.getType()),
    OEMCFGCORRESPONDENT("OEMcfg.Correspondent", new TypeToken<DeviceConfig<OEMcfgCorrespondentConfig>>() {
    }.getType()),
    //GUI Configuration
    FVIDEOGUISET("fVideo.GUISet", new TypeToken<DeviceConfig<FVideoGUISetConfig>>() {
    }.getType()),
    //graspFigure Configuration
    STORAGESNAPSHOT("Storage.Snapshot", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //storeRelated Configuration
    STORAGESTORAGEPOSITION("Storage.StoragePosition", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //there Is No StorageDevice Configuration
    STORAGESTORAGENOTEXIST("Storage.StorageNotExist", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //lowStorageCapacity Configuration
    STORAGESTORAGELOWSPACE("Storage.StorageLowSpace", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //storageDeviceAccessFailure Configuration
    STORAGESTORAGEFAILURE("Storage.StorageFailure", new TypeToken<DeviceConfig<StorageStorageFailureConfig>>() {
    }.getType()),
    //common Configuration
    GENERALGENERAL("General.General", new TypeToken<DeviceConfig<GeneralConfig>>() {
    }.getType()),
    //localized configuration
    GENERALLOCATION("General.Location", new TypeToken<DeviceConfig<GeneralLocationConfig>>() {
    }.getType()),
    //automatic Maintenance Configuration
    GENERALAUTOMAINTAIN("General.AutoMaintain", new TypeToken<DeviceConfig<GeneralAutoMaintainConfig>>() {
    }.getType()),
    //userRights ConfigurationInformation
    USERS("Users", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //userGroup Permissions ConfigurationInformation
    GROUPS("Groups", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    //coding parameter configuration
    SIMPLIFYENCODE("Simplify.Encode", new TypeToken<DeviceConfig<SimplifyEncodeConfig>>() {
    }.getType()),
    //user Configuration
    SYSTEMEXUSERMAP("System.ExUserMap", new TypeToken<DeviceConfig<SystemExUserMapConfig>>() {
    }.getType()),
    SystemTimeZone("System.TimeZone", new TypeToken<DeviceConfig<SystemTimeZoneConfig>>() {
    }.getType()),
    NetPubCfgDomain("NetWork.NetPubCfgDomain", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    NetCapsDomain("NetWork.NetCapsDomain", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    OnlineUpgrade("NetWork.OnlineUpgrade", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),
    StatusNatInfo("Status.NatInfo", new TypeToken<DeviceConfig<StatusNatInfoConfig>>() {
    }.getType()),
    AlarmPIR("Alarm.PIR", new TypeToken<DeviceConfig<AlarmPIRConfig>>() {
    }.getType()),
    NetWorkSetEnableVideo("NetWork.SetEnableVideo", new TypeToken<DeviceConfig<NetWorkSetEnableVideoConfig>>() {
    }.getType()),
    CATALOG("Catalog", new TypeToken<DeviceConfig<CatalogConfig>>() {
    }.getType()),
    OPUTCTimeSetting("OPUTCTimeSetting", new TypeToken<DeviceConfig<Object>>() {
    }.getType()),

    CustomerFlow("Detect.CustomerFlow", new TypeToken<DeviceConfig<CustomerFlowConfig>>() {
    }.getType()),
    AISceneAreaRule("Detect.AISceneAreaRule", new TypeToken<DeviceConfig<AISceneAreaRuleConfig>>() {
    }.getType()),
    PMSContinuousPush("NetWork.PMSContinuousPush", new TypeToken<DeviceConfig<PMSContinuousPushConfig>>() {
    }.getType()),
    ExtDevIDCfg("ExtDevIDConfig.ExtDevIDCfg", new TypeToken<DeviceConfig<ExDevIDConfig>>() {
    }.getType()),
    DETECTPETDETECTION("Detect.PetDetection", new TypeToken<DeviceConfig<DetectPetDetectionConfig>>() {
    }.getType()),

//    NetUseDigitalEncode("NetUse.DigitalEncode.[0]", new TypeToken<DeviceConfig<Object>>() {
//    }.getType()),
    ;

    /**
     * name Of Configuration
     */
    private final String configName;
    private final Type type;

    JLinkDeviceConfigTypeEnum(String configName, Type type) {
        this.configName = configName;
        this.type = type;
    }

    public static JLinkDeviceConfigTypeEnum get(String jDeviceConfig) {
        for (JLinkDeviceConfigTypeEnum value : values()) {
            if (jDeviceConfig.equals(value.getConfigName())) {
                return value;
            }
        }
        return null;
    }

    public String getConfigName() {
        return configName;
    }

    public Type getType() {
        return type;
    }
}
