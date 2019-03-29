package coding.SortingAlgorithms;

/**
 * one implementation of heap sort.
 */
public class HeapSort {
    public int[] heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        heapify(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            percolateDown(array, 0, i - 1);
        }
        return array;
    }

    private void heapify(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length - 1);
        }
    }

    private void percolateDown(int[] array, int left, int right) {
        int next;
        while (left <= (right - 1) / 2) {
            int leftChild = 2 * left + 1;
            int rightChild = 2 * left + 2;
            if (rightChild <= right && array[leftChild] < array[rightChild]) {
                next = rightChild;
            } else {
                next = leftChild;
            }
            if (next <= right && array[left] < array[next]) {
                swap(array, left, next);
                left = next;
            } else {
                break;
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}