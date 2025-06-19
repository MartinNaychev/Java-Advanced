package ExamPreparation.exam5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> moneyStack = new ArrayDeque<>();
        ArrayDeque<Integer> foodQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> moneyStack.push(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> foodQueue.offer(Integer.valueOf(element)));

        int countEatenFood = 0;

        while (!moneyStack.isEmpty() && !foodQueue.isEmpty()) {
            int currentMoney = moneyStack.pop();
            int currentFood = foodQueue.poll();


            if (currentMoney > currentFood) {
                int change = currentMoney - currentFood;
                countEatenFood++;
                if (!moneyStack.isEmpty()) {
                    int nextMoney = moneyStack.pop();
                    moneyStack.push(nextMoney + change);
                } else {
                    moneyStack.push(change);
                }
            } else if (currentMoney==currentFood) {
                countEatenFood++;

            }

        }

        if (countEatenFood==0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }else if (countEatenFood==1){
            System.out.println("Henry ate: 1 food.");

        } else if (countEatenFood>=4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.",countEatenFood);
        }else {
            System.out.printf("Henry ate: %d foods.",countEatenFood);
        }

    }
}
