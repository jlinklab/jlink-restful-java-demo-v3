package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/2 15:34
 */
public class ClearPassengerFlowDTO {
    /**
     * name
     */
    @SerializedName("Name")
    protected String name;

    @SerializedName("CustomerFlowData")
    protected CustomerFlowData customerFlowData;



    public static class  CustomerFlowData{
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

    public CustomerFlowData getCustomerFlowData() {
        return customerFlowData;
    }

    public void setCustomerFlowData(CustomerFlowData customerFlowData) {
        this.customerFlowData = customerFlowData;
    }
}
