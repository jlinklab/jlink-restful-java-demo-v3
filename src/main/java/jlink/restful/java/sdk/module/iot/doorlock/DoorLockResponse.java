package jlink.restful.java.sdk.module.iot.doorlock;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoorLockResponse {
    private Integer code;
    private String msg;
    private DevData data;

    public DoorLockResponse(Integer code, String msg, DevData data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static class DevData {

        @SerializedName("Name")
        private String name;
        @SerializedName("DoorConfig")
        private DoorConfigDTO doorConfig;
        @SerializedName("Ret")
        private Integer ret;
        @SerializedName("SessionID")
        private String sessionID;
        private List<String> props;
        @SerializedName("Data")
        private String data;

        public static class DoorConfigDTO {
            @SerializedName("PirConfig")
            private PirConfigDTO pirConfig;
            @SerializedName("UnlockDirection")
            private UnlockDirectionDTO unlockDirection;
            @SerializedName("AutoLock")
            private AutoLockDTO autoLock;
            @SerializedName("UnlockMode")
            private UnlockModeDTO unlockMode;
            @SerializedName("VolumeControl")
            private VolumeControlDTO volumeControl;
            @SerializedName("FaceAlarmTone")
            private FaceAlarmToneDTO faceAlarmTone;
            @SerializedName("MotorTorque")
            private MotorTorqueDTO motorTorque;
            @SerializedName("NormalOpenMode")
            private NormalOpenModeDTO normalOpenMode;
            @SerializedName("DeployDefense")
            private DeployDefenseDTO deployDefense;


            public static class PirConfigDTO {
                @SerializedName("Enable")
                private Boolean enable;
                private Integer sensitivity;

                public Boolean getEnable() {
                    return enable;
                }

                public void setEnable(Boolean enable) {
                    this.enable = enable;
                }

                public Integer getSensitivity() {
                    return sensitivity;
                }

                public void setSensitivity(Integer sensitivity) {
                    this.sensitivity = sensitivity;
                }
            }


            public static class UnlockDirectionDTO {
                @SerializedName("Direction")
                private Integer direction;

                public Integer getDirection() {
                    return direction;
                }

                public void setDirection(Integer direction) {
                    this.direction = direction;
                }
            }

            public static class AutoLockDTO {
                @SerializedName("LockMode")
                private Integer lockMode;
                @SerializedName("AutoLockInterval")
                private Integer autoLockInterval;

                public Integer getLockMode() {
                    return lockMode;
                }

                public void setLockMode(Integer lockMode) {
                    this.lockMode = lockMode;
                }

                public Integer getAutoLockInterval() {
                    return autoLockInterval;
                }

                public void setAutoLockInterval(Integer autoLockInterval) {
                    this.autoLockInterval = autoLockInterval;
                }
            }

            public static class UnlockModeDTO {
                private Integer mode;

                public Integer getMode() {
                    return mode;
                }

                public void setMode(Integer mode) {
                    this.mode = mode;
                }
            }

            public static class VolumeControlDTO {
                @SerializedName("Volume")
                private Integer volume;

                public Integer getVolume() {
                    return volume;
                }

                public void setVolume(Integer volume) {
                    this.volume = volume;
                }
            }

            public static class FaceAlarmToneDTO {
                @SerializedName("Enable")
                private Boolean enable;

                public Boolean getEnable() {
                    return enable;
                }

                public void setEnable(Boolean enable) {
                    this.enable = enable;
                }
            }

            public static class MotorTorqueDTO {
                @SerializedName("Torque")
                private Integer torque;

                public Integer getTorque() {
                    return torque;
                }

                public void setTorque(Integer torque) {
                    this.torque = torque;
                }
            }

            public static class NormalOpenModeDTO {
                @SerializedName("Mode")
                private Integer mode;

                public Integer getMode() {
                    return mode;
                }

                public void setMode(Integer mode) {
                    this.mode = mode;
                }
            }

            public static class DeployDefenseDTO {
                @SerializedName("Enable")
                private Integer enable;

                public Integer getEnable() {
                    return enable;
                }

                public void setEnable(Integer enable) {
                    this.enable = enable;
                }
            }

            public PirConfigDTO getPirConfig() {
                return pirConfig;
            }

            public void setPirConfig(PirConfigDTO pirConfig) {
                this.pirConfig = pirConfig;
            }

            public UnlockDirectionDTO getUnlockDirection() {
                return unlockDirection;
            }

            public void setUnlockDirection(UnlockDirectionDTO unlockDirection) {
                this.unlockDirection = unlockDirection;
            }

            public AutoLockDTO getAutoLock() {
                return autoLock;
            }

            public void setAutoLock(AutoLockDTO autoLock) {
                this.autoLock = autoLock;
            }

            public UnlockModeDTO getUnlockMode() {
                return unlockMode;
            }

            public void setUnlockMode(UnlockModeDTO unlockMode) {
                this.unlockMode = unlockMode;
            }

            public VolumeControlDTO getVolumeControl() {
                return volumeControl;
            }

            public void setVolumeControl(VolumeControlDTO volumeControl) {
                this.volumeControl = volumeControl;
            }

            public FaceAlarmToneDTO getFaceAlarmTone() {
                return faceAlarmTone;
            }

            public void setFaceAlarmTone(FaceAlarmToneDTO faceAlarmTone) {
                this.faceAlarmTone = faceAlarmTone;
            }

            public MotorTorqueDTO getMotorTorque() {
                return motorTorque;
            }

            public void setMotorTorque(MotorTorqueDTO motorTorque) {
                this.motorTorque = motorTorque;
            }

            public NormalOpenModeDTO getNormalOpenMode() {
                return normalOpenMode;
            }

            public void setNormalOpenMode(NormalOpenModeDTO normalOpenMode) {
                this.normalOpenMode = normalOpenMode;
            }

            public DeployDefenseDTO getDeployDefense() {
                return deployDefense;
            }

            public void setDeployDefense(DeployDefenseDTO deployDefense) {
                this.deployDefense = deployDefense;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public DoorConfigDTO getDoorConfig() {
            return doorConfig;
        }

        public void setDoorConfig(DoorConfigDTO doorConfig) {
            this.doorConfig = doorConfig;
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

        public List<String> getProps() {
            return props;
        }

        public void setProps(List<String> props) {
            this.props = props;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
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

    public DevData getData() {
        return data;
    }

    public void setData(DevData data) {
        this.data = data;
    }
}
