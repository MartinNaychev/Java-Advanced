package InheritanceExercise.NeedForSpeed;

public class Car extends Vehicle{

    private final static double DEFAULT_FUEL_CONSUMPTION = 3;


    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
