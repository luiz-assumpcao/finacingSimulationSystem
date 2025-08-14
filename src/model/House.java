package model;

public class House extends Financing{
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

    @Override
    public Double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() + 80.00;
    }
}
