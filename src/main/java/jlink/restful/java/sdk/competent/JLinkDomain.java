package jlink.restful.java.sdk.competent;

/**
 * RESTFul API RequestInterface Enum
 */
public enum JLinkDomain {
    //Open API Request DomainName
    OPENAPI_DOMAIN("https://api.jftechws.com/gwp"),
    //userToken and deviceToken Request DomainName
    TKS_DOMAIN("https://api.jftechws.com/tks"),
    AMS_DOMAIN("https://api.jftechws.com/ams"),
    RS_DOMAIN("https://api.jftechws.com/ams/login/va1");


    private String requestDomain;

    public String get() {
        return requestDomain;
    }

    public void set(String requestDomain) {
        this.requestDomain = requestDomain;
    }


    JLinkDomain(String requestDomain) {
        this.requestDomain = requestDomain;
    }
}
