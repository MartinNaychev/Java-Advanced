package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<String> childrenInGame = new PriorityQueue<>();
        String[] names = scanner.nextLine().split("\\s+");


        Collections.addAll(childrenInGame, names);

        int leftToss = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        while (childrenInGame.size() > 1) {
            String currentChild = childrenInGame.poll();
            counter ++;

            if (isPrime(counter)) {
                System.out.println("Prime " + currentChild);
                childrenInGame.offer(currentChild);
            } else {
                System.out.println("Removed " + currentChild);
            }

        }
        System.out.println("Last is " + childrenInGame.peek());

    }

    private static boolean isPrime(int counter) {
       if (counter==1){
           return false;
       }
        boolean isPrime = true;

        // Прости числа: делят се целочислено без остатък на 1 и себе си!
        // Непрости числа: Търсим още един делител
        for (int divisor = 2; divisor <= counter - 1; divisor++) {
            // Има друг възможен делител!
            if (counter % divisor == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }


}
