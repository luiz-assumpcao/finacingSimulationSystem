package model;

import java.math.BigDecimal;

public class Land extends Financing{
    private String zoneType;

    public Land() {
        super();
    }

    public Land(BigDecimal propertyValue, Integer financingTerm, BigDecimal annualInterestRate, String zoneType) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.zoneType = zoneType;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    // Lands receive a 2% increase on the financing calculation.
    @Override
    protected BigDecimal calculateMonthlyPaymentRaw() {
        BigDecimal base = super.calculateMonthlyPaymentRaw();
        BigDecimal increase = base.multiply(new BigDecimal("0.02"), Financing.CONTEXT);
        return base.add(increase, Financing.CONTEXT);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("| Land |").append("\n");
        string.append(super.toString()).append("\n");
        string.append("Zone Type: ").append(String.format("%s.", this.zoneType));
        return string.toString();
    }
}
