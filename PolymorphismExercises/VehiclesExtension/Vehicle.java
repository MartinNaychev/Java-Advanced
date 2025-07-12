package PolymorphismExercises.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);

    }

    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;

        if (neededFuel > fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
        setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", getClass().getSimpleName(), decimalFormat.format(distance));

    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        } else if (getFuelQuantity() + liters > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        setFuelQuantity(getFuelQuantity() + liters);

    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {

        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
