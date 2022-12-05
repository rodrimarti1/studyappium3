package LDSToolsAppium.API.LifeResources;

import java.util.HashMap;
import java.util.Map;

public class Contact {

    private String displayName;
    private String position;
    private String phone;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}