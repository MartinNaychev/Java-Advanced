package PolymorphismExercises.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;

        if (neededFuel > fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
        setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",getClass().getSimpleName(),decimalFormat.format(distance));

    }

    public void refuel(double liters){
        setFuelQuantity(getFuelQuantity()+liters);

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
        return String.format("%s: %.2f", getClass().getSimpleName(),getFuelQuantity());
    }
}
