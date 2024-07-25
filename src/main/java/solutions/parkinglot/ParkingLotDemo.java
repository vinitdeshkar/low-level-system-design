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
        ParkingLotManager parkingLot = ParkingLotManager.getInstance();

        // This config defines parking spot types and their counts
        Map<VehicleType, Integer> spotsConfiguration = new HashMap<>();
        spotsConfiguration.put(VehicleType.CAR, 5);
        spotsConfiguration.put(VehicleType.TRUCK, 2);
        spotsConfiguration.put(VehicleType.MOTORCYCLE, 10);

        for (int i = 0; i < 2; i++) {
            ParkingFloor parkingFloor =
                    ParkingFloor
                            .newBuilder()
                            .setParkingFloorNumber(i)
                            .setParkingSpots(spotsConfiguration)
                            .build();
            parkingLot.addLevel(parkingFloor);
        }

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
