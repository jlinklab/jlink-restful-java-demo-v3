package jlink.restful.java.sdk.module.iot.doorlock;

import com.google.gson.annotations.SerializedName;

public class DoorLockConfigDTO {
    @SerializedName("Name")
    private String name;
    @SerializedName("OPDoorLockProCmd")
    private OPDoorLockProCmd proCmd;

    public static class OPDoorLockProCmd {
        @SerializedName("Cmd")
        private String cmd = "GetDoorConfig";
        @SerializedName("Data")
        private String data;

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OPDoorLockProCmd getProCmd() {
        return proCmd;
    }

    public void setProCmd(OPDoorLockProCmd proCmd) {
        this.proCmd = proCmd;
    }
}
