package jlink.restful.java.sdk.module.iot.feeder;


import java.util.List;

/**
 * FeedPlan DTO
 *
 * @author hjm
 * @date 2025/10/28
 */
public class FeedPlanDTO {

    private String sn;
    private List<String> props;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<String> getProps() {
        return props;
    }

    public void setProps(List<String> props) {
        this.props = props;
    }
}
