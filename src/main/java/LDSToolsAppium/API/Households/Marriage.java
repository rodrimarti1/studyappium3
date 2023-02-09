package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marriage {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("sealingDate")
    @Expose
    private String sealingDate;
    @SerializedName("spouse")
    @Expose
    private Spouse spouse;
    @SerializedName("temple")
    @Expose
    private String temple;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSealingDate() {
        return sealingDate;
    }

    public void setSealingDate(String sealingDate) {
        this.sealingDate = sealingDate;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

}
