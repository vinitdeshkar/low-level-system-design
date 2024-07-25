package solutions.parkinglot;

import java.util.ArrayList;
import java.util.List;

import solutions.parkinglot.vehicle.Vehicle;

public class ParkingLot {

    private static ParkingLot instance;
    private final List<ParkingFloor> parkingFloors;

    // Created a private constructor to add a restriction (due to Singleton)
    private ParkingLot() {
        parkingFloors = new ArrayList<>();
    }

    // Created a static method to access the singleton instance of ParkingLot
    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
            return instance;
        }
        return instance;
    }

    public void addLevel(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.unParkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingFloor parkingFloor : parkingFloors) {
            System.out.println("-------LEVEL " + parkingFloor.getParkingFloorNumber() + "--------");
            parkingFloor.displayAvailability();
        }
    }
}
