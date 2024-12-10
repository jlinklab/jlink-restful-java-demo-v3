package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * NetDDNS
 *
 * @author hjm
 * @date 2024/12/09
 */
public class NetWorkNetDDNSConfig extends DeviceConfig {


    @SerializedName("NetWork.NetDDNS")
    protected List<NetWorkNetDDNSDTO> netWorkNetDDNSDTO;
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

    public static class NetWorkNetDDNSDTO {

        /**
         * DDNSKey
         */
        @SerializedName("DDNSKey")
        private String dDNSKey;
        /**
         * HostName
         */
        @SerializedName("HostName")
        private String hostName;
        /**
         * Enable
         */
        @SerializedName("Enable")
        private Boolean enable;
        /**
         * Online
         */
        @SerializedName("Online")
        private Boolean online;
        /**
         * Server
         */
        @SerializedName("Server")
        private ServerDto Server;

        public static class ServerDto {
            @SerializedName("Address")
            private String address;
            @SerializedName("Anonymity")
            private Boolean anonymity;
            @SerializedName("Name")
            private String name;
            @SerializedName("Password")
            private String password;
            @SerializedName("UserName")
            private String userName;
            @SerializedName("Port")
            private int port;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Boolean getAnonymity() {
                return anonymity;
            }

            public void setAnonymity(Boolean anonymity) {
                this.anonymity = anonymity;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }
        }

        public String getdDNSKey() {
            return dDNSKey;
        }

        public void setdDNSKey(String dDNSKey) {
            this.dDNSKey = dDNSKey;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public Boolean getOnline() {
            return online;
        }

        public void setOnline(Boolean online) {
            this.online = online;
        }

        public ServerDto getServer() {
            return Server;
        }

        public void setServer(ServerDto server) {
            Server = server;
        }
    }

    public List<NetWorkNetDDNSDTO> getNetWorkNetDDNSDTO() {
        return netWorkNetDDNSDTO;
    }

    public void setNetWorkNetDDNSDTO(List<NetWorkNetDDNSDTO> netWorkNetDDNSDTO) {
        this.netWorkNetDDNSDTO = netWorkNetDDNSDTO;
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
}
