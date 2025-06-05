package jlink.restful.java.sdk.module.opdev.opremotectrl;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.module.opdev.DeviceOperate;
import jlink.restful.java.sdk.module.opdev.DeviceOperateEnum;

/**
 * @author hjm
 * @date 2024/07/03
 */
public class OPRemoteCtrlDTO implements DeviceOperate {
    @Override
    public DeviceOperateEnum getOperateEnum() {
        return DeviceOperateEnum.OPRemoteCtrl;
    }

    @SerializedName("Name")
    private final DeviceOperateEnum name = getOperateEnum();
    @SerializedName("OPRemoteCtrl")
    private OPRemoteCtrl opRemoteCtrl;

    public DeviceOperateEnum getName() {
        return name;
    }

    public OPRemoteCtrl getOpRemoteCtrl() {
        return opRemoteCtrl;
    }

    public void setOpRemoteCtrl(OPRemoteCtrl opRemoteCtrl) {
        this.opRemoteCtrl = opRemoteCtrl;
    }

    public static class OPRemoteCtrl {
        @SerializedName("Type")
        private String type = "ManuIntelAlarm";

        @SerializedName("msg")
        private String msg = OPRemoteCtrlEnum.Start.getAction();

        @SerializedName("P1")
        private String p1 = "0x0";
        @SerializedName("P2")
        private String p2 = "0x0";

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getP1() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1 = p1;
        }

        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }
    }

}
