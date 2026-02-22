package model;

import java.math.BigDecimal;

public class House extends Financing {
    private Double landArea;
    private Double builtArea;

    public House() {
        super();
    }

    public House(BigDecimal propertyValue, int financingTerm, BigDecimal annualInterestRate, Double landArea, Double builtArea) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.landArea = landArea;
        this.builtArea = builtArea;
    }

    public Double getLandArea() {
        return landArea;
    }

    public Double getBuiltArea() {
        return builtArea;
    }

    // Houses receive a fixed increase of 80.00 in the financing calculation.
    // The interest rate must not be less than the fixed increase.
    // If it is, the interest rate should increase to the same value as the fixed increase.
    @Override
    protected BigDecimal calculateMonthlyPaymentRaw() {
        int financingTermInMonths = this.financingTerm * 12;

        BigDecimal monthlyPaymentWithoutInterest = this.propertyValue.divide(BigDecimal.valueOf(financingTermInMonths), Financing.CONTEXT);

        BigDecimal interestValue = super.calculateMonthlyPaymentRaw().subtract(monthlyPaymentWithoutInterest, Financing.CONTEXT);

        BigDecimal increaseValue = new BigDecimal("80.00");

        interestValue = interestValue.max(increaseValue);

        return monthlyPaymentWithoutInterest.add(interestValue, Financing.CONTEXT).add(increaseValue, Financing.CONTEXT);
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
