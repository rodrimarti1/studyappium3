package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ordinance {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("officiator")
    @Expose
    private String officiator;
    @SerializedName("temple")
    @Expose
    private String temple;
    @SerializedName("type")
    @Expose
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOfficiator() {
        return officiator;
    }

    public void setOfficiator(String officiator) {
        this.officiator = officiator;
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
