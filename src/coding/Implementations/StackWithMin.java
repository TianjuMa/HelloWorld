package coding.Implementations;

import java.util.*;

/**
 * Created by matinaju on 4/28/17.
 */
public class StackWithMin {
    private Deque<Integer> stack1;
    private Deque<Pair> minStack;

    private class Pair {
        int minValue;
        int firstOccurrence;

        public Pair(int min, int firstOccurrence) {
            this.minValue = min;
            this.firstOccurrence = firstOccurrence;
        }
    }

    public StackWithMin() {
        stack1 = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int element) {
        stack1.offerLast(element);
        if (minStack.isEmpty() || element < minStack.peekLast().minValue) {
            minStack.offerLast(new Pair(element, stack1.size() - 1));
        }
    }

    public Integer pop() {
        Integer result = null;
        if (stack1.isEmpty()) {
            return result;
        } else {
            result = stack1.peekLast();
            if (stack1.size() == minStack.peekLast().firstOccurrence + 1) {
                minStack.pollLast();
            }
            stack1.pollLast();
        }
        return result;
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        } else {
            return stack1.peekLast();
        }
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return null;
        } else {
            return minStack.peekLast().minValue;
        }
    }


}


