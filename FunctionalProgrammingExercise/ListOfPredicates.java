package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bound = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int number = 1; number <= bound; number++) {
            BiPredicate<List<Integer>, Integer> validateNumber = (list, currentNumber) -> {
                for (int divider : list) {
                    if (currentNumber % divider != 0) {
                        return false;
                    }
                }
                return true;
            };
            if (validateNumber.test(numbers,number)){

            System.out.print(number + " ");
            }

        }

    }
}
