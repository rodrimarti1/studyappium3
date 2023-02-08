package LDSToolsAppium.API.Expenses;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiFinanceMethod {

    private List<LDSToolsAppium.API.Expenses.Expense> expenses = null;
    private String month;
    private Boolean removed;
    private Integer unitNumber;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<LDSToolsAppium.API.Expenses.Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<LDSToolsAppium.API.Expenses.Expense> expenses) {
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
