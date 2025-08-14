package model;

public abstract class Financing {
    protected Double propertyValue;
    protected Integer financingTerm;
    protected Double annualInterestRate;

    public Financing() {
    }

    public Financing(Double propertyValue, Integer financingTerm, Double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
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

    public Double calculateMonthlyPayment() {
        double monthlyInterestRate = (this.annualInterestRate / 100) / 12;
        double financingTermInMonths = this.financingTerm * 12.00;
        return (this.propertyValue / financingTermInMonths) * (1 + (monthlyInterestRate));
    }

    public Double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingTerm * 12;
    }
}
