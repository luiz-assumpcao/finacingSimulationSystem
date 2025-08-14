package model;

public class Apartment extends Financing{
    public Apartment() {
        super();
    }

    public Apartment(Double propertyValue, Integer financingTerm, Double annualInterestRate) {
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public Double calculateMonthlyPayment() {
        double monthlyInterestRate = (this.annualInterestRate / 100) / 12.00;
        double financingTermInMonths = this.financingTerm * 12.00;
        return (this.propertyValue * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, financingTermInMonths)) /
                (Math.pow(1 + monthlyInterestRate, financingTermInMonths) - 1);
    }
}
