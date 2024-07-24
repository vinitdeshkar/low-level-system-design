package solutions.parkinglot;

import lombok.Getter;
import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

@Getter
public class ParkingSpot {
    private final String spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicleType = VehicleType.CAR; // Default Vehicle type is CAR
    }

    public ParkingSpot(String spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType == null ? VehicleType.CAR : vehicleType;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == this.vehicleType) {
            this.parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public void unParkVehicle() {
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return this.parkedVehicle == null;
    }
}
