package LDSToolsAppium.API.Expenses;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Example {

    private Integer unitNumber;
    private String month;
    private Boolean removed;
    private List<Expense> expenses;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
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

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
