package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * NetWork AlarmServer Configuration
 *
 * @author hjm
 * @date 2024/06/26
 */
public class NetWorkAlarmServerConfig extends DeviceConfig {
    @SerializedName("NetWork.AlarmServer")
    protected List<NetWorkAlarmServerDTO> alarmServerDTOs;
    /**
     * name
     */
    @SerializedName("Name")
    protected String name;
    /**
     * ret
     */
    @SerializedName("Ret")
    protected Integer ret;
    /**
     * ret
     */
    @SerializedName("RetMsg")
    protected String retMsg;

    /**
     * sessionId
     */
    @SerializedName("SessionID")
    protected String sessionId;

    public List<NetWorkAlarmServerDTO> getAlarmServerDTOs() {
        return alarmServerDTOs;
    }

    public void setAlarmServerDTOs(List<NetWorkAlarmServerDTO> alarmServerDTOs) {
        this.alarmServerDTOs = alarmServerDTOs;
    }

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

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public static class NetWorkAlarmServerDTO {
        @SerializedName("Alarm")
        private Boolean alarm;
        @SerializedName("Enable")
        private Boolean enable;
        @SerializedName("Protocol")
        private String protocol;
        @SerializedName("Log")
        private Boolean log;

        @SerializedName("Server")
        private ServerDto server;

        public static class ServerDto {
            @SerializedName("Address")
            private String address;
            @SerializedName("Name")
            private String name;
            @SerializedName("UserName")
            private String username;
            @SerializedName("Password")
            private String password;
            @SerializedName("Port")
            private int port;
            @SerializedName("Anonymity")
            private Boolean anonymity;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public Boolean getAnonymity() {
                return anonymity;
            }

            public void setAnonymity(Boolean anonymity) {
                this.anonymity = anonymity;
            }
        }


        public Boolean getAlarm() {
            return alarm;
        }

        public void setAlarm(Boolean alarm) {
            this.alarm = alarm;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public Boolean getLog() {
            return log;
        }

        public void setLog(Boolean log) {
            this.log = log;
        }

        public ServerDto getServer() {
            return server;
        }

        public void setServer(ServerDto server) {
            this.server = server;
        }
    }
}
