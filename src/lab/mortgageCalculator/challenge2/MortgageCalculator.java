package lab.mortgageCalculator.challenge2;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator {
    final static int MIN_PRINCIPAL = 1000;
    final static int MAX_PRINCIPAL = 1_000_000;
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = getPrincipal(scanner);
        float monthlyInterest = getAnnualInterestRate(scanner) / PERCENT / MONTHS_IN_YEAR;
        byte years = getPeriodYears(scanner);
        scanner.close();

        int numberOfPayments = years * MONTHS_IN_YEAR;

        try {
            double mortgage = calculateMortgage(principal, monthlyInterest, numberOfPayments);
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage: " + mortgageFormatted);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }
    }


    private static int getPrincipal(Scanner scanner) {
        int principal;
        while (true) {
            try {
                System.out.print("Principal: ");
                principal = scanner.nextInt();
                if (principal > MIN_PRINCIPAL && principal <= MAX_PRINCIPAL)
                    break;
                System.out.println("Enter a value between " + MIN_PRINCIPAL + " and " + MAX_PRINCIPAL + "\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.nextLine();
            }
        }
        return principal;
    }

    private static float getAnnualInterestRate(Scanner scanner) {
        float annualInterestRate;
        while (true) {
            try {
                System.out.print("Annual Interest Rate: ");
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate > 0)
                    break;
                System.out.println("Invalid input. Interest rate should be a positive number greater than zero.\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid interest rate.\n");
                scanner.nextLine();
            }
        }
        return annualInterestRate;
    }

    private static byte getPeriodYears(Scanner scanner) {
        byte years;
        while (true) {
            try {
                System.out.print("Period (Years):");
                years = scanner.nextByte();
                if (years > 0)
                    break;
                System.out.println("Invalid input. Period (Years) should be a positive number greater than zero.\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number of years.\n.");
                scanner.nextLine();
            }
        }
        return years;
    }

    private static double calculateMortgage(int principal, float monthlyInterest, int numberOfPayments) throws ArithmeticException {
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
