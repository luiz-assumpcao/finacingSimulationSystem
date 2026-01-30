package utility;

import model.Apartment;
import model.House;
import model.Land;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public void printError(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    public void printGreenLine() {
        System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
    }

    public void printBlueText(String text) {
        printBlueText(text, false);
    }

    public void printBlueText(String text, boolean breakLine) {
        if (breakLine) {
            System.out.println("\u001B[36m" + text + "\u001B[0m");
        } else {
            System.out.print("\u001B[36m" + text + "\u001B[0m");
        }
    }

    public Double getPropertyValue() {
        while (true) {
            try {
                printBlueText("Enter the property value: ");
                double propertyValue = Double.parseDouble(scanner.nextLine());
                if (propertyValue < 0.00) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (propertyValue < 30000.00) {
                    printError("The value can't be too low! Try again.");
                    continue;
                } else if (propertyValue > 60000000.00) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return propertyValue;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Integer getFinancingTerm() {
        while (true) {
            try {
                printBlueText("Enter the financing term: ");
                int financingTerm = Integer.parseInt(scanner.nextLine());
                if (financingTerm < 0) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (financingTerm < 5) {
                    printError("The value can't be too low! Try again.");
                    continue;
                } else if (financingTerm > 50) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return financingTerm;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Double getAnnualInterestRate() {
        while (true) {
            try {
                printBlueText("Enter the annual interest rate (%): ");
                double annualInterestRate = Double.parseDouble(scanner.nextLine());
                if (annualInterestRate < 0.00) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (annualInterestRate > 100.00) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return annualInterestRate;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Double getLandArea() {
        while (true) {
            try {
                printBlueText("Enter the land area (m²): ");
                double landArea = Double.parseDouble(scanner.nextLine());
                if (landArea < 0.00) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (landArea < 50.00) {
                    printError("The value can't be too low! Try again.");
                    continue;
                } else if (landArea > 10000.00) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return landArea;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Double getBuiltArea(double landArea) {
        while (true) {
            try {
                printBlueText("Enter the built area (m²): ");
                double builtArea = Double.parseDouble(scanner.nextLine());
                if (builtArea < 0.00) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (builtArea < 30.00) {
                    printError("The value can't be too low! Try again.");
                    continue;
                } else if (!Validation.isBuiltAreaValid(landArea, builtArea)) {
                    printError("The value can't be greater than the land area! Try again.");
                    continue;
                }
                return builtArea;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Integer getParkingSpaces() {
        while (true) {
            try {
                printBlueText("Enter the number of parking spaces: ");
                int parkingSpaces = Integer.parseInt(scanner.nextLine());
                if (parkingSpaces < 0) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (parkingSpaces > 10) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return parkingSpaces;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public Integer getFloorLevel() {
        while (true) {
            try {
                printBlueText("Enter the the floor level: ");
                int floorLevel = Integer.parseInt(scanner.nextLine());
                if (floorLevel < 0) {
                    printError("The value can't be negative! Try again.");
                    continue;
                } else if (floorLevel > 163) {
                    printError("The value can't be too high! Try again.");
                    continue;
                }
                return floorLevel;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public String getZoneType() {
        while (true) {
            try {
                printBlueText("Enter the the zone type: ");
                String zoneType = scanner.nextLine().strip();
                if (zoneType.isEmpty() || !zoneType.matches("[\\p{L}]+")) {
                    throw new InvalidZoneEntryException("Invalid zone entered");
                }
                return zoneType;
            } catch (InvalidZoneEntryException e) {
                printError("Invalid value entered! Please try again.");
            }
        }
    }

    public void displayOptionsMenu() {
        printGreenLine();
        printBlueText("| Financing Calculator |", true);
        printGreenLine();
        printBlueText("(1) House", true);
        printBlueText("(2) Apartment", true);
        printBlueText("(3) Land", true);
        printBlueText("(0) Exit", true);
        printGreenLine();
        printBlueText("Choose an option: ");
    }

    public Integer getUserFinancingOption() {
        while (true) {
            try {
                int userOption = Integer.parseInt(scanner.nextLine());
                if (userOption < 0 || userOption > 3) {
                    printError("This option is not available! Try again.");
                    displayOptionsMenu();
                    continue;
                }
                return userOption;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
                displayOptionsMenu();
            }
        }
    }

    public void displayListingPreferenceMenu() {
        printGreenLine();
        printBlueText("| Keep a record of the financings? |", true);
        printGreenLine();
        printBlueText("(1) Yes", true);
        printBlueText("(2) No", true);
        printGreenLine();
        printBlueText("Choose an option: ");
    }

    public Boolean getUserListingPreference() {
        while (true) {
            try {
                int userOption = Integer.parseInt(scanner.nextLine());
                if (userOption < 1 || userOption > 2) {
                    printError("This option is not available! Try again.");
                    displayOptionsMenu();
                    continue;
                }
                return userOption == 1;
            } catch (NumberFormatException e) {
                printError("Invalid value entered! Please try again.");
                displayOptionsMenu();
            }
        }
    }

    public Apartment createApartmentFinancing() {
        double propertyValue = getPropertyValue();
        int financingTerm = getFinancingTerm();
        double annualInterestRate = getAnnualInterestRate();
        int parkingSpaces = getParkingSpaces();
        int floorLevel = getFloorLevel();
        printGreenLine();

        return new Apartment(propertyValue,
                financingTerm,
                annualInterestRate,
                parkingSpaces,
                floorLevel);
    }

    public House createHouseFinancing() {
        double propertyValue = getPropertyValue();
        int financingTerm = getFinancingTerm();
        double annualInterestRate = getAnnualInterestRate();
        double landArea = getLandArea();
        double builtArea = getBuiltArea(landArea);
        printGreenLine();

        return new House(propertyValue,
                financingTerm,
                annualInterestRate,
                landArea,
                builtArea);
    }

    public Land createLandApartment() {
        double propertyValue = getPropertyValue();
        int financingTerm = getFinancingTerm();
        double annualInterestRate = getAnnualInterestRate();
        String zoneType = getZoneType();
        printGreenLine();

        return new Land(propertyValue,
                financingTerm,
                annualInterestRate,
                zoneType);
    }

}
