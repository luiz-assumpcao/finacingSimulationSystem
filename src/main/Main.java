package main;

import model.Apartment;
import model.Financing;
import model.House;
import model.Land;
import utility.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        List<Financing> financingsList = new ArrayList<>();

        double propertyValue = userInterface.getPropertyValue();
        int financingTerm = userInterface.getFinancingTerm();
        double annualInterestRate = userInterface.getAnnualInterestRate();

        financingsList.add(new House(propertyValue, financingTerm, annualInterestRate, 300.00, 200.00));
        financingsList.add(new House(720000.00, 30, 7.8,400.00,270.00));
        financingsList.add(new Apartment(500000.00, 10, 10.00, 1, 5));
        financingsList.add(new Apartment(720000.00, 30, 7.8, 2, 11));
        financingsList.add(new Land(500000.00, 10, 10.0, "Residential"));

        for (Financing financing : financingsList) {
            System.out.println(financing.calculateMonthlyPayment());
        }

    }
}
