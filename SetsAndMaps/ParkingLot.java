package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLots = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
                parkingLots.add(carNumber);

            } else {
                parkingLots.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parkingLots.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            parkingLots.forEach(carLot -> System.out.println(carLot));
        }

    }
}
