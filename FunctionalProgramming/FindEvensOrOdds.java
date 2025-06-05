package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startNumber = numbers[0];
        int endNumber = numbers[1];

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> validateNumber = number -> number % 2 == 0;

        for (int number = startNumber; number <= endNumber; number++) {
            if (evenOrOdd.equals("even") && validateNumber.test(number)) {
                System.out.print(number + " ");

            } else if (evenOrOdd.equals("odd") && !validateNumber.test(number)) {
                System.out.print(number + " ");
            }
        }


    }
}
