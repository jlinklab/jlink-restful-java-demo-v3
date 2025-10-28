package jlink.restful.java.sdk.module.iot.feeder;


/**
 * Feeder DTO
 *
 * @author hjm
 * @date 2025/10/28
 */
public class FeederDTO {

    private String sn;
    private PropsDTO props;

    public static class PropsDTO {
        private int feed;

        public int getFeed() {
            return feed;
        }

        public void setFeed(int feed) {
            this.feed = feed;
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
