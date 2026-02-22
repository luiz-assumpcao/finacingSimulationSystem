package model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Financing {
    protected BigDecimal propertyValue;
    protected int financingTerm;
    protected BigDecimal annualInterestRate;

    protected static final MathContext CONTEXT = new MathContext(20, RoundingMode.HALF_UP);

    public Financing() {
    }

    public Financing(BigDecimal propertyValue, int financingTerm, BigDecimal annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getPropertyValue() {
        return propertyValue;
    }

    public int getFinancingTerm() {
        return financingTerm;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    protected BigDecimal calculateMonthlyPaymentRaw() {
        BigDecimal annualRateFraction = this.annualInterestRate.divide(BigDecimal.valueOf(100), CONTEXT);

        if (annualRateFraction.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Interest rate must be greater than zero.");
        }

        double monthlyRateDouble = Math.pow(annualRateFraction.add(BigDecimal.ONE).doubleValue(), 1.00 / 12.00) - 1;
        BigDecimal monthlyRate = BigDecimal.valueOf(monthlyRateDouble);

        int financingTermInMonths = this.financingTerm * 12;

        BigDecimal factor = monthlyRate.add(BigDecimal.ONE, CONTEXT).pow(financingTermInMonths, CONTEXT);

        BigDecimal numerator = this.propertyValue.multiply(monthlyRate, CONTEXT).multiply(factor, CONTEXT);
        BigDecimal denominator = factor.subtract(BigDecimal.ONE, CONTEXT);

        return numerator.divide(denominator, CONTEXT);
    }

    public BigDecimal calculateMonthlyPayment() {
        return this.calculateMonthlyPaymentRaw().setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotalPayment() {
        int months = this.financingTerm * 12;
        return this.calculateMonthlyPayment().multiply(BigDecimal.valueOf(months));
    }

    @Override
    public String toString() {
        NumberFormat usCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder string = new StringBuilder();

        string.append("Property Value: ").append(String.format("%s", usCurrencyFormatter.format(this.propertyValue))).append("\n");
        string.append("Financing Value: ").append(String.format("%s", usCurrencyFormatter.format(this.calculateTotalPayment()))).append("\n");
        string.append("Monthly Payment: ").append(String.format("%s", usCurrencyFormatter.format(this.calculateMonthlyPayment()))).append("\n");
        string.append("Financing Term: ").append(String.format("%d years.", this.financingTerm)).append("\n");
        string.append("Interest Rate: ").append(String.format("%.2f%% p.a.", this.annualInterestRate));
        return string.toString();
    }
}
