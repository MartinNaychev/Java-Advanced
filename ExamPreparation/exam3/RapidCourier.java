package ExamPreparation.exam3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> packagesStack = new ArrayDeque<>();
        ArrayDeque<Integer> couriersQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> packagesStack.push(Integer.valueOf(element)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> couriersQueue.offer(Integer.valueOf(element)));


        int totalWeight = 0;


        while (!couriersQueue.isEmpty() && !packagesStack.isEmpty()) {
            //int currentCourier = couriersQueue.peek();
            //int currentPackage = packagesStack.peek();

            int currentCourier = couriersQueue.poll();
            int currentPackage = packagesStack.pop();

            if (currentCourier >= currentPackage) {
                if (currentCourier > currentPackage) {
                    currentCourier -= (currentPackage * 2);
                    if (currentCourier > 0) {
                        couriersQueue.offer(currentCourier);
                    }
                }
                totalWeight += currentPackage;


            } else if (currentCourier < currentPackage) {
                currentPackage = currentPackage - currentCourier;
                packagesStack.push(currentPackage);
                totalWeight += currentCourier;

            }


        }


        System.out.printf("Total weight: %d kg%n", totalWeight);
        if (packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            System.out.println(packagesStack.reversed().toString().replace("[", "").replace("]", ""));
        } else if (packagesStack.isEmpty() && !couriersQueue.isEmpty()) {
            System.out.print("Couriers are still on duty: ");
            System.out.print(couriersQueue.toString().replace("[", "").replace("]", ""));
            System.out.println(" but there are no more packages to deliver.");
        }

    }
}
