package coding.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

/**
 * An Implementation of Bucket Sort Algorithm.
 */
public class BucketSort {
    public static double[] bucketSort(double[] array, double lowerBound, double upperBound) {
        List<List<Double>> buckets = new ArrayList<>();
        for (double ignored : array) {
            buckets.add(new ArrayList<>());
        }
        for (double d : array) {
            int index = (int) ((d - lowerBound) / (upperBound - lowerBound));
            buckets.get(index).add(d);
        }
        // how to choose sort method: if the list for every bucket is larger than 30, we should choose merge sort.
        // On the contrary, we should choose to use selection sort, because it's more efficient than merge sort in practice.
        // as if the time complexity of merge sort is better than selection sort.
        for (List<Double> l : buckets) {
            if (array.length > 30) {
                Collections.sort(l);
            } else {
                selectionSort(l);
            }
        }
        int end = 0;
        for (List<Double> list : buckets) {
            for (Double d : list) {
                array[end++] = d;
            }
        }
        return array;
    }

    private static void selectionSort(List<Double> list) {
        int localMin;
        int swapCandidate;
        for (int i = 0; i < list.size(); i++) {
            localMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                swapCandidate = list.get(j) < list.get(localMin) ? j : localMin;
                swap(list, localMin, swapCandidate);
            }
        }
    }
}
