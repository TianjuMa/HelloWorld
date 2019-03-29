package coding.MyIterators;

import java.util.Iterator;

/**
 * Implementation of one iterator, which can iterate all elements in an integer array.
 */
public class ArrayIterator implements Iterator<Integer> {
    /**
     * index indicates the next position to be inspect.
     */
    int index;

    /**
     * an array buffer to hold the input array.
     */
    int[] array;

    public ArrayIterator(int[] array) {
        index = 0;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index++];
    }
}
