package jlink.restful.java.sdk.module.opdev.opuploadtocaps;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.module.opdev.DeviceOperate;
import jlink.restful.java.sdk.module.opdev.DeviceOperateEnum;


/**
 * @author hjm
 * @date 2024/09/02
 */
public class OPUploadToCapsDTO implements DeviceOperate {
    @Override
    public DeviceOperateEnum getOperateEnum() {
        return DeviceOperateEnum.OPUploadToCaps;
    }

    @SerializedName("Name")
    private final DeviceOperateEnum name = getOperateEnum();

    public DeviceOperateEnum getName() {
        return name;
    }
}
