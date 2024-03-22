package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/2 15:34
 */
public class GetYearReportResponse {

    private Integer code;
    private String msg;
    private PassengerYearFlowInfo data;


    public static class PassengerYearFlowInfo {

        @SerializedName("Ret")
        private Integer ret;



        /**
         * name
         */
        @SerializedName("Name")
        protected String name;

        @SerializedName("CustomerFlowData")
        protected CustomerFlowVO customerFlowVO;


        public static class CustomerFlowVO {
            @SerializedName("Action")
            String action;

            @SerializedName("FlowEnterCount")
            int[] flowEnterCount;

            @SerializedName("FlowLeaveCount")
            int[] flowLeaveCount;

            @SerializedName("FlowPassCount")
            int[] flowPassCount;

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public int[] getFlowEnterCount() {
                return flowEnterCount;
            }

            public void setFlowEnterCount(int[] flowEnterCount) {
                this.flowEnterCount = flowEnterCount;
            }

            public int[] getFlowLeaveCount() {
                return flowLeaveCount;
            }

            public void setFlowLeaveCount(int[] flowLeaveCount) {
                this.flowLeaveCount = flowLeaveCount;
            }

            public int[] getFlowPassCount() {
                return flowPassCount;
            }

            public void setFlowPassCount(int[] flowPassCount) {
                this.flowPassCount = flowPassCount;
            }
        }

        public Integer getRet() {
            return ret;
        }

        public void setRet(Integer ret) {
            this.ret = ret;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CustomerFlowVO getCustomerFlowVO() {
            return customerFlowVO;
        }

        public void setCustomerFlowVO(CustomerFlowVO customerFlowVO) {
            this.customerFlowVO = customerFlowVO;
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

    public PassengerYearFlowInfo getData() {
        return data;
    }

    public void setData(PassengerYearFlowInfo data) {
        this.data = data;
    }
}
