package DefiningClasses.CarInfo;

public class Car {

    private String brand;
    private String model;
    private int hp;


    public Car(String brand, String model, int hp) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
    }

   public void printCarInfo(){
       System.out.printf("The car is: %s %s - %d HP.%n",this.brand,this.model,this.hp);
   }
}
