package solutions.parkinglot;

import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

public class ParkingSpot {
    private final String spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType == null ? VehicleType.CAR : vehicleType;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == this.vehicleType) {
            this.parkedVehicle = vehicle;
        }
    }

    public void unParkVehicle() {
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return this.parkedVehicle == null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
