package PolymorphismExercises.VehiclesExtension;

public class Bus extends Vehicle{

    private static final double ADDITIONAL_CONSUMPTION = 1.4;
    private double emptyBusConsumption;
    private double nonEmptyBusConsumption;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setEmptyBusConsumption(super.getFuelConsumption());
        setNonEmptyBusConsumption(super.getFuelConsumption()+ADDITIONAL_CONSUMPTION);

    }

    @Override
    public String drive(double distance) {
        super.setFuelConsumption(nonEmptyBusConsumption);
        return super.drive(distance);
    }

    public String driveEmpty(double distance) {
        super.setFuelConsumption(emptyBusConsumption);
        return super.drive(distance);
    }

    public double getEmptyBusConsumption() {
        return emptyBusConsumption;
    }

    public void setEmptyBusConsumption(double emptyBusConsumption) {
        this.emptyBusConsumption = emptyBusConsumption;
    }

    public double getNonEmptyBusConsumption() {
        return nonEmptyBusConsumption;
    }

    public void setNonEmptyBusConsumption(double nonEmptyBusConsumption) {
        this.nonEmptyBusConsumption = nonEmptyBusConsumption;
    }
}
