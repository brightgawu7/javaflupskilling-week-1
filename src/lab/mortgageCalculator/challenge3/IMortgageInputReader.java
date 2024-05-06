package lab.mortgageCalculator.challenge3;

import java.util.function.Predicate;

public interface IMortgageInputReader {

    int getPrincipal(Predicate<Integer> predicate, String errorMessage);

    float getAnnualInterestRate(Predicate<Float> predicate, String errorMessage);

    byte getPeriodYears(Predicate<Byte> predicate, String errorMessage);

    void close();

}
