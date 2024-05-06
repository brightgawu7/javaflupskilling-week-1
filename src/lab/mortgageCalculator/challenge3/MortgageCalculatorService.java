package lab.mortgageCalculator.challenge3;

public class MortgageCalculatorService {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    public static double calculateMortgage(int principal, float annualInterestRate, int years) throws ArithmeticException {
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
