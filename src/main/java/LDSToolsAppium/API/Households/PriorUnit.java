package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PriorUnit {
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("unitType")
    @Expose
    private String unitType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("parentUnit")
    @Expose
    private String parentUnit;
    @SerializedName("childUnits")
    @Expose
    private List<String> childUnits;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(String parentUnit) {
        this.parentUnit = parentUnit;
    }

    public List<String> getChildUnits() {
        return childUnits;
    }

    public void setChildUnits(List<String> childUnits) {
        this.childUnits = childUnits;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

}
