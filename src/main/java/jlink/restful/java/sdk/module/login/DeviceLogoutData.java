package jlink.restful.java.sdk.module.login;

import com.google.gson.annotations.SerializedName;

public class DeviceLogoutData {
    @SerializedName("Name")
    private String name = "Logout";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
