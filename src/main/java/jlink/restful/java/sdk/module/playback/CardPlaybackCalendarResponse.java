package jlink.restful.java.sdk.module.playback;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardPlaybackCalendarResponse {
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("Ret")
        private Integer ret;
        @SerializedName("Name")
        private String name;
        @SerializedName("retMsg")
        private String retMsg;
        @SerializedName("CalendarList")
        private List<CalendarList> calendarLists;

        public static class CalendarList{
            @SerializedName("date")
            private String date;
            @SerializedName("is_exist")
            private int isExist;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getIsExist() {
                return isExist;
            }

            public void setIsExist(int isExist) {
                this.isExist = isExist;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CalendarList> getCalendarLists() {
            return calendarLists;
        }

        public void setCalendarLists(List<CalendarList> calendarLists) {
            this.calendarLists = calendarLists;
        }

        public Integer getRet() {
            return ret;
        }

        public void setRet(Integer ret) {
            this.ret = ret;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }
    }
}
