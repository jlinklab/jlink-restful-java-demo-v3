package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @author hjm
 * @date 2024/09/11
 */

public class UartPTZPresetConfig extends DeviceConfig {

    @SerializedName("Name")
    protected String name;
    @SerializedName("Ret")
    protected Integer ret;
    @SerializedName("RetMsg")
    protected String retMsg;
    @SerializedName("SessionID")
    protected String sessionID;
    @SerializedName("Uart.PTZPreset")
    private List<List<UartPTZPresetDTO>> uartPTZs;

    public static class UartPTZPresetDTO {
        @SerializedName("Id")
        private Integer id;
        @SerializedName("PresetName")
        private String presetName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPresetName() {
            return presetName;
        }

        public void setPresetName(String presetName) {
            this.presetName = presetName;
        }
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

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public List<List<UartPTZPresetDTO>> getUartPTZs() {
        return uartPTZs;
    }

    public void setUartPTZs(List<List<UartPTZPresetDTO>> uartPTZs) {
        this.uartPTZs = uartPTZs;
    }
}
