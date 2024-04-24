package jlink.restful.java.sdk.module.livestream;

import com.google.gson.annotations.SerializedName;

public class DeviceMediaConvertResponse {
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
        @SerializedName("protocolSrc")
        private String protocolSrc;
        @SerializedName("url")
        private String url;
        @SerializedName("params")
        public ParamDto params;

        public static class ParamDto {
            @SerializedName("SSRC")
            private String ssrc;
            @SerializedName("lanIp")
            private String lanIp;
            @SerializedName("port")
            private int port;
            @SerializedName("wanIp")
            private String wanIp;

            public String getSsrc() {
                return ssrc;
            }

            public void setSsrc(String ssrc) {
                this.ssrc = ssrc;
            }

            public String getLanIp() {
                return lanIp;
            }

            public void setLanIp(String lanIp) {
                this.lanIp = lanIp;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public String getWanIp() {
                return wanIp;
            }

            public void setWanIp(String wanIp) {
                this.wanIp = wanIp;
            }
        }

        public String getProtocolSrc() {
            return protocolSrc;
        }

        public void setProtocolSrc(String protocolSrc) {
            this.protocolSrc = protocolSrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ParamDto getParams() {
            return params;
        }

        public void setParams(ParamDto params) {
            this.params = params;
        }
    }
}
