package LDSToolsAppium.API.Households;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {
    @SerializedName("e164")
    @Expose
    private String e164;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("supports")
    @Expose
    private List<String> supports;
    @SerializedName("number")
    @Expose
    private String number;

    public String getE164() {
        return e164;
    }

    public void setE164(String e164) {
        this.e164 = e164;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSupports() {
        return supports;
    }

    public void setSupports(List<String> supports) {
        this.supports = supports;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
