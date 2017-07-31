package LaiOffer.Implementations;

/**
 * A simple implementation of MinHeap Class
 */
public class MyMinHeap {
    /**
     * the array containing all the elements in this heap.
     */
    private int[] array;

    /**
     * eager computation of the size of this heap.
     */
    private int size;

    /**
     * one constructor
     *
     * @param input array need to be heapified.
     */
    public MyMinHeap(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("The size of input array is invalid");
        }
        array = input;
        heapify();
        size = input.length;
    }

    /**
     * another constructor
     *
     * @param capacity take one capacity parameter.
     */
    public MyMinHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The input capacity is invalid");
        }
        array = new int[capacity];
        size = 0;
    }

    /**
     * push one element to this heap.
     *
     * @param value the target value.
     * @return whether is successful.
     */
    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        percolateUp(size - 1);
        return true;
    }

    /**
     * pop one element from this heap.
     *
     * @return deleted element.
     */
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int result = array[0];
        swap(array, 0, size - 1);
        size--;
        percolateDown(0);
        return result;
    }

    /**
     * return the top value in this heap.
     *
     * @return top value.
     */
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * update the value locating in target index.
     *
     * @param index    the target index.
     * @param newValue the new value to replace.
     * @return the old value.
     */
    public Integer update(int index, int newValue) {
        if (index >= size) {
            throw new IllegalArgumentException("the target index is invalid");
        }
        int oldValue = array[index];
        array[index] = newValue;
        if (oldValue > newValue) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return oldValue;
    }

    /**
     * detect whether the heap is full.
     *
     * @return boolean value.
     */
    public boolean isFull() {
        return size == array.length;
    }

    /**
     * detect whether the heap is empty.
     *
     * @return boolean value.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * the size of this heap.
     *
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * heapify the whole array.
     */
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * percolate down one element locating in the target index to the right location.
     *
     * @param index target index.
     */
    private void percolateDown(int index) {
        int swapCandidate;
        while (2 * index + 2 <= size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (rightChild < size && array[leftChild] > array[rightChild]) {
                swapCandidate = rightChild;
            } else {
                swapCandidate = leftChild;
            }
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
                index = swapCandidate;
            } else {
                break;
            }
        }
    }

    /**
     * percolate up one element locating in the target index to the right location.
     *
     * @param index target index.
     */
    private void percolateUp(int index) {
        while ((index - 1) / 2 >= 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(array, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    /**
     * helper function to swap two elements in this array.
     *
     * @param array target array.
     * @param left  one target index.
     * @param right the another target index.
     */
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}