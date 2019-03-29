package coding.Implementations;

/**
 * Created by matinaju on 4/21/17.
 */
public class BoundedQueue {
    int[] array;
    /**
     * head points to the next element can be poll out from queue.
     */
    int head;
    /**
     * tail point to the next available position to put element.
     */
    int tail;
    int size;

    public BoundedQueue(int capacity) {
        array = new int[capacity];
        head = tail = 0;
        size = 0;
    }

    /**
     * tail is next available position, so assign value first, then increase tail.
     */
    public boolean offer(int value) {
        if (size == array.length) {
            return false;
        }

        array[tail] = value;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        size++;
        return true;
    }

    /**
     * head is next element to be polled out, so assign array[head] to result first, then move head to next position.
     */
    public Integer poll() {
        if (size == 0) {
            return null;
        }

        int result = array[head];
        size--;
        head = head + 1 == array.length ? 0 : head + 1;
        return result;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
