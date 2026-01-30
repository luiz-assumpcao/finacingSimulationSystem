package main;

import model.Apartment;
import model.Financing;
import model.House;
import model.Land;
import utility.UserInterface;


public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        boolean exit = false;

        userInterface.displayListingPreferenceMenu();
        boolean userPreference = userInterface.getUserListingPreference();
        
        while (!exit) {
            userInterface.displayOptionsMenu();
            int userOption = userInterface.getUserFinancingOption();

            userInterface.printGreenLine();
            if (userOption == 0) {
                exit = true;
                continue;
            } else if (userOption == 1) {
                Financing house = userInterface.createHouseFinancing();
                System.out.println(house);
            } else if (userOption == 2) {
                Financing apartment = userInterface.createApartmentFinancing();
                System.out.println(apartment);
            } else if (userOption == 3) {
                Financing land = userInterface.createLandApartment();
                System.out.println(land);
            }

        }

    }
}
