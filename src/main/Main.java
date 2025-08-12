package main;

import model.Financing;
import utility.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        double propertyValue = userInterface.getPropertyValue();
        int financingTerm = userInterface.getFinancingTerm();
        double annualInterestRate = userInterface.getAnnualInterestRate();

        Financing financing = new Financing(propertyValue, financingTerm, annualInterestRate);

    }
}
