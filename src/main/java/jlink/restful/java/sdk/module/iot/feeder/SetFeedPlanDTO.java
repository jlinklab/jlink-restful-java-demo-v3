package jlink.restful.java.sdk.module.iot.feeder;


import java.util.List;

/**
 * Set FeedPlan DTO
 *
 * @author hjm
 * @date 2025/10/28
 */
public class SetFeedPlanDTO {
    private String sn;
    private PropsDTO props;

    public static class PropsDTO {
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public PropsDTO getProps() {
        return props;
    }

    public void setProps(PropsDTO props) {
        this.props = props;
    }
}
