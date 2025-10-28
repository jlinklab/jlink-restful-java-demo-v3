package jlink.restful.java.sdk.module.iot.feeder;

import com.google.gson.annotations.SerializedName;

public class DeviceFeederSwitchResponse {
    private Integer code;
    private String msg;
    private DevData data;

    public DeviceFeederSwitchResponse(Integer code, String msg, DevData data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static class DevData {
        @SerializedName("Name")
        private String name;
        @SerializedName("Ret")
        private Integer ret;
        @SerializedName("SessionID")
        private String sessionID;
        @SerializedName("Switch")
        private String switchStatus;

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

        public String getSwitchStatus() {
            return switchStatus;
        }

        public void setSwitchStatus(String switchStatus) {
            this.switchStatus = switchStatus;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DevData getData() {
        return data;
    }

    public void setData(DevData data) {
        this.data = data;
    }
}
