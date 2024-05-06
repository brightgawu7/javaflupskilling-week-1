package lab.mortgageCalculator.challenge3;

import java.text.NumberFormat;

public class MortgageCalculatorApp {
    private static final int MIN_PRINCIPAL = 1000;
    private static final int MAX_PRINCIPAL = 1_000_000;

    public static void main(String[] args) {
        displayTitle();

        IMortgageInputReader inputReader = new ConsoleMortgageInputReader();
        int principal = inputReader.getPrincipal(
                (input) -> input > MIN_PRINCIPAL && input <= MAX_PRINCIPAL,
                "Enter a value between " + MIN_PRINCIPAL + " and " + MAX_PRINCIPAL + "."
        );
        float annualInterestRate = inputReader.getAnnualInterestRate(
                (input) -> input > 0,
                "Invalid input. Interest rate should be a positive number greater than zero."
        );
        int years = inputReader.getPeriodYears(
                (input) -> input > 0,
                "Invalid input. Please enter a valid number of years."
        );
        inputReader.close();

        try {
            double mortgage = MortgageCalculatorService.calculateMortgage(principal, annualInterestRate, years);
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage: " + mortgageFormatted);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }
    }

    private static void displayTitle() {

        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$ Mortgage Calculator $$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println();
    }
}
