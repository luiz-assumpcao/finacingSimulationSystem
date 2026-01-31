package main;

import model.Financing;
import utility.UserInterface;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        List<Financing> financings = new ArrayList<>();

        boolean exit = false;

        userInterface.displayListingPreferenceMenu();
        boolean userPreference = userInterface.getUserListingPreference();

        while (!exit) {
            userInterface.displayOptionsMenu();
            int userOption = userInterface.getUserFinancingOption();
            userInterface.printGreenLine();

            Financing financing = null;
            if (userOption == 0) {
                exit = true;
                continue;
            } else if (userOption == 1) {
                financing = userInterface.createHouseFinancing();
                System.out.println(financing);
            } else if (userOption == 2) {
                financing = userInterface.createApartmentFinancing();
                System.out.println(financing);
            } else if (userOption == 3) {
                financing = userInterface.createLandApartment();
                System.out.println(financing);
            }

            if (userPreference) {
                financings.add(financing);
            }
        }

        if (userPreference) {
            userInterface.printBlueText("| Your Financings |", true);
            userInterface.printGreenLine();
            for (Financing financing : financings) {
                System.out.println(financing);
            }
        }

    }
}
