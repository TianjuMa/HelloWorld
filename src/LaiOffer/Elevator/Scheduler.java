package LaiOffer.Elevator;

import java.util.List;
import java.util.Queue;

/**
 * Created by matinaju on 6/27/17.
 */
public interface Scheduler {
    void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors);
}
