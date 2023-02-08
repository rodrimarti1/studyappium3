package LDSToolsAppium.API.Expenses;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Payee {

    private Integer id;
    private String referenceId;
    private String memberUuid;
    private String memberMrn;
    private Integer unitNumber;
    private String name;
    private List<Integer> paymentMethodIds;
    private Address address;
    private List<Phone> phones;
    private List<Email> emails;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getMemberMrn() {
        return memberMrn;
    }

    public void setMemberMrn(String memberMrn) {
        this.memberMrn = memberMrn;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPaymentMethodIds() {
        return paymentMethodIds;
    }

    public void setPaymentMethodIds(List<Integer> paymentMethodIds) {
        this.paymentMethodIds = paymentMethodIds;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
