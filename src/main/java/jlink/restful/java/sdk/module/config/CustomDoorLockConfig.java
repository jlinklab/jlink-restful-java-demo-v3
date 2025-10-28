package jlink.restful.java.sdk.module.config;


import com.google.gson.annotations.SerializedName;

/**
 * @author hjm
 * @date 2025/10/28
 */
public class CustomDoorLockConfig extends DeviceConfig {

    @SerializedName("Consumer.DoorLock")
    private ConsumerDoorLockDTO consumerDoorLockDTO;
    @SerializedName("Name")
    private String name;
    @SerializedName("Ret")
    private Integer ret;
    @SerializedName("SessionID")
    private String sessionID;

    public static class ConsumerDoorLockDTO {
        @SerializedName("EventHandler")
        private EventHandlerDTO eventHandler;

        public static class EventHandlerDTO {
            @SerializedName("RecordLatch")
            private Integer recordLatch;

            public Integer getRecordLatch() {
                return recordLatch;
            }

            public void setRecordLatch(Integer recordLatch) {
                this.recordLatch = recordLatch;
            }
        }

        public EventHandlerDTO getEventHandler() {
            return eventHandler;
        }

        public void setEventHandler(EventHandlerDTO eventHandler) {
            this.eventHandler = eventHandler;
        }
    }

    public ConsumerDoorLockDTO getConsumerDoorLockDTO() {
        return consumerDoorLockDTO;
    }

    public void setConsumerDoorLockDTO(ConsumerDoorLockDTO consumerDoorLockDTO) {
        this.consumerDoorLockDTO = consumerDoorLockDTO;
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

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
