package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> calculate = null;
        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {

            if (command.equals("add")) {
                calculate = list -> list.stream().map(number -> number += 1).toList();
                numbers = calculate.apply(numbers);

            } else if (command.equals("multiply")) {
                calculate = list -> list.stream().map(number -> number *= 2).toList();
                numbers = calculate.apply(numbers);

            } else if (command.equals("subtract")) {
                calculate = list -> list.stream().map(number -> number -= 1).toList();
                numbers = calculate.apply(numbers);

            } else if (command.equals("print")) {
                printCommand.accept(numbers);
                System.out.println();

            }

            command = scanner.nextLine();
        }
    }
}
