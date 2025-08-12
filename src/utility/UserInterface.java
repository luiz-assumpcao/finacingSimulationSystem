package utility;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public Double getPropertyValue() {
        System.out.print("Enter the property value: ");
        double propertyValue = Double.parseDouble(scanner.nextLine());
        return propertyValue;
    }

    public Integer getFinancingTerm() {
        System.out.print("Enter the financing term: ");
        int financingTerm = Integer.parseInt(scanner.nextLine());
        return financingTerm;
    }

    public Double getAnnualInterestRate() {
        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = Double.parseDouble(scanner.nextLine());
        return annualInterestRate;
    }
}
