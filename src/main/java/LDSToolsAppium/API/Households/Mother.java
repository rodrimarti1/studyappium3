package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mother {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
