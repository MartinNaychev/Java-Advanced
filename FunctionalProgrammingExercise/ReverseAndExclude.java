package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int divider = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkDivision = number -> number % divider == 0;

        numbers.removeIf(checkDivision);

        numbers.forEach(number-> System.out.print(number + " "));


    }
}
