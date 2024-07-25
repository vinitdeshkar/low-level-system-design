package solutions.parkinglot;

import solutions.parkinglot.vehicle.Vehicle;

public interface ParkingLot {

    void addLevel(ParkingFloor parkingFloor);

    void parkVehicle(Vehicle vehicle);

    void unParkVehicle(Vehicle vehicle);

    void displayAvailability();
}
