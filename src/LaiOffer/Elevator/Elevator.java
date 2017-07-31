package LaiOffer.Elevator;

import java.util.Queue;

/**
 * Created by matinaju on 6/27/17.
 */
public class Elevator {
    private static final int DEFAULT_ELEVATOR_MAX_CAPACITY = 14;
    private static final int DEFAULT_ELEVATOR_MAX_FLOOR = 10;
    private static final int DEFAULT_ELEVATOR_INITIAL_LOCATION = 1;
    private final int CAPACITY;
    private final int maxFloor;
    private int load;
    private int location;
    private boolean isGoingUp;
    /**
     * requests contains the number of request in each floor.
     */
    private int[] requests;

    public Elevator(int maxCapacity, int maxFloor) {
        CAPACITY = maxCapacity;
        this.maxFloor = maxFloor;
        load = 0;
        location = DEFAULT_ELEVATOR_INITIAL_LOCATION;
        isGoingUp = true;
        requests = new int[maxFloor];
    }

    public Elevator() {
        this(DEFAULT_ELEVATOR_MAX_CAPACITY, DEFAULT_ELEVATOR_MAX_FLOOR);
    }

    public boolean isEmpty() {
        return load == 0;
    }

    public boolean isFull() {
        return load >= CAPACITY;
    }

    public int getLocation() {
        return location;
    }

    public int move() {
        if (isGoingUp) {
            return location + 1 <= maxFloor ? ++location : location;
        } else {
            return location - 1 >= 0 ? --location : location;
        }
    }

    public boolean changeMovingDirection() {
        isGoingUp = !isGoingUp;
        return isGoingUp;
    }

    public int load(Queue<Integer> currQueue) {
//        while (!isFull()) {
//            requests[currQueue.poll()] += 1;
//            load++;
//        }
//        return currQueue.size();
        int newLoad = currQueue.size();
        if (load + newLoad > CAPACITY) {
            return 0;
        }
        for (Integer request : currQueue) {
            requests[request - 1] += 1;
        }
        load += newLoad;
        currQueue.clear();
        return newLoad;
    }

    public int unload() {
        int needToBeUnloaded = requests[location - 1];
        if (needToBeUnloaded > 0) {
            load -= needToBeUnloaded;
            requests[location - 1] = 0;
            return needToBeUnloaded;
        }
        return 0;
    }
}
