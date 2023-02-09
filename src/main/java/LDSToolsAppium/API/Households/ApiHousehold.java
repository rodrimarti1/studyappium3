package LDSToolsAppium.API.Households;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiHousehold {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("privacy")
    @Expose
    private Privacy_ privacy;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("verified")
    @Expose
    private Boolean verified;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Privacy_ getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy_ privacy) {
        this.privacy = privacy;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

}


