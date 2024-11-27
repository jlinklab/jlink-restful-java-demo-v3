package jlink.restful.java.sdk.module.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @author hjm
 * @date 2024/08/26
 */
public class AISceneAreaRuleConfig extends DeviceConfig {

    @SerializedName("Detect.AISceneAreaRule")
    private List<AISceneAreaRuleDTO> aiSceneAreaRuleDTOS;// FIXME check this code
    @SerializedName("Name")
    private String name;
    @SerializedName("Ret")
    private Integer ret;
    @SerializedName("SessionID")
    private String sessionID;

    public List<AISceneAreaRuleDTO> getAiSceneAreaRuleDTOS() {
        return aiSceneAreaRuleDTOS;
    }

    public void setAiSceneAreaRuleDTOS(List<AISceneAreaRuleDTO> aiSceneAreaRuleDTOS) {
        this.aiSceneAreaRuleDTOS = aiSceneAreaRuleDTOS;
    }

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

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public static class AISceneAreaRuleDTO {
        @SerializedName("Rule")
        private List<RuleDTO> ruleDTOS;

        public List<RuleDTO> getRuleDTOS() {
            return ruleDTOS;
        }

        public void setRuleDTOS(List<RuleDTO> ruleDTOS) {
            this.ruleDTOS = ruleDTOS;
        }

        public static class RuleDTO {
            @SerializedName("DevAlgo")
            private String devAlgo;
            @SerializedName("PushEvent")
            private String pushEvent;
            @SerializedName("RuleName")
            private String ruleName;
            @SerializedName("RuleRegion")
            private RuleRegionDTO ruleRegion;

            public String getDevAlgo() {
                return devAlgo;
            }

            public void setDevAlgo(String devAlgo) {
                this.devAlgo = devAlgo;
            }

            public String getPushEvent() {
                return pushEvent;
            }

            public void setPushEvent(String pushEvent) {
                this.pushEvent = pushEvent;
            }

            public String getRuleName() {
                return ruleName;
            }

            public void setRuleName(String ruleName) {
                this.ruleName = ruleName;
            }

            public RuleRegionDTO getRuleRegion() {
                return ruleRegion;
            }

            public void setRuleRegion(RuleRegionDTO ruleRegion) {
                this.ruleRegion = ruleRegion;
            }

            public static class RuleRegionDTO {
                @SerializedName("Pst")
                private List<PstDTO> pst;
                @SerializedName("PstNum")
                private Integer pstNum;

                public List<PstDTO> getPst() {
                    return pst;
                }

                public void setPst(List<PstDTO> pst) {
                    this.pst = pst;
                }

                public Integer getPstNum() {
                    return pstNum;
                }

                public void setPstNum(Integer pstNum) {
                    this.pstNum = pstNum;
                }

                public static class PstDTO {
                    @SerializedName("X")
                    private Integer x;
                    @SerializedName("Y")
                    private Integer y;

                    public Integer getX() {
                        return x;
                    }

                    public void setX(Integer x) {
                        this.x = x;
                    }

                    public Integer getY() {
                        return y;
                    }

                    public void setY(Integer y) {
                        this.y = y;
                    }
                }
            }
        }

    }
}
