package model;

public class Financing {
    private Double propertyValue;
    private Integer financingTerm;
    private Double annualInterestRate;

    public Financing() {
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Integer getFinancingTerm() {
        return financingTerm;
    }

    public void setFinancingTerm(Integer financingTerm) {
        this.financingTerm = financingTerm;
    }

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Financing(Double propertyValue, Integer financingTerm, Double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    public Double calculateMonthlyPayment() {
        return (this.propertyValue / (this.financingTerm * 12)) * (1 + (this.annualInterestRate / 12));
    }

    public Double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingTerm * 12;
    }
}
