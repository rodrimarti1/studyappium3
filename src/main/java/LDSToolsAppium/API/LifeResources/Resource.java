package LDSToolsAppium.API.LifeResources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resource {

    private String uuid;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String address;
    private Coordinates coordinates;
    private String url;
    private Contact contact;
    private String notes;
    private Boolean limitedVisibility;
    private Boolean churchResource;
    private List<String> tags = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getLimitedVisibility() {
        return limitedVisibility;
    }

    public void setLimitedVisibility(Boolean limitedVisibility) {
        this.limitedVisibility = limitedVisibility;
    }

    public Boolean getChurchResource() {
        return churchResource;
    }

    public void setChurchResource(Boolean churchResource) {
        this.churchResource = churchResource;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}