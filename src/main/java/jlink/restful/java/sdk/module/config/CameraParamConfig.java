package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author hjm
 * @date 2025/09/26
 */
public class CameraParamConfig extends DeviceConfig {
    @SerializedName("Camera.Param")
    protected List<CameraParamDTO> cameraParamDTO;
    /**
     * name
     */
    @SerializedName("Name")
    protected String name;
    /**
     * ret
     */
    @SerializedName("Ret")
    protected Integer ret;
    /**
     * ret
     */
    @SerializedName("RetMsg")
    protected String retMsg;

    /**
     * sessionId
     */
    @SerializedName("SessionID")
    protected String sessionId;

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

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<CameraParamDTO> getCameraParamDTO() {
        return cameraParamDTO;
    }

    public void setCameraParamDTO(List<CameraParamDTO> cameraParamDTO) {
        this.cameraParamDTO = cameraParamDTO;
    }

    public class CameraParamDTO {

        @SerializedName("AeSensitivity")
        private Integer aeSensitivity;
        @SerializedName("ApertureMode")
        private String apertureMode;
        @SerializedName("BLCMode")
        private String bLCMode;
        @SerializedName("DayNightColor")
        private String dayNightColor;
        @SerializedName("Day_nfLevel")
        private Integer day_nfLevel;
        @SerializedName("DncThr")
        private Integer dncThr;
        @SerializedName("ElecLevel")
        private Integer elecLevel;
        @SerializedName("EsShutter")
        private String esShutter;
        @SerializedName("ExposureParam")
        private ExposureParamDTO exposureParam;
        @SerializedName("GainParam")
        private GainParamDTO gainParam;
        @SerializedName("IRCUTMode")
        private Integer iRCUTMode;
        @SerializedName("InfraredSwap")
        private Integer infraredSwap;
        @SerializedName("IrcutSwap")
        private Integer ircutSwap;
        @SerializedName("Night_nfLevel")
        private Integer night_nfLevel;
        @SerializedName("PictureFlip")
        private String pictureFlip;
        @SerializedName("PictureMirror")
        private String pictureMirror;
        @SerializedName("RejectFlicker")
        private String rejectFlicker;
        @SerializedName("WhiteBalance")
        private String whiteBalance;

        public class ExposureParamDTO {
            @SerializedName("LeastTime")
            private String leastTime;
            @SerializedName("Level")
            private Integer level;
            @SerializedName("MostTime")
            private String mostTime;

            public String getLeastTime() {
                return leastTime;
            }

            public void setLeastTime(String leastTime) {
                this.leastTime = leastTime;
            }

            public Integer getLevel() {
                return level;
            }

            public void setLevel(Integer level) {
                this.level = level;
            }

            public String getMostTime() {
                return mostTime;
            }

            public void setMostTime(String mostTime) {
                this.mostTime = mostTime;
            }
        }

        public class GainParamDTO {
            @SerializedName("AutoGain")
            private Integer autoGain;
            @SerializedName("Gain")
            private Integer gain;

            public Integer getAutoGain() {
                return autoGain;
            }

            public void setAutoGain(Integer autoGain) {
                this.autoGain = autoGain;
            }

            public Integer getGain() {
                return gain;
            }

            public void setGain(Integer gain) {
                this.gain = gain;
            }
        }

        public Integer getAeSensitivity() {
            return aeSensitivity;
        }

        public void setAeSensitivity(Integer aeSensitivity) {
            this.aeSensitivity = aeSensitivity;
        }

        public String getApertureMode() {
            return apertureMode;
        }

        public void setApertureMode(String apertureMode) {
            this.apertureMode = apertureMode;
        }

        public String getbLCMode() {
            return bLCMode;
        }

        public void setbLCMode(String bLCMode) {
            this.bLCMode = bLCMode;
        }

        public String getDayNightColor() {
            return dayNightColor;
        }

        public void setDayNightColor(String dayNightColor) {
            this.dayNightColor = dayNightColor;
        }

        public Integer getDay_nfLevel() {
            return day_nfLevel;
        }

        public void setDay_nfLevel(Integer day_nfLevel) {
            this.day_nfLevel = day_nfLevel;
        }

        public Integer getDncThr() {
            return dncThr;
        }

        public void setDncThr(Integer dncThr) {
            this.dncThr = dncThr;
        }

        public Integer getElecLevel() {
            return elecLevel;
        }

        public void setElecLevel(Integer elecLevel) {
            this.elecLevel = elecLevel;
        }

        public String getEsShutter() {
            return esShutter;
        }

        public void setEsShutter(String esShutter) {
            this.esShutter = esShutter;
        }

        public ExposureParamDTO getExposureParam() {
            return exposureParam;
        }

        public void setExposureParam(ExposureParamDTO exposureParam) {
            this.exposureParam = exposureParam;
        }

        public GainParamDTO getGainParam() {
            return gainParam;
        }

        public void setGainParam(GainParamDTO gainParam) {
            this.gainParam = gainParam;
        }

        public Integer getiRCUTMode() {
            return iRCUTMode;
        }

        public void setiRCUTMode(Integer iRCUTMode) {
            this.iRCUTMode = iRCUTMode;
        }

        public Integer getInfraredSwap() {
            return infraredSwap;
        }

        public void setInfraredSwap(Integer infraredSwap) {
            this.infraredSwap = infraredSwap;
        }

        public Integer getIrcutSwap() {
            return ircutSwap;
        }

        public void setIrcutSwap(Integer ircutSwap) {
            this.ircutSwap = ircutSwap;
        }

        public Integer getNight_nfLevel() {
            return night_nfLevel;
        }

        public void setNight_nfLevel(Integer night_nfLevel) {
            this.night_nfLevel = night_nfLevel;
        }

        public String getPictureFlip() {
            return pictureFlip;
        }

        public void setPictureFlip(String pictureFlip) {
            this.pictureFlip = pictureFlip;
        }

        public String getPictureMirror() {
            return pictureMirror;
        }

        public void setPictureMirror(String pictureMirror) {
            this.pictureMirror = pictureMirror;
        }

        public String getRejectFlicker() {
            return rejectFlicker;
        }

        public void setRejectFlicker(String rejectFlicker) {
            this.rejectFlicker = rejectFlicker;
        }

        public String getWhiteBalance() {
            return whiteBalance;
        }

        public void setWhiteBalance(String whiteBalance) {
            this.whiteBalance = whiteBalance;
        }
    }

    public class BroadTrends {
        @SerializedName("AutoGain")
        public int autoGain;
        @SerializedName("Gain")
        public int gain;

        public int getAutoGain() {
            return autoGain;
        }

        public void setAutoGain(int autoGain) {
            this.autoGain = autoGain;
        }

        public int getGain() {
            return gain;
        }

        public void setGain(int gain) {
            this.gain = gain;
        }
    }
}
