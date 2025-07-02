package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

/**
 * DetectTrack
 *
 * @author hjm
 * @date 2025/07/02
 */
public class DetectTrackConfig extends DeviceConfig {
    @SerializedName("Detect.DetectTrack")
    protected DetectTrackDTO detectTrackDTO;
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
     * sessionID
     */
    @SerializedName("SessionID")
    protected String sessionID;

    public DetectTrackDTO getDetectTrackDTO() {
        return detectTrackDTO;
    }

    public void setDetectTrackDTO(DetectTrackDTO detectTrackDTO) {
        this.detectTrackDTO = detectTrackDTO;
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

    public static class DetectTrackDTO {
        @SerializedName("Enable")
        private Integer enable;

        /**
         * 0：low, 1：middle, 2：high
         */
        @SerializedName("Sensitivity")
        private Integer sensitivity;

        /**
         * How long does it take for a humanoid target to return to its default position, in seconds
         * 0: No need to return
         * 1~600: Return after specified time
         */
        @SerializedName("ReturnTime")
        private Integer returnTime;

        public Integer getEnable() {
            return enable;
        }

        public void setEnable(Integer enable) {
            this.enable = enable;
        }

        public Integer getSensitivity() {
            return sensitivity;
        }

        public void setSensitivity(Integer sensitivity) {
            this.sensitivity = sensitivity;
        }

        public Integer getReturnTime() {
            return returnTime;
        }

        public void setReturnTime(Integer returnTime) {
            this.returnTime = returnTime;
        }
    }
}
