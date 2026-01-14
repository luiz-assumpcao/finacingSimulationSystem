package model;

import utility.IncreaseGreaterThanInterestException;

public class House extends Financing {
    private Double landArea;
    private Double builtArea;

    public House() {
        super();
    }

    public House(Double propertyValue, Integer financingTerm, Double annualInterestRate, Double landArea, Double builtArea) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.landArea = landArea;
        this.builtArea = builtArea;
    }

    public Double getLandArea() {
        return landArea;
    }

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    public Double getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(Double builtArea) {
        this.builtArea = builtArea;
    }

    public void isIncreaseGreaterThanInterest(double valueOfTheIncrease, double interestValue) throws IncreaseGreaterThanInterestException {
        if (valueOfTheIncrease > interestValue) {
            throw new IncreaseGreaterThanInterestException("The value of the increase is greater than the interest");
        }
    }

    @Override
    public Double calculateMonthlyPayment() {
        double monthlyInterestRate = (this.annualInterestRate / 100) / 12;
        double financingTermInMonths = this.financingTerm * 12.00;

        double interestValue = (this.propertyValue / financingTermInMonths) * (1 + (monthlyInterestRate)) - (this.propertyValue / financingTermInMonths);
        double valueOfTheIncrease = 80;

        try {
            isIncreaseGreaterThanInterest(valueOfTheIncrease, interestValue);
        } catch (IncreaseGreaterThanInterestException e) {
            interestValue = valueOfTheIncrease;
        }

        return (this.propertyValue / financingTermInMonths) * (1 + (monthlyInterestRate)) + valueOfTheIncrease;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("| House |").append("\n");
        string.append(super.toString()).append("\n");
        string.append("Land Area: ").append(String.format("%.2f m²", this.landArea)).append("\n");
        string.append("Built Area: ").append(String.format("%.2f m²", this.builtArea)).append("\n");
        return string.toString();
    }
}
