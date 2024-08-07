package solutions.elevatorsystem;

public class ElevatorSystemDemo {

    public static void run() {
        ElevatorFinder elevatorFinder = new ElevatorFinderImpl();
        ElevatorController controller = new ElevatorController(3, 5, elevatorFinder);

        controller.requestElevator(5, 10);
        controller.requestElevator(3, 7);
        controller.requestElevator(8, 2);
        controller.requestElevator(1, 9);


    }
}
