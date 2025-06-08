package DefiningClassesExercise.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> allValidCars = new LinkedHashMap<>();


        while (rows-- > 0) {
            String[] carParts = scanner.nextLine().split("\\s+");
            //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String name = carParts[0];
            int speed = Integer.parseInt(carParts[1]);
            int power = Integer.parseInt(carParts[2]);
            int weight = Integer.parseInt(carParts[3]);
            String type = carParts[4];
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i <= 12; i = i + 2) {
                double pressure = Double.parseDouble(carParts[i]);
                int age = Integer.parseInt(carParts[i + 1]);
                Tire tire = new Tire(pressure, age);
                tires.add(tire);
            }
            Car car = new Car(name, engine, cargo, tires);
            boolean isCorrect = validateRange(type, power, tires);
            List<Car> cars = new ArrayList<>();

            if (isCorrect) {
                if (!allValidCars.containsKey(type)) {
                    cars.add(car);
                    allValidCars.put(type, cars);

                } else {
                    cars = allValidCars.get(type);
                    cars.add(car);
                    allValidCars.put(type, cars);

                }

            }

        }


        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            allValidCars.remove("flamable");


        } else if (command.equals("flamable")) {
            allValidCars.remove("fragile");
        }
        allValidCars.entrySet().forEach(entry -> entry.getValue().forEach(car -> System.out.println(car.getModel())));

    }

    private static boolean validateRange(String type, int power, List<Tire> tires) {
        if (type.equals("fragile")) {

            for (Tire tire : tires) {
                double pressure = tire.getPressure();
                if (pressure < 1) {
                    return true;
                }
            }


        } else if (type.equals("flamable")) {
            if (power > 250) {
                return true;
            }
        }

        return false;
    }
}
