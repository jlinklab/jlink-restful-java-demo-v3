package jlink.restful.java.sdk.module.opdev.opremotectrl;

import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.module.opdev.DeviceOperateResponse;

/**
 * @author hjm
 * @date 2024/07/03
 */
public class OPRemoteCtrlResponse extends DeviceOperateResponse {
    @SerializedName("Name")
    private String name;
    @SerializedName("Ret")
    private Integer ret;
    @SerializedName("SessionID")
    private String sessionID;

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
}
