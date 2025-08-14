package model;

public class Land extends Financing{
    public Land() {
        super();
    }

    public Land(Double propertyValue, Integer financingTerm, Double annualInterestRate) {
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public Double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() + ((2.00 / 100.00) * super.calculateMonthlyPayment());
    }
}
