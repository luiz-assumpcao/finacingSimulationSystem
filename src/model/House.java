package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    @Override
    public BigDecimal calculateMonthlyPayment() {
        BigDecimal annualRateFraction = this.annualInterestRate.divide(BigDecimal.valueOf(100), Financing.CONTEXT);

        if (annualRateFraction.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Interest rate must be greater than zero.");
        }

        BigDecimal increaseValue = new BigDecimal("80.00");

        double monthlyRateDouble = Math.pow(annualRateFraction.add(BigDecimal.ONE).doubleValue(), 1.00 / 12.00) - 1;
        BigDecimal monthlyRate = BigDecimal.valueOf(monthlyRateDouble);

        int financingTermInMonths = this.financingTerm * 12;

        BigDecimal monthlyPaymentWithoutInterest = this.propertyValue.divide(BigDecimal.valueOf(financingTermInMonths), Financing.CONTEXT);

        BigDecimal factor = monthlyRate.add(BigDecimal.ONE, Financing.CONTEXT).pow(financingTermInMonths, Financing.CONTEXT);

        BigDecimal numerator = this.propertyValue.multiply(monthlyRate, Financing.CONTEXT).multiply(factor, Financing.CONTEXT);
        BigDecimal denominator = factor.subtract(BigDecimal.ONE, Financing.CONTEXT);

        BigDecimal monthlyPaymentWithInterest = numerator.divide(denominator, Financing.CONTEXT);

        BigDecimal interestValue = monthlyPaymentWithInterest.subtract(monthlyPaymentWithoutInterest, Financing.CONTEXT);

        if (interestValue.compareTo(increaseValue) < 0) {
            interestValue = increaseValue;
        }

        BigDecimal monthlyPayment = monthlyPaymentWithoutInterest.add(interestValue, Financing.CONTEXT).add(increaseValue, Financing.CONTEXT);

        return monthlyPayment.setScale(2, RoundingMode.HALF_UP);
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
