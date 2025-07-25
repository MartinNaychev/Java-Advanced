package PolymorphismExercises.Vehicles;

public class Truck extends Vehicle {

    private static final double SUMMER_INCREASED_CONSUMPTION = 1.6;
    private static final double TANK_LEAK = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(super.getFuelConsumption()+SUMMER_INCREASED_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        liters=liters*TANK_LEAK;

        super.refuel(liters);
    }
}
