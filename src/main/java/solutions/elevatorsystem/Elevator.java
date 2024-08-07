package solutions.elevatorsystem;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

    private final int elevatorId;
    private int currentFloor;
    private final Queue<Request> requestsQueue;
    private final int capacity;
    private ElevatorState elevatorState;

    public Elevator(int elevatorId, int capacity) {
        this.elevatorId = elevatorId;
        this.capacity = capacity;
        this.elevatorState = ElevatorState.IDLE;
        this.currentFloor = 1;
        this.requestsQueue = new LinkedList<>();
    }

    public synchronized void addRequest(Request request) {
        if (requestsQueue.size() < capacity) {
            requestsQueue.add(request);
            System.out.println("Elevator " + elevatorId + " added request: " + request.getSourceFloor() + "-->" + request.getDestinationFloor());
            notifyAll();
        }
    }

    public synchronized void processRequests() {
        while (true) {
            while (!requestsQueue.isEmpty()) {
                Request request = requestsQueue.poll();
                executeRequest(request);
            }
            try {
                this.elevatorState = ElevatorState.IDLE;
                System.out.println("Elevator " + elevatorId + " is into waiting state....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void executeRequest(Request request) {
        int startFloor = currentFloor;
        int destinationFloor = request.getDestinationFloor();

        if (destinationFloor > startFloor) {
            this.elevatorState = ElevatorState.UP;

            for (int i = startFloor; i <= destinationFloor; i++) {
                try {
                    currentFloor = i;
                    System.out.println("Elevator " + elevatorId + " Reached floor " + currentFloor);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (startFloor > destinationFloor) {
            this.elevatorState = ElevatorState.DOWN;
            for (int i = startFloor; i >= destinationFloor; i--) {
                try {
                    currentFloor = i;
                    System.out.println("Elevator " + elevatorId + " Reached floor " + currentFloor);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void run() {
        processRequests();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
