package LDSToolsAppium.API.QuarterlyReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuarterlyReport {

    private Integer unitNumber;
    private Integer year;
    private Integer quarter;
    private String version;
    private String submitDate;
    private List<Section> sections = null;
    private List<Convert> converts = null;
    private Boolean editable;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Convert> getConverts() {
        return converts;
    }

    public void setConverts(List<Convert> converts) {
        this.converts = converts;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}