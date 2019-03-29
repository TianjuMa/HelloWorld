package LaiOffer.Implementations;

import java.util.*;

/**
 * Created by matinaju on 4/28/17.
 */
public class DequeByStacks {
    private static Deque<Integer> first;
    private static Deque<Integer> last;
    private static Deque<Integer> buffer;

    public DequeByStacks() {
        first = new ArrayDeque<>();
        last = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int target) {
        first.offerFirst(target);
    }

    public void offerLast(int target) {
        last.offerLast(target);
    }

    public Integer pollFirst() {
        if (first.isEmpty() && last.isEmpty()) {
            return null;
        } else if (!first.isEmpty()) {
            return first.pollFirst();
        } else {
            helperFirstEmpty(first, last, buffer);
            return first.pollFirst();
        }
    }

    public Integer pollLast() {
        if (first.isEmpty() && last.isEmpty()) {
            return null;
        } else if(!last.isEmpty()) {
            return last.pollLast();
        } else {
            helperLastEmpty(first, last, buffer);
            return last.pollLast();
        }
    }

    private void helperFirstEmpty(Deque<Integer> first, Deque<Integer> last, Deque<Integer> buffer) {
        int size = last.size();
        for (int i = 0; i < size / 2; i++) {
            buffer.offerLast(last.pollLast());
        }
        while (!last.isEmpty()) {
            first.offerFirst(last.pollLast());
        }
        while (!buffer.isEmpty()) {
            last.offerLast(buffer.pollLast());
        }
    }

    private void helperLastEmpty(Deque<Integer> first, Deque<Integer> last, Deque<Integer> buffer) {
        int size = first.size();
        for(int i = 0; i < size / 2; i++) {
            buffer.offerLast(first.pollFirst());
        }
        while(!first.isEmpty()) {
            last.offerLast(first.pollFirst());
        }
        while(!buffer.isEmpty()) {
            first.offerFirst(buffer.pollLast());
        }
    }
}
