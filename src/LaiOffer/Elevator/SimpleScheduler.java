package LaiOffer.Elevator;

import java.util.List;
import java.util.Queue;

/**
 * Created by matinaju on 6/27/17.
 */
public class SimpleScheduler implements Scheduler {
    @Override
    public void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors) {
        for (Elevator e : elevators) {
            if (e.getLocation() == 0 || e.getLocation() == floors) {
                e.changeMovingDirection();
            }
        }
    }
}
