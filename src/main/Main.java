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

        userInterface.displayOptionsMenu();
        int userOption = userInterface.getUserFinancingOption();

        double propertyValue = userInterface.getPropertyValue();
        int financingTerm = userInterface.getFinancingTerm();
        double annualInterestRate = userInterface.getAnnualInterestRate();
        String zoneType = userInterface.getZoneType();

        financingsList.add(new Land(propertyValue, financingTerm, annualInterestRate, zoneType));

        for (Financing financing : financingsList) {
            System.out.println(financing);
        }


    }
}
