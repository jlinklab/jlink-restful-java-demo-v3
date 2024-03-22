package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: TODO
 * @date 2024/2/2 15:34
 */
public class ClearPassengerFlowResponse {

    private Integer code;
    private String msg;
    private ClearPassengerInfo data;

    public static class ClearPassengerInfo {

        @SerializedName("Ret")
        private Integer ret;

        public Integer getRet() {
            return ret;
        }

        public void setRet(Integer ret) {
            this.ret = ret;
        }

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

    public ClearPassengerInfo getData() {
        return data;
    }

    public void setData(ClearPassengerInfo data) {
        this.data = data;
    }
}
