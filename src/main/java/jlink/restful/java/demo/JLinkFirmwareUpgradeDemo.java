package jlink.restful.java.demo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.JLinkDevice;
import jlink.restful.java.sdk.competent.JLinkDeviceInfoEnum;
import jlink.restful.java.sdk.competent.JLinkDeviceRequestUrl;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.module.info.DeviceInfoResponse;
import jlink.restful.java.sdk.module.login.DeviceLoginData;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;
import jlink.restful.java.sdk.util.JLinkLog;

import java.util.ArrayList;
import java.util.List;

public class JLinkFirmwareUpgradeDemo {

    public static void main(String[] args) {
        /**
         * uuid/appKey/appSecret/moveCard Apply for an application through the open platform (https://open.jftech.com) console, and obtain it after successful review
         */
        JLinkClient jClient = new JLinkClient(
                "e0534f3240274897821a126be19b6d46",
                "5b027c14d371332e88a9cbae30375ee7",
                "fd664d5fa6974ec09023818f68b23212",
                5);
        JLinkDevice jDevice = new JLinkDevice(jClient, "1234567890123456", "admin", "");
        DeviceLoginData loginData = jDevice.login();

        DeviceInfoResponse.DevInfo info = jDevice.deviceInfo(JLinkDeviceInfoEnum.SystemInfo);
        String serialNo = info.getSystemInfo().getSerialNo();
        String deviceId = info.getSystemInfo().getSoftWareVersion();
        String curVersion = info.getSystemInfo().getBuildTime();
        String devType = loginData.getDeviceType();

        //OPVersionReq
        OPVersionReq req = new OPVersionReq();
        OPVersionReq.OPVersionReqDto opVersionReqDto = new OPVersionReq.OPVersionReqDto();
        opVersionReqDto.setUuid(serialNo);
        opVersionReqDto.setDevId(deviceId);
        opVersionReqDto.setCurVersion(curVersion);
        opVersionReqDto.setDevType(changeType(devType));
        req.setOpVersionReqDto(opVersionReqDto);

        //Assemble the request address for obtaining the device capability set
        String requestDeviceOperateUrl = String.format("%s/%s/%s", JLinkDomain.OPENAPI_DOMAIN.get(), JLinkDeviceRequestUrl.DEVICE_OPDEV.get(), jDevice.getDeviceToken());
        //send https request
        String res = JLinkHttpUtil.httpsRequest(requestDeviceOperateUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(req));
        VersionRes versionRes = new Gson().fromJson(res, VersionRes.class);
        if (versionRes.getData().getRet() == 1000) {

            //start updateGrade
            OPStartUpgradeReq opStartUpgradeReq = new OPStartUpgradeReq();
            OPStartUpgradeReq.OPStartUpgradeReqDto opStartUpgradeReqDto = new OPStartUpgradeReq.OPStartUpgradeReqDto();
            List<OPStartUpgradeReq.OPStartUpgradeReqDto.Module> list = new ArrayList<>();
            OPStartUpgradeReq.OPStartUpgradeReqDto.Module module = new OPStartUpgradeReq.OPStartUpgradeReqDto.Module();
            module.setPartition("");//此参数如果上一步获取新版本没有返回，不用传。 IOT设备会有此参数。
            module.setDate(versionRes.getData().getoPVersionRep().getDate());
            module.setFileName(versionRes.getData().getoPVersionRep().getFileName());
            module.setFileSize(versionRes.getData().getoPVersionRep().getFileSize());

            list.add(module);
            opStartUpgradeReqDto.setModules(list);
            opStartUpgradeReqDto.setSerialNo(serialNo);
            opStartUpgradeReq.setOpStartUpgradeReqDto(opStartUpgradeReqDto);
            //send https request
            String resData = JLinkHttpUtil.httpsRequest(requestDeviceOperateUrl, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(jClient), new Gson().toJson(req));
        } else {
            JLinkLog.i(versionRes.getData().getRet() + ":" + versionRes.getData().getRetMsg());
        }
    }


    public static class OPStartUpgradeReq {
        @SerializedName("Name")
        private String name = "OPStartUpgradeReq";
        @SerializedName("OPStartUpgradeReq")
        private OPStartUpgradeReqDto opStartUpgradeReqDto;

        public static class OPStartUpgradeReqDto {
            @SerializedName("UUID")
            private String serialNo;
            @SerializedName("Manual")
            private int manual = 1;
            @SerializedName("Modules")
            private List<Module> modules;

            public static class Module {
                @SerializedName("Partition")
                private String partition;
                @SerializedName("Date")
                private String date;
                @SerializedName("FileName")
                private String fileName;
                @SerializedName("FileSize")
                private int fileSize;

                public String getPartition() {
                    return partition;
                }

                public void setPartition(String partition) {
                    this.partition = partition;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getFileName() {
                    return fileName;
                }

                public void setFileName(String fileName) {
                    this.fileName = fileName;
                }

                public int getFileSize() {
                    return fileSize;
                }

                public void setFileSize(int fileSize) {
                    this.fileSize = fileSize;
                }
            }

            public String getSerialNo() {
                return serialNo;
            }

