package coding.SortingAlgorithms;

/**
 * one implementation of selection sort.
 */
public class SelectionSort {
    public static int[] selectionSort(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int globalMin;
        for (int i = 0; i < input.length; i++) {
            globalMin = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[globalMin]) {
                    globalMin = j;
                }
            }
            swap(input, i, globalMin);
        }
        return input;
    }

    private static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}