package jlink.restful.java.sdk.module.opdev.opvoicelightalarm;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.module.opdev.DeviceOperate;
import jlink.restful.java.sdk.module.opdev.DeviceOperateEnum;

/**
 * @author hjm
 * @date 2024/03/30
 */
public class OPVoiceLightAlarmDTO implements DeviceOperate {
    @Override
    public DeviceOperateEnum getOperateEnum() {
        return DeviceOperateEnum.OPVoiceLightAlarm;
    }

    @SerializedName("Name")
    private final DeviceOperateEnum name = getOperateEnum();

    @SerializedName("OPVoiceLightAlarm")
    private OPVoiceLightAlarm opVoiceLightAlarm;

    public DeviceOperateEnum getName() {
        return name;
    }

    public OPVoiceLightAlarm getOpVoiceLightAlarm() {
        return opVoiceLightAlarm;
    }

    public void setOpVoiceLightAlarm(OPVoiceLightAlarm opVoiceLightAlarm) {
        this.opVoiceLightAlarm = opVoiceLightAlarm;
    }

    public static class OPVoiceLightAlarm {
        /**
         * Action
         */
        @SerializedName("Action")
        private String action;
        /**
         * LightFreq
         */
        @SerializedName("LightFreq")
        private int lightFreq;
        /**
         * VoiceType
         */
        @SerializedName("VoiceType")
        private int voiceType;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public int getLightFreq() {
            return lightFreq;
        }

        public void setLightFreq(int lightFreq) {
            this.lightFreq = lightFreq;
        }

        public int getVoiceType() {
            return voiceType;
        }

        public void setVoiceType(int voiceType) {
            this.voiceType = voiceType;
        }
    }
}
