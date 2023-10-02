package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {


    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("unitName")
    @Expose
    private String unitName;
    @SerializedName("activeDate")
    @Expose
    private String activeDate;
    @SerializedName("setApart")
    @Expose
    private Boolean setApart;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public Boolean getSetApart() {
        return setApart;
    }

    public void setSetApart(Boolean setApart) {
        this.setApart = setApart;
    }

}
