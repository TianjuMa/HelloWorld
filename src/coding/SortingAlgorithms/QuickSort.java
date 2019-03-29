package coding.SortingAlgorithms;

import coding.HelperClass.ListNode;

/**
 * one implementation of quick sort.
 */
public class QuickSort {
    public int[] quickSort(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        quickSort(input, 0, input.length - 1);
        return input;
    }

    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return quickSort(head, tail);
    }

    private void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (int) (Math.random() * (right - left));
        int pivotPosition = reOrder(input, left, right, pivotIndex);
        quickSort(input, left, pivotPosition - 1);
        quickSort(input, pivotPosition + 1, right);
    }

    private int reOrder(int[] input, int left, int right, int pivotIndex) {
        int pivotValue = input[pivotIndex];
        swap(input, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (input[leftBound] < pivotValue) {
                leftBound++;
            } else if (input[rightBound] > pivotValue) {
                rightBound--;
            } else {
                swap(input, leftBound++, rightBound--);
            }
        }
        swap(input, right, leftBound);
        return leftBound;
    }

    private void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        if (head.value > tail.value) {
            int temp = tail.value;
            tail.value = head.value;
            head.value = temp;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        ListNode newTail = tail;
        while (cur != tail) {
            if (cur.value > tail.value) {
                prev.next = cur.next;
                tail.next = cur;
                newTail = tail.next;
                cur.next = null;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        ListNode leftHead = quickSort(head, prev);
        ListNode rightHead = quickSort(tail, newTail);
        return combine(leftHead, rightHead);
    }

    private ListNode combine(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        ListNode result = new ListNode(0);
        if (leftHead.value <= rightHead.value) {
            result.value = leftHead.value;
            result.next = combine(leftHead.next, rightHead);
        } else {
            result.value = rightHead.value;
            result.next = combine(leftHead, rightHead.next);
        }
        return result;
    }
}