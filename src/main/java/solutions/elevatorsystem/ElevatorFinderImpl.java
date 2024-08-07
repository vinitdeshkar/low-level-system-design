package solutions.elevatorsystem;

import java.util.List;

// FCFS (First Come First Serve Algorithm)
public class ElevatorFinderImpl implements ElevatorFinder {
    @Override
    public Elevator findBestElevator(List<Elevator> elevators, int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }

        return optimalElevator;
    }
}
