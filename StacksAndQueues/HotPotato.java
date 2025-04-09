package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int leftToss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenInGame = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            childrenInGame.offer(names[i]);
        }
        int counter = 1;
        while (childrenInGame.size() > 1) {
            String currentChild = childrenInGame.poll();
            if (counter == leftToss) {
                System.out.println("Removed " + currentChild);
                counter = 1;
            } else {
                childrenInGame.offer(currentChild);
                counter++;
            }
        }
        System.out.println("Last is " + childrenInGame.peek());

    }
}
