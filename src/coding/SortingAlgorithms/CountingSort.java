package LaiOffer.SortingAlgorithms;

/**
 * An implementation of counting sort algorithm. This algorithm is
 * to sort an array, which contains values with a specific range.
 */
public class CountingSort {
    /**
     * main method to implement this algorithm.
     *
     * @param input      the input array.
     * @param lowerBound the lower bound of the values' range in the input array.
     * @param upperBound the upper bound of the values' range in the input array.
     * @return the sorted array.
     */
    public static int[] countingSort(int[] input, int lowerBound, int upperBound) {
        int[] count = new int[upperBound - lowerBound + 1];
        for (int i : input) {
            count[i - lowerBound]++;
        }
        int end = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                input[end++] = i + lowerBound;
                count[i]--;
            }
        }
        return input;
    }
}