package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int count = numbers.size();

        Function<List<Integer>, Integer> numbersSum = list-> {
          int sum = 0;
            for (Integer number : list) {
                sum+=number;
            }
            return sum;
        };

        int sum = numbersSum.apply(numbers);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);

    }
}
