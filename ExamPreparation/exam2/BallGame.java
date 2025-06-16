package ExamPreparation.exam2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> strengthsStack = new ArrayDeque<>();
        ArrayDeque<Integer> accuraciesQueue = new ArrayDeque<>();

        int[] inputStrengths = getInput(scanner);
        int[] inputAccuracies = getInput(scanner);

        for (int strength : inputStrengths) {
            strengthsStack.push(strength);
        }
        for (int accuracy : inputAccuracies) {
            accuraciesQueue.offer(accuracy);
        }

        int goals = 0;

        while (!strengthsStack.isEmpty() && !accuraciesQueue.isEmpty()) {
            int currentStrength = strengthsStack.peek();
            int currentAccuracies = accuraciesQueue.peek();

            int sum = currentAccuracies + currentStrength;

            if (sum > 100) {
                strengthsStack.pop();
                currentStrength -= 10;
                strengthsStack.push(currentStrength);
                accuraciesQueue.poll();
                accuraciesQueue.offer(currentAccuracies);

            } else if (sum==100){
                goals++;
                strengthsStack.pop();
                accuraciesQueue.poll();

            }else if (sum < 100) {
                if (currentStrength < currentAccuracies) {
                    strengthsStack.pop();
                } else if (currentStrength > currentAccuracies) {
                    accuraciesQueue.poll();
                } else {
                    strengthsStack.pop();
                    strengthsStack.push(sum);
                    accuraciesQueue.poll();
                }
            }
        }


        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");

        } else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else if (goals > 0 && goals < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goals != 0) {

        System.out.printf("Goals scored: %d%n",goals);
        }

        if (!strengthsStack.isEmpty()){

            System.out.print("Strength values left: ");
            System.out.println(strengthsStack.reversed().toString().replace("[", "").replace("]", ""));

        }
        if (!accuraciesQueue.isEmpty()){
            System.out.print("Accuracy values left: ");
            System.out.println(accuraciesQueue.toString().replace("[", "").replace("]", ""));


        }


    }

    private static int[] getInput(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
