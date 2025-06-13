package IteratorsAndComparatorsExercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String input = scanner.nextLine();

        while (!input.equals("END")){

            if (input.equals("Pop")){
                customStack.pop();
            }else {
                int [] numbers = Arrays.stream(input.replace("Push ", "").split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int number : numbers) {
                    customStack.push(number);
                }

            }
            input= scanner.nextLine();
        }

        for (Integer number : customStack) {
            System.out.println(number);
        }
        for (Integer number : customStack) {
            System.out.println(number);
        }

    }
}
