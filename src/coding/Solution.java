package coding;

import java.util.*;

/**
 * Solution class for coding practice.
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long[] helper = new long[nums.length + 1];
        return mergeSort(sum, helper, 0, nums.length, lower, upper);
    }

    private int mergeSort(long[] sum, long[] helper, int left, int right, int lower, int upper) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int result = mergeSort(sum, helper, left, mid, lower, upper) + mergeSort(sum, helper, mid + 1, right, lower, upper);
        int lowBound = mid + 1;
        int upperBound = mid + 1;
        int index = left;
        int rightIndex = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (upperBound <= right && sum[upperBound] - sum[i] <= upper) {
                upperBound++;
            }
            while (lowBound <= right && sum[lowBound] - sum[i] < lower) {
                lowBound++;
            }
            while (rightIndex <= right && sum[rightIndex] < sum[i]) {
                helper[index++] = sum[rightIndex++];
            }
            helper[index++] = sum[i];
            result += upperBound - lowBound;
        }
        while (rightIndex <= right) {
            helper[index++] = sum[rightIndex++];
        }
        System.arraycopy(helper, left, sum, left, right + 1 - left);
        return result;
    }
}