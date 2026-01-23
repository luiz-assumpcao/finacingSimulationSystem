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

    public void isIncreaseGreaterThanInterest(double increaseValue, double interestValue) throws IncreaseGreaterThanInterestException {
        if (increaseValue > interestValue) {
            throw new IncreaseGreaterThanInterestException("The value of the increase is greater than the interest");
        }
    }

    // Houses receive a fixed increase of 80.00 in the financing calculation.
    // The interest rate must not be less than the fixed increase.
    @Override
    public Double calculateMonthlyPayment() {
        double monthlyInterestRate = (this.annualInterestRate / 100) / 12.00;
        double financingTermInMonths = this.financingTerm * 12.00;
        double monthlyPaymentWithoutInterest = this.propertyValue / financingTermInMonths;

        double interestValue = (this.propertyValue * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, financingTermInMonths)) /
                (Math.pow(1 + monthlyInterestRate, financingTermInMonths) - 1) - monthlyPaymentWithoutInterest;

        double increaseValue = 80;

        try {
            isIncreaseGreaterThanInterest(increaseValue, interestValue);
        } catch (IncreaseGreaterThanInterestException e) {
            interestValue = increaseValue;
        }

        return  monthlyPaymentWithoutInterest + interestValue + increaseValue;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("| House |").append("\n");
        string.append(super.toString()).append("\n");
        string.append("Land Area: ").append(String.format("%.2f m²", this.landArea)).append("\n");
        string.append("Built Area: ").append(String.format("%.2f m²", this.builtArea));
        return string.toString();
    }
}
