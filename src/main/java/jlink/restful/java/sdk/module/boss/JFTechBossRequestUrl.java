package jlink.restful.java.sdk.module.boss;

/**
 * BOSS OpenAPI Enum
 */
public enum JFTechBossRequestUrl {
    /**
     * listCardPool
     */
    LIST_CARD_POOL("restful/boss-api-open/api/v3/listCardPool"),
    /**
     * cardApply
     */
    CARD_APPLY("restful/boss-api-open/api/v3/cardApply"),
    /**
     * transferCard
     */
    TRANSFER_CARD("restful/boss-api-open/api/v3/transferCard"),
    /**
     * cardUsedInfo
     */
    CARD_USED_INFO("restful/boss-api-open/api/v3/cardUsedInfo");


    private String requestUrl;

    JFTechBossRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String get() {
        return requestUrl;
    }

    public void set(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
