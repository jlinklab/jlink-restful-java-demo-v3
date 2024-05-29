package jlink.restful.java.sdk.module.livestream;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceLiveStreamException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Device Media Convert Request
 *
 * @author hjm
 * @date 2024/04/20
 */
public class DeviceMediaConvertRequest {

    /**
     * @param alogAppUuid
     * @param sn
     * @param protocol
     * @param sliceType
     * @param videoCode
     * @param audioCode
     * @param protocolSrc
     * @param expireTime
     * @param type
     * @param url
     * @param jClient
     * @return {@link DeviceMediaConvertResponse}
     */
    public DeviceMediaConvertResponse deviceMediaConvert(String alogAppUuid, String sn, String protocol, String sliceType, String videoCode, String audioCode, String protocolSrc, String expireTime, String type, String url, JLinkClient jClient) {
        DeviceMediaConvertResponse response;
        String requestUrl = String.format("%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.MEDIA_CONVERT.get());
        MediaConvertParam param = new MediaConvertParam();
        param.setSn(sn);
        param.setProtocol(protocol);
        param.setSliceType(sliceType);
        param.setProtocolSrc(protocolSrc);
        if (null != expireTime && !"".equals(expireTime)) param.setExpireTime(expireTime);
        if (null != videoCode && !"".equals(videoCode)) param.setVideoCode(videoCode);
        if (null != audioCode && !"".equals(audioCode)) param.setAudioCode(audioCode);

        MediaConvertParam.SrcOperation srcOperation = new MediaConvertParam.SrcOperation();
        srcOperation.setType(StringUtils.isNotBlank(type) ? type : "ai_task");
        srcOperation.setUrl(url);
        MediaConvertParam.SrcOperation.Body body = new MediaConvertParam.SrcOperation.Body();
        body.setAppUuid(alogAppUuid);
        srcOperation.setBody(body);
        param.setSrcOperation(srcOperation);
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceMediaConvertResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response;
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceLiveStreamException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


    /**
     * @author hjm
     * @date 2024/04/20
     */
    private static class MediaConvertParam {
        /**
         * alog AppUuid
         */
        private String alogAppUuid;
        /**
         * sn
         */
        private String sn;
        /**
         * protocol     flv,hls(default),rtsp,rtmp,rtsp-pri
         */
        private String protocol;
        /**
         * sliceType    hls:ts:(default)fmp4
         */
        private String sliceType;

        /**
         * videoCode
         */
        private String videoCode;
        /**
         * audioCode
         */
        private String audioCode;

        /**
         * protocolSrc  tcp-pri：TCP（default）
         */
        private String protocolSrc;

        /**
         * dueToTime   ms
         */
        public String expireTime;

        private SrcOperation srcOperation;

        public static class SrcOperation {
            private String type;
            private String url;
            private Body body;

            public static class Body {
                @SerializedName("app_uuid")
                private String appUuid;

                public String getAppUuid() {
                    return appUuid;
                }

                public void setAppUuid(String appUuid) {
                    this.appUuid = appUuid;
                }
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Body getBody() {
                return body;
            }

            public void setBody(Body body) {
                this.body = body;
            }
        }

        public SrcOperation getSrcOperation() {
            return srcOperation;
        }

        public void setSrcOperation(SrcOperation srcOperation) {
            this.srcOperation = srcOperation;
        }

        public String getAlogAppUuid() {
            return alogAppUuid;
        }

        public void setAlogAppUuid(String alogAppUuid) {
            this.alogAppUuid = alogAppUuid;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getSliceType() {
            return sliceType;
        }

        public String getVideoCode() {
            return videoCode;
        }

        public void setVideoCode(String videoCode) {
            this.videoCode = videoCode;
        }

        public void setSliceType(String sliceType) {
            this.sliceType = sliceType;
        }

        public String getAudioCode() {
            return audioCode;
        }

        public void setAudioCode(String audioCode) {
            this.audioCode = audioCode;
        }

        public String getProtocolSrc() {
            return protocolSrc;
        }

        public void setProtocolSrc(String protocolSrc) {
            this.protocolSrc = protocolSrc;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }
    }
}
