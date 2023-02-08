package LDSToolsAppium.API.Expenses;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Expense {

    private Integer id;
    private String type;
    private Integer unitNumber;
    private Integer accountId;
    private String status;
    private Boolean advancement;
    private Payee payee;
    private String purpose;
    private List<Charge> charges;
    private Integer paymentMethodId;
    private Boolean expenseDistribution;
    private String referenceNumber;
    private String submittedDate;
    private String approvedRejectedDate;
    private SubmittedBy submittedBy;
    private ApprovedRejectedBy approvedRejectedBy;
    private String reasonForRejection;
    private List<Receipt> receipts;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAdvancement() {
        return advancement;
    }

    public void setAdvancement(Boolean advancement) {
        this.advancement = advancement;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Boolean getExpenseDistribution() {
        return expenseDistribution;
    }

    public void setExpenseDistribution(Boolean expenseDistribution) {
        this.expenseDistribution = expenseDistribution;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getApprovedRejectedDate() {
        return approvedRejectedDate;
    }

    public void setApprovedRejectedDate(String approvedRejectedDate) {
        this.approvedRejectedDate = approvedRejectedDate;
    }

    public SubmittedBy getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(SubmittedBy submittedBy) {
        this.submittedBy = submittedBy;
    }

    public ApprovedRejectedBy getApprovedRejectedBy() {
        return approvedRejectedBy;
    }

    public void setApprovedRejectedBy(ApprovedRejectedBy approvedRejectedBy) {
        this.approvedRejectedBy = approvedRejectedBy;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
