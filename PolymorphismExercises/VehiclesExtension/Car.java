package PolymorphismExercises.VehiclesExtension;

public class Car extends Vehicle {

    private static final double SUMMER_INCREASED_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(super.getFuelConsumption() + SUMMER_INCREASED_CONSUMPTION);

    }

}
