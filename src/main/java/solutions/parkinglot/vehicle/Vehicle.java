package solutions.parkinglot.vehicle;

import lombok.Getter;

@Getter
public abstract class Vehicle {

    protected final String licensePlate;
    protected final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

}
