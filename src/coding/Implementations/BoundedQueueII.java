package coding.Implementations;

/**
 * Created by matinaju on 6/27/17.
 */
public class BoundedQueueII {
    private int[] array;
    private int head;
    private int tail;

    public BoundedQueueII(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        array = new int[capacity + 1];
        head = 0;
        tail = 1;
    }

    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        if (head > tail) {
            if (tail != 0 && tail != 1) {
                array[tail] = value;
                tail = tail + 1 == array.length ? 0 : tail + 1;
            } else {
                if (head == 1 || head == 2) {
                    tail = 1;
                } else {
                    tail = 2;
                }
                array[1] = value;
            }
        } else {
            array[tail] = value;
            tail = tail + 1 == array.length ? 0 : tail + 1;
        }
        return true;
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int result;
        if (head == array.length - 1) {
            if (tail > 1) {
                result = array[1];
            } else {
                return null;
            }
        } else {
            result = array[head + 1];
        }
        head = head + 1 == array.length ? 0 : head + 1;
        return result;
    }

    public Integer peek() {
        return head + 1 == array.length ? array[1] : array[head + 1];
    }

    public int size() {
//        if (isFull()) {
//            return array.length - 1;
//        } else if (isEmpty()) {
//            return 0;
//        } else {
//            return
//        }
        if (head < tail) {
            return tail - head - 1;
        } else if (head == tail) {
            return array.length - 1;
        } else {
            return tail - head;
        }
    }

    public boolean isFull() {
        return tail == head;
    }

    public boolean isEmpty() {
        return head + 1 == tail;
    }
}
