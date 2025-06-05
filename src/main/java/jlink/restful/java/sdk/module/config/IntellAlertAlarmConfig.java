package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @author hjm
 * @date 2024/07/03
 */
public class IntellAlertAlarmConfig extends DeviceConfig {
    @SerializedName("Alarm.IntellAlertAlarm")
    protected IntellAlertAlarmDTO intellAlertAlarmDTO;
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

    public IntellAlertAlarmDTO getIntellAlertAlarmDTO() {
        return intellAlertAlarmDTO;
    }

    public void setIntellAlertAlarmDTO(IntellAlertAlarmDTO intellAlertAlarmDTO) {
        this.intellAlertAlarmDTO = intellAlertAlarmDTO;
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

    public static class IntellAlertAlarmDTO {

        @SerializedName("Enable")
        private Boolean enable;
        @SerializedName("Duration")
        private Integer duration;
        @SerializedName("EventHandler")
        private EventHandlerDTO eventHandler;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public EventHandlerDTO getEventHandler() {
            return eventHandler;
        }

        public void setEventHandler(EventHandlerDTO eventHandler) {
            this.eventHandler = eventHandler;
        }

        public static class EventHandlerDTO {
            @SerializedName("PtzEnable")
            private Boolean ptzEnable;
            @SerializedName("BeepEnable")
            private Boolean beepEnable;
            @SerializedName("MessageEnable")
            private Boolean messageEnable;
            @SerializedName("TimeSection")
            private List<List<String>> timeSection;
            @SerializedName("MatrixEnable")
            private Boolean matrixEnable;
            @SerializedName("VoiceTipInterval")
            private Integer voiceTipInterval;
            @SerializedName("AlarmOutLatch")
            private Integer alarmOutLatch;
            @SerializedName("PtzLink")
            private List<List<String>> ptzLink;
            @SerializedName("MsgtoNetEnable")
            private Boolean msgtoNetEnable;
            @SerializedName("AlarmOutEnable")
            private Boolean alarmOutEnable;
            @SerializedName("FTPEnable")
            private Boolean fTPEnable;
            @SerializedName("AlarmOutMask")
            private String alarmOutMask;
            @SerializedName("MailEnable")
            private Boolean mailEnable;
            @SerializedName("MatrixMask")
            private String matrixMask;
            @SerializedName("LogEnable")
            private Boolean logEnable;
            @SerializedName("VoiceEnable")
            private Boolean voiceEnable;
            @SerializedName("EventLatch")
            private Integer eventLatch;
            @SerializedName("SnapEnable")
            private Boolean snapEnable;
            @SerializedName("RecordEnable")
            private Boolean recordEnable;
            @SerializedName("LightAlarmMode")
            private Integer lightAlarmMode;
            @SerializedName("VoiceType")
            private Integer voiceType;

            public Boolean getPtzEnable() {
                return ptzEnable;
            }

            public void setPtzEnable(Boolean ptzEnable) {
                this.ptzEnable = ptzEnable;
            }

            public Boolean getBeepEnable() {
                return beepEnable;
            }

            public void setBeepEnable(Boolean beepEnable) {
                this.beepEnable = beepEnable;
            }

            public Boolean getMessageEnable() {
                return messageEnable;
            }

            public void setMessageEnable(Boolean messageEnable) {
                this.messageEnable = messageEnable;
            }

            public List<List<String>> getTimeSection() {
                return timeSection;
            }

            public void setTimeSection(List<List<String>> timeSection) {
                this.timeSection = timeSection;
            }

            public Boolean getMatrixEnable() {
                return matrixEnable;
            }

            public void setMatrixEnable(Boolean matrixEnable) {
                this.matrixEnable = matrixEnable;
            }

            public Integer getVoiceTipInterval() {
                return voiceTipInterval;
            }

            public void setVoiceTipInterval(Integer voiceTipInterval) {
                this.voiceTipInterval = voiceTipInterval;
            }

            public Integer getAlarmOutLatch() {
                return alarmOutLatch;
            }

            public void setAlarmOutLatch(Integer alarmOutLatch) {
                this.alarmOutLatch = alarmOutLatch;
            }

            public List<List<String>> getPtzLink() {
                return ptzLink;
            }

            public void setPtzLink(List<List<String>> ptzLink) {
                this.ptzLink = ptzLink;
            }

            public Boolean getMsgtoNetEnable() {
                return msgtoNetEnable;
            }

            public void setMsgtoNetEnable(Boolean msgtoNetEnable) {
                this.msgtoNetEnable = msgtoNetEnable;
            }

            public Boolean getAlarmOutEnable() {
                return alarmOutEnable;
            }

            public void setAlarmOutEnable(Boolean alarmOutEnable) {
                this.alarmOutEnable = alarmOutEnable;
            }

            public Boolean getfTPEnable() {
                return fTPEnable;
            }

            public void setfTPEnable(Boolean fTPEnable) {
                this.fTPEnable = fTPEnable;
            }

            public String getAlarmOutMask() {
                return alarmOutMask;
            }

            public void setAlarmOutMask(String alarmOutMask) {
                this.alarmOutMask = alarmOutMask;
            }

            public Boolean getMailEnable() {
                return mailEnable;
            }

            public void setMailEnable(Boolean mailEnable) {
                this.mailEnable = mailEnable;
            }

            public String getMatrixMask() {
                return matrixMask;
            }

            public void setMatrixMask(String matrixMask) {
                this.matrixMask = matrixMask;
            }

            public Boolean getLogEnable() {
                return logEnable;
            }

            public void setLogEnable(Boolean logEnable) {
                this.logEnable = logEnable;
            }

            public Boolean getVoiceEnable() {
                return voiceEnable;
            }

            public void setVoiceEnable(Boolean voiceEnable) {
                this.voiceEnable = voiceEnable;
            }

            public Integer getEventLatch() {
                return eventLatch;
            }

            public void setEventLatch(Integer eventLatch) {
                this.eventLatch = eventLatch;
            }

            public Boolean getSnapEnable() {
                return snapEnable;
            }

            public void setSnapEnable(Boolean snapEnable) {
                this.snapEnable = snapEnable;
            }

            public Boolean getRecordEnable() {
                return recordEnable;
            }

            public void setRecordEnable(Boolean recordEnable) {
                this.recordEnable = recordEnable;
            }

            public Integer getLightAlarmMode() {
                return lightAlarmMode;
            }

            public void setLightAlarmMode(Integer lightAlarmMode) {
                this.lightAlarmMode = lightAlarmMode;
            }

            public Integer getVoiceType() {
                return voiceType;
            }

            public void setVoiceType(Integer voiceType) {
                this.voiceType = voiceType;
            }
        }
    }
}
