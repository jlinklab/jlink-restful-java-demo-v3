package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/4 10:50
 */
public class GetYearReportDTO {

    /**
     * name
     */
    @SerializedName("Name")
    protected String name;

    @SerializedName("CustomerFlowData")
    protected YearReportData yearReportData;



    public static class  YearReportData{
        @SerializedName("Action")
        String action;

        /**
         * 查询数据开始时间
         */
        @SerializedName("BeginTime")
        protected String beginTime;

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public int getCycleNum() {
            return cycleNum;
        }

        public void setCycleNum(int cycleNum) {
            this.cycleNum = cycleNum;
        }

        /**
         * 统计次数,最大值为60。如果需要更多统计次数，如80次，则可以修改统计开始时间，再次查询20次即可
         */
        @SerializedName("CycleNum")
        protected int cycleNum;

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

    public YearReportData getYearReportData() {
        return yearReportData;
    }

    public void setYearReportData(YearReportData yearReportData) {
        this.yearReportData = yearReportData;
    }
}
