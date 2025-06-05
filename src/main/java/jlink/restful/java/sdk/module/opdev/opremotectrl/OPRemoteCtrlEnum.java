package jlink.restful.java.sdk.module.opdev.opremotectrl;


/**
 * @author hjm
 * @date 2024/07/03
 */
public enum OPRemoteCtrlEnum {
    Start("0x00000001"),
    Stop("0x00000000");

    public String action;

    OPRemoteCtrlEnum(String action) {
        this.action = action;
    }

    public static OPRemoteCtrlEnum get(String action) {
        for (OPRemoteCtrlEnum value : OPRemoteCtrlEnum.values()) {
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
