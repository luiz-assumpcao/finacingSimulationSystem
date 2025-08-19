package utility;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    private void printError(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    public Double getPropertyValue() {
        double propertyValue;
        do {
            System.out.print("Enter the property value: ");
            propertyValue = Double.parseDouble(scanner.nextLine());
            if (propertyValue < 0.00) {
                printError("The value can't be negative! Try again.");
            } else if (propertyValue < 30000.00) {
                printError("The value can't be too low! Try again.");
            } else if (propertyValue > 60000000.00) {
                printError("The value can't be too high! Try again.");
            }
        } while (propertyValue < 30000.00 || propertyValue > 60000000.00);
        return propertyValue;
    }

    public Integer getFinancingTerm() {
        int financingTerm;
        do {
            System.out.print("Enter the financing term: ");
            financingTerm = Integer.parseInt(scanner.nextLine());
            if (financingTerm < 0) {
                printError("The value can't be negative! Try again.");
            } else if (financingTerm < 5) {
                printError("The value can't be too low! Try again.");
            } else if (financingTerm > 50) {
                printError("The value can't be too high! Try again.");
            }
        } while (financingTerm < 5 || financingTerm > 50);
        return financingTerm;
    }

    public Double getAnnualInterestRate() {
        double annualInterestRate;
        do {
            System.out.print("Enter the annual interest rate (%): ");
            annualInterestRate = Double.parseDouble(scanner.nextLine());
            if (annualInterestRate < 0.00) {
                printError("The value can't be negative! Try again.");
            }
            if (annualInterestRate > 100.00) {
                printError("The value can't be too high! Try again.");
            }
        } while (annualInterestRate < 0.00 || annualInterestRate > 100.00);
        return annualInterestRate;
    }

    public Double getLandArea() {
        double landArea;
        do {
            System.out.print("Enter the land area (m²): ");
            landArea = Double.parseDouble(scanner.nextLine());
            if (landArea < 0.00) {
                printError("The value can't be negative! Try again.");
            } else if (landArea < 50.00) {
                printError("The value can't be too low! Try again.");
            } else if (landArea > 10000.00) {
                printError("The value can't be too high! Try again.");
            }

        } while (landArea < 50.00 || landArea > 10000.00);
        return landArea;
    }

    public Double getBuiltArea(double landArea) {
        double builtArea;
        do {
            System.out.print("Enter the built area (m²): ");
            builtArea = Double.parseDouble(scanner.nextLine());
            if (builtArea < 0.00) {
                printError("The value can't be negative! Try again.");
            } else if (builtArea < 30.00) {
                printError("The value can't be too low! Try again.");
            } else if (!Validation.isBuiltAreaValid(landArea, builtArea)) {
                printError("The value can't be greater than the land area! Try again.");
            }

        } while (builtArea < 30.00 || !Validation.isBuiltAreaValid(landArea, builtArea));
        return builtArea;
    }

    public Integer getParkingSpaces() {
        int parkingSpaces;
        do {
            System.out.print("Enter the number of parking spaces: ");
            parkingSpaces = Integer.parseInt(scanner.nextLine());
            if (parkingSpaces < 0) {
                printError("The value can't be negative! Try again.");
            } else if (parkingSpaces > 10) {
                printError("The value can't be too high! Try again.");
            }
        } while (parkingSpaces < 0 || parkingSpaces > 10);
        return parkingSpaces;
    }

    public Integer getFloorLevel() {
        int floorLevel;
        do {
            System.out.print("Enter the the floor level: ");
            floorLevel = Integer.parseInt(scanner.nextLine());
            if (floorLevel < 0) {
                printError("The value can't be negative! Try again.");
            } else if (floorLevel > 163) {
                printError("The value can't be too high! Try again.");
            }
        } while (floorLevel < 0 || floorLevel > 163);
        return floorLevel;
    }

    public String getZoneType() {
        String zoneType;
        do {
            System.out.print("Enter the the zone type: ");
            zoneType = scanner.nextLine().strip();
            if (zoneType.isEmpty()) {
                printError("The value can't be empty! Try again.");
            }
        } while (zoneType.isEmpty());
        return zoneType;
    }


}
