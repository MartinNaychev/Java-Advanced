package ExamPreparation.exam7;

import java.util.*;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        ArrayDeque<Integer> consumptionQueue = new ArrayDeque<>();
        ArrayDeque<Integer> consumptionFuelQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> fuelStack.push(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> consumptionQueue.offer(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> consumptionFuelQueue.offer(Integer.valueOf(element)));

        int counter = 1;
        boolean fail = false;
        List<String> altitudeList = new ArrayList<>();
        while (true) {
            int currentFuel = fuelStack.pop() - consumptionQueue.poll();
            int currentNeededFuel = consumptionFuelQueue.poll();
            if (currentFuel < currentNeededFuel) {
                System.out.printf("John did not reach: Altitude %d%n", counter);

                if (!altitudeList.isEmpty()) {
                    System.out.println("John failed to reach the top.");
                    System.out.print("Reached altitudes: ");
                    System.out.println(altitudeList.toString().replace("[", "").replace("]", ""));
                } else if (altitudeList.isEmpty()) {
                    System.out.println("John failed to reach the top.");
                    System.out.println("John didn't reach any altitude.");
                }
                fail = true;
                break;
            }


            System.out.printf("John has reached: Altitude %d%n", counter);
            altitudeList.add("Altitude " + counter);
            if (fuelStack.isEmpty() && consumptionQueue.isEmpty() && consumptionFuelQueue.isEmpty()) {
                break;
            }
            counter++;


        }

        if (consumptionFuelQueue.isEmpty() && !fail) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}
