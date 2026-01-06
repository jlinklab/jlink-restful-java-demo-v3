package jlink.restful.java.sdk.module.info;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.module.opdev.opdiskmanager.OPStorageInfoResponse;

import java.util.List;

public class DeviceInfoResponse {
    private Integer code;
    private String msg;
    private DevInfo data;

    public DeviceInfoResponse(Integer code, String msg, DevInfo data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static class DevInfo {
        @SerializedName("Name")
        private String name;
        @SerializedName("Ret")
        private Integer ret;
        @SerializedName("SessionID")
        private String sessionID;
        @SerializedName("SystemInfo")
        private SystemInfoDTO systemInfo;

        @SerializedName("SystemInfoEx")
        private SystemInfoExDTO systemInfoEx;

        @SerializedName("StorageInfo")
        private List<OPStorageInfoResponse.StorageInfoDTO> storageInfo;

        @SerializedName("WifiRouteInfo")
        private WifiRouteInfo wifiRouteInfo;

        @SerializedName("4GInfo")
        private G4Info g4Info;

        @SerializedName("SignalLevel")
        private Integer signalLevel;

        public List<OPStorageInfoResponse.StorageInfoDTO> getStorageInfo() {
            return storageInfo;
        }

        public void setStorageInfo(List<OPStorageInfoResponse.StorageInfoDTO> storageInfo) {
            this.storageInfo = storageInfo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getRet() {
            return ret;
        }

        public void setRet(Integer ret) {
            this.ret = ret;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public SystemInfoDTO getSystemInfo() {
            return systemInfo;
        }

        public void setSystemInfo(SystemInfoDTO systemInfo) {
            this.systemInfo = systemInfo;
        }

        public SystemInfoExDTO getSystemInfoEx() {
            return systemInfoEx;
        }

        public void setSystemInfoEx(SystemInfoExDTO systemInfoEx) {
            this.systemInfoEx = systemInfoEx;
        }

        public WifiRouteInfo getWifiRouteInfo() {
            return wifiRouteInfo;
        }

        public void setWifiRouteInfo(WifiRouteInfo wifiRouteInfo) {
            this.wifiRouteInfo = wifiRouteInfo;
        }

        public G4Info getG4Info() {
            return g4Info;
        }

        public void setG4Info(G4Info g4Info) {
            this.g4Info = g4Info;
        }

        public Integer getSignalLevel() {
            return signalLevel;
        }

        public void setSignalLevel(Integer signalLevel) {
            this.signalLevel = signalLevel;
        }

        public static class SystemInfoDTO {
            @SerializedName("AlarmInChannel")
            private Integer alarmInChannel;
            @SerializedName("AlarmOutChannel")
            private Integer alarmOutChannel;
            @SerializedName("AudioInChannel")
            private Integer audioInChannel;
            @SerializedName("BuildTime")
            private String buildTime;
            @SerializedName("CombineSwitch")
            private Integer combineSwitch;
            @SerializedName("DeviceModel")
            private String deviceModel;
            @SerializedName("DeviceRunTime")
            private String deviceRunTime;
            @SerializedName("DigChannel")
            private Integer digChannel;
            @SerializedName("EncryptVersion")
            private String encryptVersion;
            @SerializedName("ExtraChannel")
            private Integer extraChannel;
            @SerializedName("HardWare")
            private String hardWare;
            @SerializedName("HardWareVersion")
            private String hardWareVersion;
            @SerializedName("SerialNo")
            private String serialNo;
            @SerializedName("SoftWareVersion")
            private String softWareVersion;
            @SerializedName("TalkInChannel")
            private Integer talkInChannel;
            @SerializedName("TalkOutChannel")
            private Integer talkOutChannel;
            @SerializedName("UpdataTime")
            private String updataTime;
            @SerializedName("UpdataType")
            private String updataType;
            @SerializedName("VideoInChannel")
            private Integer videoInChannel;
            @SerializedName("VideoOutChannel")
            private Integer videoOutChannel;
            @SerializedName("Modules")
            private List<Module> modules;

            public static class Module {
                @SerializedName("CurVersion")
                private String curVersion;
                @SerializedName("Partition")
                private String partition;

                public String getCurVersion() {
                    return curVersion;
                }

                public void setCurVersion(String curVersion) {
                    this.curVersion = curVersion;
                }

                public String getPartition() {
                    return partition;
                }

                public void setPartition(String partition) {
                    this.partition = partition;
                }
            }

            public Integer getAlarmInChannel() {
                return alarmInChannel;
            }

            public void setAlarmInChannel(Integer alarmInChannel) {
                this.alarmInChannel = alarmInChannel;
            }

            public Integer getAlarmOutChannel() {
                return alarmOutChannel;
            }

            public void setAlarmOutChannel(Integer alarmOutChannel) {
                this.alarmOutChannel = alarmOutChannel;
            }

            public Integer getAudioInChannel() {
                return audioInChannel;
            }

            public void setAudioInChannel(Integer audioInChannel) {
                this.audioInChannel = audioInChannel;
            }

            public String getBuildTime() {
                return buildTime;
            }

            public void setBuildTime(String buildTime) {
                this.buildTime = buildTime;
            }

            public Integer getCombineSwitch() {
                return combineSwitch;
            }

            public void setCombineSwitch(Integer combineSwitch) {
                this.combineSwitch = combineSwitch;
            }

            public String getDeviceModel() {
                return deviceModel;
            }

            public void setDeviceModel(String deviceModel) {
                this.deviceModel = deviceModel;
            }

            public String getDeviceRunTime() {
                return deviceRunTime;
            }

            public void setDeviceRunTime(String deviceRunTime) {
                this.deviceRunTime = deviceRunTime;
            }

            public Integer getDigChannel() {
                return digChannel;
            }

            public void setDigChannel(Integer digChannel) {
                this.digChannel = digChannel;
            }

            public String getEncryptVersion() {
                return encryptVersion;
            }

            public void setEncryptVersion(String encryptVersion) {
                this.encryptVersion = encryptVersion;
            }

            public Integer getExtraChannel() {
                return extraChannel;
            }

            public void setExtraChannel(Integer extraChannel) {
                this.extraChannel = extraChannel;
            }

            public String getHardWare() {
                return hardWare;
            }

            public void setHardWare(String hardWare) {
                this.hardWare = hardWare;
            }

            public String getHardWareVersion() {
                return hardWareVersion;
            }

            public void setHardWareVersion(String hardWareVersion) {
                this.hardWareVersion = hardWareVersion;
            }

            public String getSerialNo() {
                return serialNo;
            }

            public void setSerialNo(String serialNo) {
                this.serialNo = serialNo;
            }

            public String getSoftWareVersion() {
                return softWareVersion;
            }

            public void setSoftWareVersion(String softWareVersion) {
                this.softWareVersion = softWareVersion;
            }

            public Integer getTalkInChannel() {
                return talkInChannel;
            }

            public void setTalkInChannel(Integer talkInChannel) {
                this.talkInChannel = talkInChannel;
            }

            public Integer getTalkOutChannel() {
                return talkOutChannel;
            }

            public void setTalkOutChannel(Integer talkOutChannel) {
                this.talkOutChannel = talkOutChannel;
            }

            public String getUpdataTime() {
                return updataTime;
            }

            public void setUpdataTime(String updataTime) {
                this.updataTime = updataTime;
            }

            public String getUpdataType() {
                return updataType;
            }

            public void setUpdataType(String updataType) {
                this.updataType = updataType;
            }

            public Integer getVideoInChannel() {
                return videoInChannel;
            }

            public void setVideoInChannel(Integer videoInChannel) {
                this.videoInChannel = videoInChannel;
            }

            public Integer getVideoOutChannel() {
                return videoOutChannel;
            }

            public void setVideoOutChannel(Integer videoOutChannel) {
                this.videoOutChannel = videoOutChannel;
            }

            public List<Module> getModules() {
                return modules;
            }

            public void setModules(List<Module> modules) {
                this.modules = modules;
            }
        }

        public static class SystemInfoExDTO {
            @SerializedName("McuVersion")
            private String mcuVersion;
            @SerializedName("ExModules")
            private List<ExModulesDTO> exModules;

            public String getMcuVersion() {
                return mcuVersion;
            }

            public void setMcuVersion(String mcuVersion) {
                this.mcuVersion = mcuVersion;
            }

            public List<ExModulesDTO> getExModules() {
                return exModules;
            }

            public void setExModules(List<ExModulesDTO> exModules) {
                this.exModules = exModules;
            }

            public static class ExModulesDTO {
                @SerializedName("CurVersion")
                private String curVersion;
                @SerializedName("Modules")
                private List<ModulesDTO> modules;
                @SerializedName("Name")
                private String name;
                @SerializedName("UpDevID")
                private String upDevID;

                public static class ModulesDTO {
                    @SerializedName("CurVersion")
                    private String curVersion;
                    @SerializedName("ModuleType")
                    private String moduleType;
                    @SerializedName("Partition")
                    private String partition;

                    public String getCurVersion() {
                        return curVersion;
                    }

                    public void setCurVersion(String curVersion) {
                        this.curVersion = curVersion;
                    }

                    public String getModuleType() {
                        return moduleType;
                    }

                    public void setModuleType(String moduleType) {
                        this.moduleType = moduleType;
                    }

                    public String getPartition() {
                        return partition;
                    }

                    public void setPartition(String partition) {
                        this.partition = partition;
                    }
                }

                public String getCurVersion() {
                    return curVersion;
                }

                public void setCurVersion(String curVersion) {
                    this.curVersion = curVersion;
                }

                public List<ModulesDTO> getModules() {
                    return modules;
                }

                public void setModules(List<ModulesDTO> modules) {
                    this.modules = modules;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUpDevID() {
                    return upDevID;
                }

                public void setUpDevID(String upDevID) {
                    this.upDevID = upDevID;
                }
            }
        }

        public static class WifiRouteInfo {
            @SerializedName("Eth0Status")
            public boolean eth0Status;

            @SerializedName("SignalLevel")
            private Integer signalLevel;

            @SerializedName("WlanMac")
            private String wlanMac;

            @SerializedName("WlanStatus")
            private boolean wlanStatus;

            public boolean isEth0Status() {
                return eth0Status;
            }

            public void setEth0Status(boolean eth0Status) {
                this.eth0Status = eth0Status;
            }

            public Integer getSignalLevel() {
                return signalLevel;
            }

            public void setSignalLevel(Integer signalLevel) {
                this.signalLevel = signalLevel;
            }

            public String getWlanMac() {
                return wlanMac;
            }

            public void setWlanMac(String wlanMac) {
                this.wlanMac = wlanMac;
            }

            public boolean isWlanStatus() {
                return wlanStatus;
            }

            public void setWlanStatus(boolean wlanStatus) {
                this.wlanStatus = wlanStatus;
            }
        }

        public static class G4Info {
            @SerializedName("SignalLevel")
            public int signalLevel;

            public int getSignalLevel() {
                return signalLevel;
            }

            public void setSignalLevel(int signalLevel) {
                this.signalLevel = signalLevel;
            }
        }
    }


    public static DeviceInfoResponse newInstance() {
        return new DeviceInfoResponse(JLinkResponseCode.SUCCESS.getCode(), JLinkResponseCode.SUCCESS.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DevInfo getData() {
        return data;
    }

    public void setData(DevInfo data) {
        this.data = data;
    }
}
