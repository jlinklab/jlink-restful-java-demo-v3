package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

/**
 * ExtDevIDConfig
 *
 * @author hjm
 * @date 2024/05/24
 */
public class ExDevIDConfig extends DeviceConfig {
    @SerializedName("ExtDevIDConfig.ExtDevIDCfg")
    protected ExtDevIDCfg extDevIDCfg;
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

    public ExtDevIDCfg getExtDevIDCfg() {
        return extDevIDCfg;
    }

    public void setExtDevIDCfg(ExtDevIDCfg extDevIDCfg) {
        this.extDevIDCfg = extDevIDCfg;
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

    public static class ExtDevIDCfg {
        @SerializedName("AdvIntel")
        private String advIntel;

        @SerializedName("ExtProtocol")
        private String extProtocol;

        @SerializedName("OEMSelfDef")
        private String oEMSelfDef;
        @SerializedName("PrimerIntel")
        private String primerIntel;
        @SerializedName("SubDevID")
        private String subDevID;
        @SerializedName("WifiType")
        private String wifiType;

        public String getAdvIntel() {
            return advIntel;
        }

        public void setAdvIntel(String advIntel) {
            this.advIntel = advIntel;
        }

        public String getExtProtocol() {
            return extProtocol;
        }

        public void setExtProtocol(String extProtocol) {
            this.extProtocol = extProtocol;
        }

        public String getoEMSelfDef() {
            return oEMSelfDef;
        }

        public void setoEMSelfDef(String oEMSelfDef) {
            this.oEMSelfDef = oEMSelfDef;
        }

        public String getPrimerIntel() {
            return primerIntel;
        }

        public void setPrimerIntel(String primerIntel) {
            this.primerIntel = primerIntel;
        }

        public String getSubDevID() {
            return subDevID;
        }

        public void setSubDevID(String subDevID) {
            this.subDevID = subDevID;
        }

        public String getWifiType() {
            return wifiType;
        }

        public void setWifiType(String wifiType) {
            this.wifiType = wifiType;
        }
    }
}
