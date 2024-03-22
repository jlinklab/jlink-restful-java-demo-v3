package jlink.restful.java.sdk.competent;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/2 14:38
 */
public enum JLinkCustomerFlowEnum {
    GetInOutCount("GetInOutCount"),

    ClearInOutCount("ClearInOutCount"),

    CustomerFlowData("CustomerFlowData"),

    ResetFlowOsd("ResetFlowOsd"),

    GetYearReportByM("GetYearReportByM");


    private String action;

    JLinkCustomerFlowEnum(String action) {
        this.action = action;
    }

    public String get() {
        return action;
    }

}
