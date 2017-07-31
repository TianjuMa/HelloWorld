package LaiOffer.SortingAlgorithms;

import java.util.PriorityQueue;

/**
 * An implementation of K Sorted Sorting Algorithm. This algorithm is used for a roughly sorted array:
 * A roughly sorted array is an array with n elements, where each element is at most K away from its
 * target position. And K is a given parameter.
 */
public class KSortedSort {
    /**
     * Naive version of this algorithm. this algorithm is based on selection sort, the only
     * difference is that we just need to scan K elements behind the current position.
     * Time Complexity: T(n) = O(nK)
     * Space Complexity: S(n) = O(1)
     *
     * @param array the input array.
     * @param K     the position parameter.
     * @return the sorted array.
     */
    public static int[] kSortedSortI(int[] array, int K) {
        for (int i = 0; i < array.length; i++) {
            int localMin = i;
            for (int j = i + 1; j <= Math.min(i + K, array.length - 1); j++) {
                if (array[j] < array[localMin]) {
                    swap(array, localMin, j);
                }
            }
        }
        return array;
    }

    /**
     * Optimized version: for naive version, if K have same degree of n, the algorithm is slower than merge sort.
     * In this case, we want to revised the previous algorithm. In this implementation, we use a min heap inside
     * every sliding window with K size from the current position. Pop one element every time, and this element is
     * the right element of current position.
     * Time Complexity: T(n) = O(K * logK + n * logK) = O(n logK)   which equals to merge sort's T(n) at worst case.
     * Space Complexity: S(n) = O(K), which equals to merge sort's S(n) at worst case.
     *
     * @param array the input array.
     * @param K     the position parameter.
     * @return the sorted array.
     */
    public static int[] kSortedSortII(int[] array, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= Math.min(K, array.length - 1); i++) {
            minHeap.offer(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = minHeap.poll();
            if (i + K + 1 < array.length) {
                minHeap.offer(array[i + K + 1]);
            }
        }
        return array;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
