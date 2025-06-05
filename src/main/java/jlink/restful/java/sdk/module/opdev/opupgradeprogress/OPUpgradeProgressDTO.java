package jlink.restful.java.sdk.module.opdev.opupgradeprogress;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.module.opdev.DeviceOperate;
import jlink.restful.java.sdk.module.opdev.DeviceOperateEnum;


/**
 * @author hjm
 * @date 2025/04/03
 */
public class OPUpgradeProgressDTO implements DeviceOperate {
    @Override
    public DeviceOperateEnum getOperateEnum() {
        return DeviceOperateEnum.OPUpgradeProgress;
    }

    @SerializedName("Name")
    private final DeviceOperateEnum name = getOperateEnum();
    @SerializedName("Sn")
    private String sn;

    public DeviceOperateEnum getName() {
        return name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
