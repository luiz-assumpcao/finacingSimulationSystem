package model;

public class Apartment extends Financing {
    private Integer parkingSpaces;
    private Integer floorLevel;

    public Apartment() {
        super();
    }

    public Apartment(Double propertyValue, Integer financingTerm, Double annualInterestRate, Integer parkingSpaces, Integer floorLevel) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.parkingSpaces = parkingSpaces;
        this.floorLevel = floorLevel;
    }

    public Integer getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(Integer parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public Integer getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(Integer floorLevel) {
        this.floorLevel = floorLevel;
    }

    // Apartments receive a 4% discount on the financing calculation.
    @Override
    public Double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() - ((4.00 / 100.00) * super.calculateMonthlyPayment());
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
