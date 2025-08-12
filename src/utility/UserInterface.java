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
            System.out.print("Enter the annual interest rate: ");
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
}
