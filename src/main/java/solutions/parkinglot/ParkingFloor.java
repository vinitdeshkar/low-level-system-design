package solutions.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

public class ParkingFloor {

    private final int parkingFloorNumber;
    private final List<ParkingSpot> parkingSpots;
    // Map of vehicle licensePlate and its Parking spot
    private final Map<String, ParkingSpot> vehicleParkingSpotMap;

    public ParkingFloor(int parkingFloorNumber, List<ParkingSpot> parkingSpots) {
        this.parkingFloorNumber = parkingFloorNumber;
        this.parkingSpots = parkingSpots;
        vehicleParkingSpotMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.parkVehicle(vehicle);
                vehicleParkingSpotMap.put(vehicle.getLicensePlate(), spot);
                return true;
            }
        }

        throw new ParkingLotException("Invalid vehicle type or spot already occupied.");

    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        String licensePlate = vehicle.getLicensePlate();
        if (vehicleParkingSpotMap.containsKey(licensePlate)) {
            ParkingSpot parkingSpot = vehicleParkingSpotMap.get(licensePlate);
            parkingSpot.unParkVehicle();
            vehicleParkingSpotMap.remove(vehicle.getLicensePlate());
            return true;
        }

        return false;
    }

    public Map<VehicleType, Integer> displayAvailability() {

        Map<VehicleType, Integer> availableSpotsCount = new HashMap<>();
        for (ParkingSpot spot : parkingSpots) {
            // System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));
            if (spot.isAvailable()) {
                VehicleType vehicleType = spot.getVehicleType();
                availableSpotsCount.put(vehicleType, availableSpotsCount.getOrDefault(vehicleType, 0) + 1);
            }
        }

        return availableSpotsCount;

    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public static ParkingFloorBuilder newBuilder() {
        return new ParkingFloorBuilder();
    }


    // Builder design pattern example
    public static class ParkingFloorBuilder {
        private int parkingFloorNumber;
        private List<ParkingSpot> parkingSpots;

        public ParkingFloorBuilder setParkingFloorNumber(int parkingFloorNumber) {
            this.parkingFloorNumber = parkingFloorNumber;
            return this;
        }

        public ParkingFloorBuilder setParkingSpots(Map<VehicleType, Integer> spotsConfiguration) {
            this.parkingSpots = new ArrayList<>();
            spotsConfiguration.forEach((key, value) -> {
                for (int i = 0; i < value; i++) {
                    this.parkingSpots.add(new ParkingSpot(key.toString() + " " + i, key));
                }
            });
            return this;
        }

        public ParkingFloor build() {
            return new ParkingFloor(this.parkingFloorNumber, this.parkingSpots);
        }
    }

}
