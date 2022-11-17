package LDSToolsAppium.API;

public class ApiFinanceDetail {
    String purpose;
    int id;
    String submittedDate;
    String approveRejectedDate;
    int receiptCount;
    int accountId;
    int paymentMethodId;
    String payeeId;
    String status;
    String type;

//    public ApiFinanceDetail(String purpose, int id, String submittedDate, String approveRejectedDate, int receiptCount, int accountId, int paymentMethodId, String payeeId, String status, String type) {
//        this.purpose = purpose;
//        this.id = id;
//        this.submittedDate = submittedDate;
//        this.approveRejectedDate = approveRejectedDate;
//        this.receiptCount = receiptCount;
//        this.accountId = accountId;
//        this.paymentMethodId = paymentMethodId;
//        this.payeeId = payeeId;
//        this.status = status;
//        this.type = type;
//    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getApproveRejectedDate() {
        return approveRejectedDate;
    }

    public void setApproveRejectedDate(String approveRejectedDate) {
        this.approveRejectedDate = approveRejectedDate;
    }

    public int getReceiptCount() {
        return receiptCount;
    }

    public void setReceiptCount(int receiptCount) {
        this.receiptCount = receiptCount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
