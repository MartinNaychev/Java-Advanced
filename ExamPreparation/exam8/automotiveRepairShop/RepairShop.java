package ExamPreparation.exam8.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        Vehicle vehicleForRemove = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                vehicleForRemove = vehicle;
            }
        }
        return vehicles.remove(vehicleForRemove);
    }
    public int getCount(){
        return vehicles.size();
    }
    public Vehicle getLowestMileage(){
        int lowerMileage = Integer.MAX_VALUE;
        Vehicle lowestVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMileage()<lowerMileage){
                lowerMileage=vehicle.getMileage();
                lowestVehicle=vehicle;
            }
        }
        return lowestVehicle;
    }
    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicles in the preparatory:");
        for (Vehicle vehicle : vehicles) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(vehicle.toString());
        }
     return stringBuilder.toString();
    }
}
