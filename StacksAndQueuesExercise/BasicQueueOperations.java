package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int numbersToPut = Integer.parseInt(input[0]);
        int numbersToRemove = Integer.parseInt(input[1]);
        int elementToCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int[] numbersToOffer = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbersToPut; i++) {
            numbers.offer(numbersToOffer[i]);
        }

        for (int i = 0; i < numbersToRemove; i++) {
            numbers.poll();

        }
        if (numbers.isEmpty()){
            System.out.println(0);
        } else if (numbers.contains(elementToCheck)) {
            System.out.println("true");
        }else {
            int minElement = validateMinElement (numbers);
            System.out.println(minElement);
        }

    }
    private static int validateMinElement(ArrayDeque<Integer> numbers) {
        int minNumber = Integer.MAX_VALUE;

        for (Integer number : numbers){
            if (number<minNumber){
                minNumber = number;
            }
        }

        return minNumber;
    }
}
