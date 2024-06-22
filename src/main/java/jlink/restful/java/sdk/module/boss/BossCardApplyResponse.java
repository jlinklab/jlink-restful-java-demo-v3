package jlink.restful.java.sdk.module.boss;

import com.google.gson.annotations.SerializedName;

/**
 * @author hjm
 * @date 2024/06/21
 */
public class BossCardApplyResponse {
    private Integer code;
    private String msg;
    private CardApplyDto data;

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

    public CardApplyDto getData() {
        return data;
    }

    public void setData(CardApplyDto data) {
        this.data = data;
    }

    public static class CardApplyDto {
        @SerializedName("cardId")
        private String cardId;

        public String getCardId() {
            return cardId;
        }
    }
}
