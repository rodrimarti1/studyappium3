package LDSToolsAppium.API.Expenses;

import java.util.LinkedHashMap;
import java.util.Map;

public class Phone__2 {

    private String number;
    private String type;
    private String privacy;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
