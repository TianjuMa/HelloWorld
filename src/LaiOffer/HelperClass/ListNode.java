package LaiOffer.HelperClass;

import java.util.List;

/**
 * Created by matinaju on 4/20/17.
 */
public class ListNode {
    public int value;
    public ListNode next;
//    ListNode prev;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }

    public static ListNode generateList(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : array) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.value);
            sb.append("->");
            cur = cur.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public ListNode reverseLinkedListI(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedListI(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseLinkedListII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode cur = head;
        int count = k;
        while (cur != null) {
            if (count == 1) {
                ListNode next = cur.next;
                ListNode newHead = reverseKGroupHelper(head, cur);
                head.next = reverseKGroup(next, k);
                return newHead;
            } else {
                count--;
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode reverseKGroupHelper(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }
}
