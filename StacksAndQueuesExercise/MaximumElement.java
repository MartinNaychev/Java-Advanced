package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String commands = scanner.nextLine();
            if (commands.startsWith("1")) {
                int elementToPush = Integer.parseInt(commands.split("\\s+")[1]);
                numbers.push(elementToPush);

            } else if (commands.startsWith("2")) {

                numbers.pop();
            } else if (commands.startsWith("3")) {
                int maxElement = validateMaxElement (numbers);
                System.out.println(maxElement);
            }

        }

    }
    private static int validateMaxElement(ArrayDeque<Integer> numbers) {
        int maxValue = Integer.MIN_VALUE;

        for (Integer number : numbers){
            if (number>maxValue){
                maxValue = number;
            }
        }

        return maxValue;
    }
}
