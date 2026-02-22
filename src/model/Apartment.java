package model;

import java.math.BigDecimal;

public class Apartment extends Financing {
    private int parkingSpaces;
    private int floorLevel;

    public Apartment() {
        super();
    }

    public Apartment(BigDecimal propertyValue, int financingTerm, BigDecimal annualInterestRate, int parkingSpaces, int floorLevel) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.parkingSpaces = parkingSpaces;
        this.floorLevel = floorLevel;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    // Apartments receive a 4% discount on the financing calculation.
    @Override
    protected BigDecimal calculateMonthlyPaymentRaw() {
        BigDecimal base = super.calculateMonthlyPaymentRaw();
        BigDecimal discount = base.multiply(new BigDecimal("0.04"), Financing.CONTEXT);
        return base.subtract(discount, Financing.CONTEXT);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("| Apartment |").append("\n");
        string.append(super.toString()).append("\n");
        string.append("Parking Spaces: ").append(String.format("%d ", this.parkingSpaces)).append("\n");
        string.append("Floor Level: ").append(String.format("%d ", this.floorLevel));
        return string.toString();
    }
}
