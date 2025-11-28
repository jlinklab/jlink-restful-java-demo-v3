package jlink.restful.java.sdk.module.cloudstorage;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Device cloud storage pic response
 *
 * @author luojx
 * @date 2022/6/28 10:02
 */
public class DeviceCloudStoragePicResponse {
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<UrlDto> data;
    private boolean isFinished;
    private int total;
    private int pageSize;
    private int pageNum;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public List<UrlDto> getData() {
        return data;
    }

    public void setData(List<UrlDto> data) {
        this.data = data;
    }

    public static class UrlDto {
        @SerializedName("url")
        private String url;
        private String id;
        private String objName;
        @SerializedName("AlarmEvent")
        private String alarmEvent;
        @SerializedName("AlarmTime")
        private String alarmTime;
        @SerializedName("Channel")
        private String channel;
        private List<UrlList> urlList;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getObjName() {
            return objName;
        }

        public void setObjName(String objName) {
            this.objName = objName;
        }

        public String getAlarmEvent() {
            return alarmEvent;
        }

        public void setAlarmEvent(String alarmEvent) {
            this.alarmEvent = alarmEvent;
        }

        public String getAlarmTime() {
            return alarmTime;
        }

        public void setAlarmTime(String alarmTime) {
            this.alarmTime = alarmTime;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public List<UrlList> getUrlList() {
            return urlList;
        }

        public void setUrlList(List<UrlList> urlList) {
            this.urlList = urlList;
        }

        public static class UrlList {
            private int lens;
            private String objName;
            private String url;

            public int getLens() {
                return lens;
            }

            public void setLens(int lens) {
                this.lens = lens;
            }

            public String getObjName() {
                return objName;
            }

            public void setObjName(String objName) {
                this.objName = objName;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
