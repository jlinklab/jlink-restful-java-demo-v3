package jlink.restful.java.sdk.module.iot.feeder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeviceFeederResponse {
    private Integer code;
    private String msg;
    private DevData data;

    public DeviceFeederResponse(Integer code, String msg, DevData data) {
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
        @SerializedName("props")
        private PropsDto props;
        @SerializedName("OPFeedManual")
        private OPFeedManual opFeedManual;

        public static class OPFeedManual {

            @SerializedName("Feeded")
            private Integer feeded;
            @SerializedName("NotFeeding")
            private Integer notFeeding;

            public Integer getFeeded() {
                return feeded;
            }

            public void setFeeded(Integer feeded) {
                this.feeded = feeded;
            }

            public Integer getNotFeeding() {
                return notFeeding;
            }

            public void setNotFeeding(Integer notFeeding) {
                this.notFeeding = notFeeding;
            }
        }

        public static class PropsDto {

            private List<FeedPlanDTO> feedPlan;

            public static class FeedPlanDTO {
                private Boolean enable;
                private String cron;
                private ActionDTO action;

                public static class ActionDTO {
                    private Integer feed;

                    public Integer getFeed() {
                        return feed;
                    }

                    public void setFeed(Integer feed) {
                        this.feed = feed;
                    }
                }

                public Boolean getEnable() {
                    return enable;
                }

                public void setEnable(Boolean enable) {
                    this.enable = enable;
                }

                public String getCron() {
                    return cron;
                }

                public void setCron(String cron) {
                    this.cron = cron;
                }

                public ActionDTO getAction() {
                    return action;
                }

                public void setAction(ActionDTO action) {
                    this.action = action;
                }
            }

            public List<FeedPlanDTO> getFeedPlan() {
                return feedPlan;
            }

            public void setFeedPlan(List<FeedPlanDTO> feedPlan) {
                this.feedPlan = feedPlan;
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

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public PropsDto getProps() {
            return props;
        }

        public void setProps(PropsDto props) {
            this.props = props;
        }

        public OPFeedManual getOpFeedManual() {
            return opFeedManual;
        }

        public void setOpFeedManual(OPFeedManual opFeedManual) {
            this.opFeedManual = opFeedManual;
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
