package jlink.restful.java.sdk.module.cloudstorage;

import com.google.gson.annotations.SerializedName;

/**
 * Device cloud storage response
 *
 * @author hjm
 * @date 2024/05/29
 */
public class DeviceCloudStorageResponse {
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataDto data;

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

    public DataDto getData() {
        return data;
    }

    public void setData(DataDto data) {
        this.data = data;
    }

    public static class DataDto {
        @SerializedName("Name")
        private String name;
        @SerializedName("Ret")
        private Integer ret;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getRet() {
            return ret;
        }

        public void setRet(Integer ret) {
            this.ret = ret;
        }
    }
}
