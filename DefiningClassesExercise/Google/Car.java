package DefiningClassesExercise.Google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public Car( ) {
        this.carModel = "";
        this.carSpeed = -1;
    }

    @Override
    public String toString(){
        return this.carModel.equals("") ? "Car:" : String.format("Car: %n%s %d",this.carModel,this.carSpeed);

    }
}
