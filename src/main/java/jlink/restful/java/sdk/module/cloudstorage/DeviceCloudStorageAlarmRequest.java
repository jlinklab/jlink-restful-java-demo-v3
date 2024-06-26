package jlink.restful.java.sdk.module.cloudstorage;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDeviceResponseCode;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkDeviceInfoException;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.List;

/**
 * Device cloud storage alarm request
 *
 * @author luojx
 * @date 2022/6/28 10:01
 */
public class DeviceCloudStorageAlarmRequest {

    public List<DeviceCloudStoragePicResponse.UrlDto> getPicUrl(List<String> alarmIds, String devToken, JLinkClient mJLinkClient) {
        DeviceCloudStoragePicResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETPICURL.get(), devToken);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(alarmIds));
        try {
            response = new Gson().fromJson(res, DeviceCloudStoragePicResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response.getData();
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public String getVideoUrl(String startTime, String stopTime, String devToken, JLinkClient mJLinkClient) {
        DeviceCloudStorageVideoResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETVIDEOURL.get(), devToken);
        GetVideoUrlParam param = new GetVideoUrlParam();
        param.setStartTime(startTime);
        param.setStopTime(stopTime);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceCloudStorageVideoResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response.getData().getUrl();
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public String getVideoUrl(String sn, int channel, String fileFormat, String startTime, String stopTime, String devToken, JLinkClient mJLinkClient) {
        DeviceCloudStorageVideoResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETVIDEOURL.get(), devToken);
        GetVideoUrlDto param = new GetVideoUrlDto();
        param.setStartTime(startTime);
        param.setStopTime(stopTime);
        param.setSn(sn);
        param.setChannel(channel);
        param.setFileFormat(fileFormat);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceCloudStorageVideoResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response.getData().getUrl();
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }


    public List<DeviceCloudStorageVideoListResponse.DataDTO.VideoDTO> getVideoList(String startTime, String stopTime, String devToken, JLinkClient mJLinkClient) {
        DeviceCloudStorageVideoListResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETVIDEOLIST.get(), devToken);
        GetVideoUrlParam param = new GetVideoUrlParam();
        param.setStartTime(startTime);
        param.setStopTime(stopTime);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceCloudStorageVideoListResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                if (response.getData().getRet() == JLinkDeviceResponseCode.SUCCESS.getCode()) {
                    return response.getData().getVideoDTOS();
                } else {
                    //If the RESTFul API request is successful, the device returns the login failure, and the returned information is judged uniformly according to the ret value.
                    throw new JLinkDeviceInfoException(response.getData().getRet(), JLinkDeviceResponseCode.get(response.getData().getRet()).getMsg());
                }
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public List<DeviceCloudStoragePicResponse.UrlDto> getVideoPicUrl(List<GetVideoPicUrlParam> param, String devToken, JLinkClient mJLinkClient) {
        DeviceCloudStoragePicResponse response;
        String requestUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_GETVIDEOPICURL.get(), devToken);
        String res = JLinkHttpUtil.post(requestUrl, JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(param));
        try {
            response = new Gson().fromJson(res, DeviceCloudStoragePicResponse.class);
            if (response.getCode() == JLinkResponseCode.SUCCESS.getCode()) {
                return response.getData();
            } else {
                //RESTFul API request status code judgment
                throw new JLinkDeviceInfoException(response.getCode(), JLinkResponseCode.get(response.getCode()).getMsg());
            }
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    private static class GetVideoUrlParam {
        @SerializedName("startTime")
        private String startTime;
        @SerializedName("stopTime")
        private String stopTime;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStopTime() {
            return stopTime;
        }

        public void setStopTime(String stopTime) {
            this.stopTime = stopTime;
        }
    }

    private static class GetVideoUrlDto extends GetVideoUrlParam {
        @SerializedName("sn")
        private String sn;
        @SerializedName("channel")
        private int channel;
        @SerializedName("fileFormat")
        private String fileFormat;

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public String getFileFormat() {
            return fileFormat;
        }

        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }
    }


    public static class GetVideoPicUrlParam {
        @SerializedName("ObjName")
        private String objName;
        @SerializedName("StorageBucket")
        private String storageBucket;

        public GetVideoPicUrlParam(String objName, String storageBucket) {
            this.objName = objName;
            this.storageBucket = storageBucket;
        }

        public GetVideoPicUrlParam() {
        }

        public String getObjName() {
            return objName;
        }

        public void setObjName(String objName) {
            this.objName = objName;
        }

        public String getStorageBucket() {
            return storageBucket;
        }

        public void setStorageBucket(String storageBucket) {
            this.storageBucket = storageBucket;
        }
    }
}
