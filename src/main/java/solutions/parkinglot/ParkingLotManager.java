package solutions.parkinglot;

import java.util.*;

import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

public class ParkingLotManager implements ParkingLot {

    private static ParkingLotManager instance;

    // Map of parking floor number and parking floor
    private final Map<Integer, ParkingFloor> parkingFloorMap;

    // Map of vehicle licensePlate and parking floor number
    private final Map<String, Integer> vehicleParkingFloorMap;

    // Created a private constructor to add a restriction (due to Singleton)
    private ParkingLotManager() {
        parkingFloorMap = new HashMap<>();
        vehicleParkingFloorMap = new HashMap<>();
    }

    // Created a static method to access the singleton instance of ParkingLot
    public static synchronized ParkingLotManager getInstance() {
        if (instance == null) {
            instance = new ParkingLotManager();
            return instance;
        }
        return instance;
    }

    @Override
    public void addLevel(ParkingFloor parkingFloor) {
        parkingFloorMap.put(parkingFloor.getParkingFloorNumber(), parkingFloor);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

        List<ParkingFloor> parkingFloors = new ArrayList<>(parkingFloorMap.values());

        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.parkVehicle(vehicle)) {
                vehicleParkingFloorMap.put(vehicle.getLicensePlate(), parkingFloor.getParkingFloorNumber());
                return;
            }
        }

    }

    @Override
    public void unParkVehicle(Vehicle vehicle) {

        String licensePlate = vehicle.getLicensePlate();

        if (vehicleParkingFloorMap.containsKey(licensePlate)) {
            int parkingFloorNumber = vehicleParkingFloorMap.get(licensePlate);
            ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorNumber);
            parkingFloor.unParkVehicle(vehicle);
        }
    }

    @Override
    public void displayAvailability() {
        for (ParkingFloor parkingFloor : parkingFloorMap.values()) {
            System.out.println("-------LEVEL " + parkingFloor.getParkingFloorNumber() + "  AVAILABILITY--------");
            Map<VehicleType, Integer> availableSpotsCount = parkingFloor.displayAvailability();

            availableSpotsCount.forEach((spotType, count) -> {
                System.out.println(spotType + " :" + count);
            });
        }
    }
}
