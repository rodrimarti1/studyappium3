package LDSToolsAppium.API.LifeResources;

import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    private Integer lat;
    private Integer _long;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLong() {
        return _long;
    }

    public void setLong(Integer _long) {
        this._long = _long;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}