package model;

public class Land extends Financing{
    private String zoneType;

    public Land() {
        super();
    }

    public Land(Double propertyValue, Integer financingTerm, Double annualInterestRate, String zoneType) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.zoneType = zoneType;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    @Override
    public Double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() + ((2.00 / 100.00) * super.calculateMonthlyPayment());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" | Land: ").append("\n");
        string.append(super.toString()).append("\n");
        string.append("Zone Type: ").append(String.format("%s.", this.zoneType)).append("\n");
        return string.toString();
    }
}
