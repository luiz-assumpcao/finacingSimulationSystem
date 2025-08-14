package model;

public class House extends Financing{
    public House() {
        super();
    }

    public House(Double propertyValue, Integer financingTerm, Double annualInterestRate) {
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public Double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() + 80.00;
    }
}
