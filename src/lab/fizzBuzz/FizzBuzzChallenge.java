package lab.fizzBuzz;

import java.util.Scanner;

public class FizzBuzzChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number:");
        int number = scanner.nextInt();


        //Example #1:
        //The problem in this code is with the condition for checking if the number is divisible by both 3 and 5.
        if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("FizzBuzz");

        } else if (number % 5 == 0) {
            System.out.println("Fizz");

        } else if (number % 3 == 0) {
            System.out.println("Buzz");

        } else {
            System.out.println(number);
        }

        //Example #2:
        System.out.println("Number:");
        int numberTwo = scanner.nextInt();
        boolean isDivisibleBy3 = numberTwo % 3 == 0;
        boolean isDivisibleBy5 = numberTwo % 5 == 0;

        if (isDivisibleBy3 && isDivisibleBy5) {
            System.out.println("FizzBuzz");
        } else if (isDivisibleBy5) {
            System.out.println("Fizz");
        } else if (isDivisibleBy3) {
            System.out.println("Buzz");
        } else {
            System.out.println(numberTwo);
        }
    }
}
