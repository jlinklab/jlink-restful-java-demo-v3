package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/2 14:16
 */
public class CustomerFlowDTO {
    /**
     * name
     */
    @SerializedName("Name")
    protected String name;

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

    @SerializedName("CustomerFlowData")
    protected CustomerFlowData customerFlowData;

    public static class  CustomerFlowData{
        public CustomerFlowData() {

        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public CustomerFlowData(String action, String beginTime, int countCycles, int cycleNum) {
            this.action = action;
            this.beginTime = beginTime;
            this.countCycles = countCycles;
            this.cycleNum = cycleNum;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public int getCountCycles() {
            return countCycles;
        }

        public void setCountCycles(int countCycles) {
            this.countCycles = countCycles;
        }

        public int getCycleNum() {
            return cycleNum;
        }

        public void setCycleNum(int cycleNum) {
            this.cycleNum = cycleNum;
        }

        /**
         * 获取客流数据
         */
        @SerializedName("Action")
        protected String action;

        /**
         * 查询数据开始时间
         */
        @SerializedName("BeginTime")
        protected String beginTime;

        /**
         * 统计周期；单位【分钟】，取值范围5~1440
         */
        @SerializedName("CountCycles")
        protected int countCycles;

        /**
         * 统计次数,最大值为60。如果需要更多统计次数，如80次，则可以修改统计开始时间，再次查询20次即可
         */
        @SerializedName("CycleNum")
        protected int cycleNum;

    }

}
