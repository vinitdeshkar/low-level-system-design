package solutions.elevatorsystem;

import java.util.List;

public interface ElevatorFinder {

    Elevator findBestElevator(List<Elevator> elevators, int sourceFloor, int destinationFloor);
}
