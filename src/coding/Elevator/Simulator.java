package coding.Elevator;

import java.util.*;

/**
 * Created by matinaju on 6/27/17.
 */
public class Simulator {
    private final int maxFloors;
    private List<Queue<Integer>> requests;
    private List<Elevator> elevators;
    private Scheduler scheduler;

    public Simulator(int floors, int numElevators, List<Queue<Integer>> initRequest, Scheduler scheduler, int elevatorCapacity) {
        maxFloors = floors;
        requests = initRequest;
        this.scheduler = scheduler;
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            Elevator e = new Elevator(elevatorCapacity, floors);
            elevators.add(e);
        }
    }

    private void generateRequest() {

    }

    private void schedule() {
        scheduler.schedule(requests, elevators, maxFloors);
    }

    private void elevatorMoving() {
        for (Elevator e : elevators) {
            if (!e.isEmpty()) {
                e.unload();
            }
            if (!e.isFull()) {
                int location = e.getLocation();
                e.load(requests.get(location - 1));
            }
            e.move();
        }
    }

    public void simulate(int step) throws InterruptedException {
        for (int i = 0; i < step; i++) {
            System.out.println("Step" + i);
            generateRequest();
            schedule();
            elevatorMoving();
            Thread.sleep(10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int floors = 10;
        int numElevator = 1;
        List<Queue<Integer>> initRequest = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < floors; i++) {
            Queue<Integer> curQueue = new LinkedList<>();
            int req = generator.nextInt(10);
            curQueue.offer(req);
            initRequest.add(curQueue);
        }
        Scheduler mySimpleScheduler = new SimpleScheduler();
        Simulator mySimulator = new Simulator(floors, numElevator, initRequest, mySimpleScheduler, 14);
        mySimulator.simulate(5);
    }
}
