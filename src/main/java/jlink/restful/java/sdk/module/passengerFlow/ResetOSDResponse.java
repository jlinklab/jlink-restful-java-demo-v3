package jlink.restful.java.sdk.module.passengerFlow;

import com.google.gson.annotations.SerializedName;

/**
 * @author Wan Zero
 * @description: 清空OSD叠加
 * @date 2024/2/2 15:34
 */
public class ResetOSDResponse {

    private Integer code;
    private String msg;
    private RestOSD data;

    public static class RestOSD {

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

    public RestOSD getData() {
        return data;
    }

    public void setData(RestOSD data) {
        this.data = data;
    }
}
