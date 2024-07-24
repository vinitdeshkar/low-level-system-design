package solutions.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

@Getter
@Setter
public class ParkingFloor {

    private int parkingFloorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int parkingFloorNumber, Map<VehicleType, Integer> spotTypeCountMap) {
        this.parkingFloorNumber = parkingFloorNumber;
        this.parkingSpots = new ArrayList<>();

        spotTypeCountMap.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                this.parkingSpots.add(new ParkingSpot(key.toString() + " " + i, key));
            }
        });

    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().getLicensePlate().equalsIgnoreCase(vehicle.getLicensePlate())) {
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + parkingFloorNumber + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));
        }
    }

}
