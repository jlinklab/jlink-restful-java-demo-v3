package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @author hjm
 * @date 2024/08/26
 */
public class PMSContinuousPushConfig extends DeviceConfig {
    @SerializedName("NetWork.PMSContinuousPush")
    protected PMSContinuousPushDTO pmsContinuousPushDTO;
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

    public PMSContinuousPushDTO getPmsContinuousPushDTO() {
        return pmsContinuousPushDTO;
    }

    public void setPmsContinuousPushDTO(PMSContinuousPushDTO pmsContinuousPushDTO) {
        this.pmsContinuousPushDTO = pmsContinuousPushDTO;
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

    public static class PMSContinuousPushDTO {

        @SerializedName("PicPushInterval")
        private List<Integer> picPushInterval;
        @SerializedName("IsPush")
        private Boolean isPush;

        public List<Integer> getPicPushInterval() {
            return picPushInterval;
        }

        public void setPicPushInterval(List<Integer> picPushInterval) {
            this.picPushInterval = picPushInterval;
        }

        public Boolean getPush() {
            return isPush;
        }

        public void setPush(Boolean push) {
            isPush = push;
        }
    }
}
