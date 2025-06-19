package ExamPreparation.exam6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        ArrayDeque<Integer> holesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> wormsStack.push(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> holesQueue.offer(Integer.valueOf(element)));

        int matches = 0;
        int removedWorms = 0;


        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            int worms = wormsStack.pop();
            int holes = holesQueue.poll();

            if (worms != holes) {
                int newWormsValue = worms - 3;
                if (newWormsValue > 0) {
                    wormsStack.push(newWormsValue);
                } else {
                    removedWorms++;
                }

            } else {
                matches++;
            }


        }

        if (matches > 0) {
            System.out.printf("Matches: %d%n", matches);
        } else {
            System.out.println("There are no matches.");
        }


        if (wormsStack.isEmpty() && removedWorms == 0) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty() && removedWorms > 0) {
            System.out.println("Worms left: none");
        } else if (!wormsStack.isEmpty()) {
            System.out.print("Worms left: ");
            System.out.println(wormsStack.reversed().toString().replace("[", "").replace("]", ""));
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.print("Holes left: ");
            System.out.println(holesQueue.toString().replace("[", "").replace("]", ""));
        }

    }
}
