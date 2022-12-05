package LDSToolsAppium.API.LifeResources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifeResource {

    private Integer unitNumber;
    private List<Resource> resources = null;
    private List<Tag> tags = null;
    private List<String> permissions = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}