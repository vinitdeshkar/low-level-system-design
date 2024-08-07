package solutions.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private final List<Elevator> elevators;

    private final ElevatorFinder elevatorFinder;

    public ElevatorController(int numElevators, int capacity, ElevatorFinder elevatorFinder) {
        this.elevators = new ArrayList<>();
        this.elevatorFinder = elevatorFinder;
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor, destinationFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }

    // Strategy design pattern implementation
    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        return elevatorFinder.findBestElevator(this.elevators, sourceFloor, destinationFloor);
    }

}
