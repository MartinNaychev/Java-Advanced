package DefiningClasses.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());


        while (carCount-->0){
            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];
            String mode = carInfo[1];
            int hp = Integer.parseInt(carInfo[2]);

            Car car = new Car(brand,mode,hp);

            car.printCarInfo();



        }
    }
}
