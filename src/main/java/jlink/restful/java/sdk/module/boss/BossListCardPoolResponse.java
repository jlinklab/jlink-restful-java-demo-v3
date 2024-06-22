package jlink.restful.java.sdk.module.boss;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author hjm
 * @date 2024/06/21
 */
public class BossListCardPoolResponse {
    private Integer code;
    private String msg;
    private List<ListCardPoolDto> data;

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

    public List<ListCardPoolDto> getData() {
        return data;
    }

    public void setData(List<ListCardPoolDto> data) {
        this.data = data;
    }

    public static class ListCardPoolDto {
        @SerializedName("goodsNu")
        private Double goodsNu;
        @SerializedName("name")
        private String name;
        @SerializedName("num")
        private Double num;
        @SerializedName("goodsCode")
        private String goodsCode;
        @SerializedName("area")
        private String area;

        public Double getGoodsNu() {
            return goodsNu;
        }

        public String getName() {
            return name;
        }

        public Double getNum() {
            return num;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public String getArea() {
            return area;
        }
    }
}
