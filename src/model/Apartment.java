package model;

public class Apartment extends Financing{
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

    @Override
    public Double calculateMonthlyPayment() {
        double monthlyInterestRate = (this.annualInterestRate / 100) / 12.00;
        double financingTermInMonths = this.financingTerm * 12.00;
        return (this.propertyValue * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, financingTermInMonths)) /
                (Math.pow(1 + monthlyInterestRate, financingTermInMonths) - 1);
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
