package PolymorphismExercises.VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(tokens);
        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(tokens);
        tokens = scanner.nextLine().split("\\s+");
        Vehicle bus = getVehicle(tokens);
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int countRows = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countRows; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicleType = tokens[1];

            switch (command) {
                case "Drive" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));

                }
                case "Refuel" -> {
                    double liters = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(liters);
                }
                case  "DriveEmpty" ->{
                    double distance = Double.parseDouble(tokens[2]);
                    Bus emtyBus = (Bus) vehicles.get(vehicleType);
                    System.out.println(emtyBus.driveEmpty(distance));


                }
            }


        }

        vehicles.values().forEach(vehicle -> System.out.println(vehicle.toString()));


    }

    private static Vehicle getVehicle(String[] tokens) {

        String type = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        int tankCapacity = Integer.parseInt(tokens[3]);

        Vehicle vehicle = null;
        switch (type) {
            case "Car" -> vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck" -> vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus" -> vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
        return vehicle;
    }
}



