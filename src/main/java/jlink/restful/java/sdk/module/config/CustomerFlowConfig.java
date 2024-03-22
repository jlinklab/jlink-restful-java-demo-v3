package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

/**
 * @author luojx
 * @date 2023/6/28 10:58
 */
public class CustomerFlowConfig extends DeviceConfig{

    @SerializedName("Detect.CustomerFlow")
    private CustomerFlow customerFlow; // 注意字段名称的选择
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

    public CustomerFlow getCustomerFlow() {
        return customerFlow;
    }

    public void setCustomerFlow(CustomerFlow customerFlow) {
        this.customerFlow = customerFlow;
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

    public static class CustomerFlow {
        @SerializedName("AutoResetOSDDate")
        private int autoResetOSDDate;

        public int getAutoResetOSDDate() {
            return autoResetOSDDate;
        }

        public void setAutoResetOSDDate(int autoResetOSDDate) {
            this.autoResetOSDDate = autoResetOSDDate;
        }

        public boolean isAutoResetOSDEnable() {
            return autoResetOSDEnable;
        }

        public void setAutoResetOSDEnable(boolean autoResetOSDEnable) {
            this.autoResetOSDEnable = autoResetOSDEnable;
        }

        public String getAutoResetOSDTime() {
            return autoResetOSDTime;
        }

        public void setAutoResetOSDTime(String autoResetOSDTime) {
            this.autoResetOSDTime = autoResetOSDTime;
        }

        public String getAutoResetOSDType() {
            return autoResetOSDType;
        }

        public void setAutoResetOSDType(String autoResetOSDType) {
            this.autoResetOSDType = autoResetOSDType;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public int getWriteFileCycle() {
            return writeFileCycle;
        }

        public void setWriteFileCycle(int writeFileCycle) {
            this.writeFileCycle = writeFileCycle;
        }

        @SerializedName("AutoResetOSDEnable")
        private boolean autoResetOSDEnable;
        @SerializedName("AutoResetOSDTime")
        private String autoResetOSDTime;
        @SerializedName("AutoResetOSDType")
        private String autoResetOSDType;
        @SerializedName("FileSize")
        private int fileSize;
        @SerializedName("WriteFileCycle")
        private int writeFileCycle;
    }
}
