package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/4 10:50
 */
public class ResetOSDReDTO {

    /**
     * name
     */
    @SerializedName("Name")
    protected String name;

    @SerializedName("CustomerFlowData")
    protected OSDFlowData customerFlowData;



    public static class  OSDFlowData{
        @SerializedName("Action")
        String action;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OSDFlowData getCustomerFlowData() {
        return customerFlowData;
    }

    public void setCustomerFlowData(OSDFlowData customerFlowData) {
        this.customerFlowData = customerFlowData;
    }
}
