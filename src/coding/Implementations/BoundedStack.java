package coding.Implementations;

/**
 * Created by matinaju on 4/21/17.
 */
public class BoundedStack {
    int[] array;
    int head;

    public BoundedStack(int capacity) {
        if (capacity <= 1) {
            return;
        }
        array = new int[capacity];
        head = -1;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }

    public boolean push(int value) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = value;
        return true;
    }

    public Integer top() {
        return head == -1 ? null : array[head];
    }
}
