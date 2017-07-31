package LaiOffer.Implementations;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by matinaju on 6/9/17.
 */
public class QueueByTwoStacks {
    Deque<Integer> in;
    Deque<Integer> out;

    public QueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public void offer(int element) {
        in.offerLast(element);
    }

    public Integer poll() {
        move();
        return out.pollLast();
    }

    public Integer peek() {
        move();
        return out.peekLast();
    }

    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerLast(in.pollLast());
            }
        }
    }
}
