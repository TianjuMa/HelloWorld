package LaiOffer.SortingAlgorithms;

import LaiOffer.HelperClass.ListNode;

/**
 * one implementation of merge sort.
 */
public class MergeSort {
    public static int[] mergeSort(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int[] helper = new int[input.length];
        mergeSort(input, 0, input.length - 1, helper);
        return input;
    }

    private static void mergeSort(int[] input, int left, int right, int[] helper) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(input, left, mid, helper);
        mergeSort(input, mid + 1, right, helper);
        combine(input, left, mid, right, helper);
    }

    private static void combine(int[] input, int leftBound, int mid, int rightBound, int[] helper) {
        System.arraycopy(input, leftBound, helper, leftBound, rightBound + 1 - leftBound);
        int leftIndex = leftBound;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= rightBound) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                input[leftBound++] = helper[leftIndex++];
            } else {
                input[leftBound++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            input[leftBound++] = helper[leftIndex++];
        }
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMid(head);
        ListNode nextOfMid = midNode.next;
        midNode.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(nextOfMid);
        return combine(leftHead, rightHead);
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode combine(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        ListNode newHead = new ListNode(1);
        if (leftHead.value <= rightHead.value) {
            newHead.value = leftHead.value;
            newHead.next = combine(leftHead.next, rightHead);
        } else {
            newHead.value = rightHead.value;
            newHead.next = combine(leftHead, rightHead.next);
        }
        return newHead;
    }
}