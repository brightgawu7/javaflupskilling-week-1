package lab.mortgageCalculator.challenge3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleMortgageInputReader implements IMortgageInputReader {

    Scanner scanner;

    public ConsoleMortgageInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getPrincipal(Predicate<Integer> predicate, String errorMessage) {
        while (true) {
            try {
                System.out.print("Principal: ");
                int principal = scanner.nextInt();
                if (predicate.test(principal))
                    return principal;
                System.out.println(errorMessage + "\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.nextLine();
            }
        }
    }

    @Override
    public float getAnnualInterestRate(Predicate<Float> predicate, String errorMessage) {
        while (true) {
            try {
                System.out.print("Annual Interest Rate: ");
                float annualInterestRate = scanner.nextFloat();
                if (predicate.test(annualInterestRate))
                    return annualInterestRate;
                System.out.println(errorMessage + "\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid interest rate.\n");
                scanner.nextLine();
            }
        }
    }

    @Override
    public byte getPeriodYears(Predicate<Byte> predicate, String errorMessage) {
        while (true) {
            try {
                System.out.print("Period (Years):");
                byte years = scanner.nextByte();
                if (predicate.test(years))
                    return years;
                System.out.println(errorMessage + "\n");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number of years.\n.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
