package LDSToolsAppium.API.QuarterlyReport;

import java.util.HashMap;
import java.util.Map;

public class Convert {

    private String uuid;
    private String displayName;
    private String birthDate;
    private Boolean attendedSacramentMeeting;
    private String priesthood;
    private String sex;
    private Boolean hadCalling;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Boolean getAttendedSacramentMeeting() {
        return attendedSacramentMeeting;
    }

    public void setAttendedSacramentMeeting(Boolean attendedSacramentMeeting) {
        this.attendedSacramentMeeting = attendedSacramentMeeting;
    }

    public String getPriesthood() {
        return priesthood;
    }

    public void setPriesthood(String priesthood) {
        this.priesthood = priesthood;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getHadCalling() {
        return hadCalling;
    }

    public void setHadCalling(Boolean hadCalling) {
        this.hadCalling = hadCalling;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}