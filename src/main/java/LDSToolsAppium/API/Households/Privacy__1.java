package LDSToolsAppium.API.Households;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Privacy__1 {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
