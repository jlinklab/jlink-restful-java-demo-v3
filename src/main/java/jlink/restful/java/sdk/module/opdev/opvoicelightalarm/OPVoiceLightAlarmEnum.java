package jlink.restful.java.sdk.module.opdev.opvoicelightalarm;


/**
 * @author hjm
 * @date 2024/03/30
 */
public enum OPVoiceLightAlarmEnum {
    Start("Start"),
    Stop("Stop");

    public String action;

    OPVoiceLightAlarmEnum(String action) {
        this.action = action;
    }

    public static OPVoiceLightAlarmEnum get(String action) {
        for (OPVoiceLightAlarmEnum value : OPVoiceLightAlarmEnum.values()) {
            if (action.equals(value.name())) {
                return value;
            }
        }
        return Start;
    }

    public String getAction() {
        return action;
    }
}
