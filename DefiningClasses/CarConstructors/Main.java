package DefiningClasses.CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int carCount = Integer.parseInt(scanner.nextLine());

        while (carCount-->0){

            String[] carInfo = scanner.nextLine().split("\\s+");
           Car car = new Car();

            if (carInfo.length == 3){
                car = new Car(carInfo[0],carInfo[1],Integer.parseInt(carInfo[2]));
                
            } else if (carInfo.length==1) {
                car = new Car(carInfo[0]);
            }
            car.printCarInfo();
        }
    }
}
