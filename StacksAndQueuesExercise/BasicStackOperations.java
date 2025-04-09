package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int countToPush = commands[0];
        int countToPop = commands[1];
        int lookingFor = commands[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < countToPush; i++) {
            stackNumbers.push(numbers[i]);
        }
        for (int i = 0; i < countToPop; i++) {
            stackNumbers.pop();
        }

        if (stackNumbers.isEmpty()) {
            System.out.println("0");
        } else if (stackNumbers.contains(lookingFor)) {
            System.out.println("true");
        } else {
            int minElement = validateMinElement (stackNumbers);
            System.out.println(minElement);
        }

    }

    private static int validateMinElement(ArrayDeque<Integer> stackNumbers) {
        int minNumber = Integer.MAX_VALUE;

        for (Integer number : stackNumbers){
            if (number<minNumber){
                minNumber = number;
            }
        }

        return minNumber;
    }
}
