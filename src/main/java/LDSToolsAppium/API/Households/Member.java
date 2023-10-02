package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Member {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("individualId")
    @Expose
    private Integer individualId;
    @SerializedName("householdUuid")
    @Expose
    private String householdUuid;
    @SerializedName("head")
    @Expose
    private Boolean head;
    @SerializedName("member")
    @Expose
    private Boolean member;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("preferredName")
    @Expose
    private String preferredName;
    @SerializedName("officialName")
    @Expose
    private String officialName;
    @SerializedName("maidenName")
    @Expose
    private String maidenName;
    @SerializedName("givenName")
    @Expose
    private String givenName;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("phones")
    @Expose
    private List<Phone> phones;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("emails")
    @Expose
    private List<Email> emails;
    @SerializedName("positions")
    @Expose
    private List<Position> positions;
    @SerializedName("classes")
    @Expose
    private List<String> classes;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("mrn")
    @Expose
    private String mrn;
    @SerializedName("priesthood")
    @Expose
    private String priesthood;
    @SerializedName("ageGroup")
    @Expose
    private String ageGroup;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("birthPlace")
    @Expose
    private String birthPlace;
    @SerializedName("birthCountry")
    @Expose
    private String birthCountry;
    @SerializedName("templeRecommendStatus")
    @Expose
    private String templeRecommendStatus;
    @SerializedName("templeRecommendExpiration")
    @Expose
    private String templeRecommendExpiration;
    @SerializedName("templeRecommendType")
    @Expose
    private String templeRecommendType;
    @SerializedName("missionCountry")
    @Expose
    private String missionCountry;
    @SerializedName("missionLanguage")
    @Expose
    private String missionLanguage;
    @SerializedName("bic")
    @Expose
    private Boolean bic;
    @SerializedName("ordinances")
    @Expose
    private List<Ordinance> ordinances;
    @SerializedName("patriarchalBlessing")
    @Expose
    private Boolean patriarchalBlessing;
    @SerializedName("marriage")
    @Expose
    private Marriage marriage;
    @SerializedName("father")
    @Expose
    private Father father;
    @SerializedName("mother")
    @Expose
    private Mother mother;
    @SerializedName("priorUnit")
    @Expose
    private PriorUnit priorUnit;
    @SerializedName("priorUnitMoveOutDate")
    @Expose
    private String priorUnitMoveOutDate;
    @SerializedName("unitMoveInDate")
    @Expose
    private String unitMoveInDate;
    @SerializedName("outOfUnit")
    @Expose
    private Boolean outOfUnit;
    @SerializedName("cameFromAddressUnknown")
    @Expose
    private Boolean cameFromAddressUnknown;
    @SerializedName("privacy")
    @Expose
    private Privacy privacy;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions;
    @SerializedName("sortName")
    @Expose
    private String sortName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Integer individualId) {
        this.individualId = individualId;
    }

    public String getHouseholdUuid() {
        return householdUuid;
    }

    public void setHouseholdUuid(String householdUuid) {
        this.householdUuid = householdUuid;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getPriesthood() {
        return priesthood;
    }

    public void setPriesthood(String priesthood) {
        this.priesthood = priesthood;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getTempleRecommendStatus() {
        return templeRecommendStatus;
    }

    public void setTempleRecommendStatus(String templeRecommendStatus) {
        this.templeRecommendStatus = templeRecommendStatus;
    }

    public String getTempleRecommendExpiration() {
        return templeRecommendExpiration;
    }

    public void setTempleRecommendExpiration(String templeRecommendExpiration) {
        this.templeRecommendExpiration = templeRecommendExpiration;
    }

    public String getTempleRecommendType() {
        return templeRecommendType;
    }

    public void setTempleRecommendType(String templeRecommendType) {
        this.templeRecommendType = templeRecommendType;
    }

    public String getMissionCountry() {
        return missionCountry;
    }

    public void setMissionCountry(String missionCountry) {
        this.missionCountry = missionCountry;
    }

    public String getMissionLanguage() {
        return missionLanguage;
    }

    public void setMissionLanguage(String missionLanguage) {
        this.missionLanguage = missionLanguage;
    }

    public Boolean getBic() {
        return bic;
    }

    public void setBic(Boolean bic) {
        this.bic = bic;
    }

    public List<Ordinance> getOrdinances() {
        return ordinances;
    }

    public void setOrdinances(List<Ordinance> ordinances) {
        this.ordinances = ordinances;
    }

    public Boolean getPatriarchalBlessing() {
        return patriarchalBlessing;
    }

    public void setPatriarchalBlessing(Boolean patriarchalBlessing) {
        this.patriarchalBlessing = patriarchalBlessing;
    }

    public Marriage getMarriage() {
        return marriage;
    }

    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public PriorUnit getPriorUnit() {
        return priorUnit;
    }

    public void setPriorUnit(PriorUnit priorUnit) {
        this.priorUnit = priorUnit;
    }

    public String getPriorUnitMoveOutDate() {
        return priorUnitMoveOutDate;
    }

    public void setPriorUnitMoveOutDate(String priorUnitMoveOutDate) {
        this.priorUnitMoveOutDate = priorUnitMoveOutDate;
    }

    public String getUnitMoveInDate() {
        return unitMoveInDate;
    }

    public void setUnitMoveInDate(String unitMoveInDate) {
        this.unitMoveInDate = unitMoveInDate;
    }

    public Boolean getOutOfUnit() {
        return outOfUnit;
    }

    public void setOutOfUnit(Boolean outOfUnit) {
        this.outOfUnit = outOfUnit;
    }

    public Boolean getCameFromAddressUnknown() {
        return cameFromAddressUnknown;
    }

    public void setCameFromAddressUnknown(Boolean cameFromAddressUnknown) {
        this.cameFromAddressUnknown = cameFromAddressUnknown;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }


}
