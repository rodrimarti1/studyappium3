package LDSToolsAppium.API.Households;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiHousehold {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("members")
    @Expose
    private List<Member> members;
    @SerializedName("privacy")
    @Expose
    private Privacy__1 privacy;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("sortName")
    @Expose
    private String sortName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

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

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Privacy__1 getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy__1 privacy) {
        this.privacy = privacy;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
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

}


