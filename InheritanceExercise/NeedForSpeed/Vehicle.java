package InheritanceExercise.NeedForSpeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;


    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double kilometers) {
        double neededFuel = this.getFuelConsumption() * kilometers;
        if (this.getFuel() >= neededFuel) {
            this.setFuel(this.getFuel()-neededFuel);

        }

    }
}
