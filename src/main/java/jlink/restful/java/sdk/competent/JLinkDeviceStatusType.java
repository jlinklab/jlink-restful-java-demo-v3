package jlink.restful.java.sdk.competent;


/**
 * @author hjm
 * @date 2025/11/18
 */
public enum JLinkDeviceStatusType {
    Global("Global"),
    Local("Local");

    private String mDeviceStatusType;

    JLinkDeviceStatusType(String deviceStatusType) {
        this.mDeviceStatusType = deviceStatusType;
    }

    public String get() {
        return mDeviceStatusType;
    }
}
