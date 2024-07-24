package solutions.parkinglot;

import java.util.HashMap;
import java.util.Map;

import solutions.parkinglot.vehicle.Car;
import solutions.parkinglot.vehicle.MotorCycle;
import solutions.parkinglot.vehicle.Truck;
import solutions.parkinglot.vehicle.Vehicle;
import solutions.parkinglot.vehicle.VehicleType;

public class ParkingLotDemo {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Map<VehicleType, Integer> spotTypeCountMap = new HashMap<>();
        spotTypeCountMap.put(VehicleType.CAR, 2);
        spotTypeCountMap.put(VehicleType.TRUCK, 1);
        spotTypeCountMap.put(VehicleType.MOTORCYCLE, 5);

        parkingLot.addLevel(new ParkingFloor(1, spotTypeCountMap));
        parkingLot.addLevel(new ParkingFloor(2, spotTypeCountMap));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new MotorCycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unParkVehicle(motorcycle);

        System.out.println();
        System.out.println("------------PARKING LOT AFTER REMOVING MOTORCYCLE-------------");

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