            public void setSerialNo(String serialNo) {
                this.serialNo = serialNo;
            }

            public int getManual() {
                return manual;
            }

            public void setManual(int manual) {
                this.manual = manual;
            }

            public List<Module> getModules() {
                return modules;
            }

            public void setModules(List<Module> modules) {
                this.modules = modules;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OPStartUpgradeReqDto getOpStartUpgradeReqDto() {
            return opStartUpgradeReqDto;
        }

        public void setOpStartUpgradeReqDto(OPStartUpgradeReqDto opStartUpgradeReqDto) {
            this.opStartUpgradeReqDto = opStartUpgradeReqDto;
        }
    }


    private static int changeType(String devType) {
        if (devType.equals("DVR")) return 0;
        else if (devType.equals("NVS")) return 1;
        else if (devType.equals("IPC")) return 2;
        else if (devType.equals("HVR")) return 3;
        else if (devType.equals("IVR")) return 4;
        else if (devType.equals("MVR")) return 5;
        else if (devType.equals("IOT")) return 6;
        else return 0;
    }

    public static class VersionRes {
        @SerializedName("code")
        private Integer code;
        @SerializedName("msg")
        private String msg;
        @SerializedName("data")
        private DataDTO data;

        public static class DataDTO {
            @SerializedName("Name")
            private String name;
            @SerializedName("OPVersionRep")
            private DataDTO.OPVersionRepDTO oPVersionRep;
            @SerializedName("Ret")
            private Integer ret;
            @SerializedName("SessionID")
            private String sessionID;
            @SerializedName("RetMsg")
            private String retMsg;

            public String getRetMsg() {
                return retMsg;
            }

            public void setRetMsg(String retMsg) {
                this.retMsg = retMsg;
            }

            public static class OPVersionRepDTO {
                @SerializedName("ChangeLog")
                private String changeLog;
                @SerializedName("Date")
                private String date;
                @SerializedName("DevID")
                private String devID;
                @SerializedName("FileLevel")
                private Integer fileLevel;
                @SerializedName("FileName")
                private String fileName;
                @SerializedName("FileSize")
                private Integer fileSize;

                public String getChangeLog() {
                    return changeLog;
                }

                public void setChangeLog(String changeLog) {
                    this.changeLog = changeLog;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getDevID() {
                    return devID;
                }

                public void setDevID(String devID) {
                    this.devID = devID;
                }

                public Integer getFileLevel() {
                    return fileLevel;
                }

                public void setFileLevel(Integer fileLevel) {
                    this.fileLevel = fileLevel;
                }

                public String getFileName() {
                    return fileName;
                }

                public void setFileName(String fileName) {
                    this.fileName = fileName;
                }

                public Integer getFileSize() {
                    return fileSize;
                }

                public void setFileSize(Integer fileSize) {
                    this.fileSize = fileSize;
                }
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public OPVersionRepDTO getoPVersionRep() {
                return oPVersionRep;
            }

            public void setoPVersionRep(OPVersionRepDTO oPVersionRep) {
                this.oPVersionRep = oPVersionRep;
            }

            public Integer getRet() {
                return ret;
            }

            public void setRet(Integer ret) {
                this.ret = ret;
            }

            public String getSessionID() {
                return sessionID;
            }

            public void setSessionID(String sessionID) {
                this.sessionID = sessionID;
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

        public DataDTO getData() {
            return data;
        }

        public void setData(DataDTO data) {
            this.data = data;
        }
    }

    public static class OPVersionReq {
        @SerializedName("Name")
        private String name = "OPVersionReq";
        @SerializedName("OPVersionReq")
        public OPVersionReqDto opVersionReqDto;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OPVersionReqDto getOpVersionReqDto() {
            return opVersionReqDto;
        }

        public void setOpVersionReqDto(OPVersionReqDto opVersionReqDto) {
            this.opVersionReqDto = opVersionReqDto;
        }

        public static class OPVersionReqDto {
            @SerializedName("Expect")
            private int expect = 0;
            @SerializedName("Language")
            private String lan = "Chinese";
            @SerializedName("Manual")
            private int manual = 1;
            @SerializedName("UUID")
            private String uuid;
            @SerializedName("DevID")
            private String devId;
            @SerializedName("CurVersion")
            private String curVersion;
            @SerializedName("DevType")
            private int devType;

            public int getExpect() {
                return expect;
            }

            public void setExpect(int expect) {
                this.expect = expect;
            }

            public String getLan() {
                return lan;
            }

            public void setLan(String lan) {
                this.lan = lan;
            }

            public int getManual() {
                return manual;
            }

            public void setManual(int manual) {
                this.manual = manual;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getDevId() {
                return devId;
            }

            public void setDevId(String devId) {
                System.out.println(devId);
                String[] s = devId.split("\\.");
                this.devId = s[3] + s[4] + s[5] + s[6];
            }

            public String getCurVersion() {
                return curVersion;
            }

            public void setCurVersion(String curVersion) {
                this.curVersion = curVersion;
            }

            public int getDevType() {
                return devType;
            }

            public void setDevType(int devType) {
                this.devType = devType;
            }
        }
    }


}
