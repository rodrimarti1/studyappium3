package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ordinance {


    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("temple")
    @Expose
    private String temple;
    @SerializedName("officiator")
    @Expose
    private String officiator;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

    public String getOfficiator() {
        return officiator;
    }

    public void setOfficiator(String officiator) {
        this.officiator = officiator;
    }

}
