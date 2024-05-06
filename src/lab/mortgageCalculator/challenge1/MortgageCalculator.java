package lab.mortgageCalculator.challenge1;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Principal: ");
                principal = scanner.nextInt();
                if (principal > 1000 && principal <= 1_000_000)
                    break;
                System.out.println("Enter a value between 1000 and 1000000\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.nextLine();
            }
        }

        float monthlyInterest;
        while (true) {
            try {
                System.out.print("Annual Interest Rate: ");
                float annualInterestRate = scanner.nextFloat();
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid interest rate.\n");
                scanner.nextLine();
            }

        }
        byte years;
        while (true) {
            try {
                System.out.print("Period (Years):");
                years = scanner.nextByte();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number of years.\n.");
                scanner.nextLine();
            }
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        try {
            double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage: " + mortgageFormatted);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

    }

}
