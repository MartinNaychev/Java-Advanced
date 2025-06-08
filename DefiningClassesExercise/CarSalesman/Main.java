package DefiningClassesExercise.CarSalesman;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineRows = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        while (engineRows-- > 0) {

            String[] engineParts = scanner.nextLine().split("\\s+");

            Engine engine = getEngine(engineParts);

            engines.add(engine);
        }

        int carRows = Integer.parseInt(scanner.nextLine());
        List<Car>cars = new ArrayList<>();

        while (carRows-- > 0) {
            String[] carParts = scanner.nextLine().split("\\s+");
            Car car = getCar(carParts);

            cars.add(car);

        }
        for (Car car : cars) {
            System.out.println(car.getModel()+ ":");
            System.out.println(car.getEngine()+ ":");
            engines.forEach(engine -> {
                if (engine.getEngineModel().equals(car.getEngine())){
                    System.out.println(engine);
                }
            });
            System.out.println(car);

        }





    }

    private static Car getCar(String[] carParts) {
        Car car;
        String model = carParts[0];
        String engine = carParts[1];


        if (carParts.length==4){

            int weight = Integer.parseInt(carParts[2]);
            String color = carParts[3];

            car= new Car(model,engine,weight,color);


        } else if (carParts.length==3) {
            try {
                int weight = Integer.parseInt(carParts[2]);
                car=new Car(model,engine,weight);
            } catch (NumberFormatException e) {
                String color = carParts[2];
                car=new Car(model,engine,color);
            }

        }else {
            car=new Car(model,engine);
        }
        return car;
    }

    private static Engine getEngine(String[] engineParts) {
        String engineModel = engineParts[0];
        int enginePower = Integer.parseInt(engineParts[1]);
        Engine engine;

        if (engineParts.length == 4) {
            int enginDisplacement = Integer.parseInt(engineParts[2]);
            String enginEfficiency = engineParts[3];
            engine = new Engine(engineModel, enginePower, enginDisplacement, enginEfficiency);

        } else if (engineParts.length == 3) {
            try {
                int enginDisplacement = Integer.parseInt(engineParts[2]);
                engine = new Engine(engineModel, enginePower, enginDisplacement);

            } catch (NumberFormatException exception) {
                String enginEfficiency = engineParts[2];
                engine = new Engine(engineModel, enginePower, enginEfficiency);
            }

        } else {
            engine = new Engine(engineModel, enginePower);
        }
        return engine;
    }


}
