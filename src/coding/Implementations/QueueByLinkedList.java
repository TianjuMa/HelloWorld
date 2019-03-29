package coding.Implementations;

import coding.HelperClass.ListNode;

/**
 * Created by matinaju on 4/21/17.
 */
public class QueueByLinkedList {
    ListNode head;
    ListNode tail;

    public QueueByLinkedList() {
        head = null;
        tail = null;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        head = head.next;
        /**
         * guarantee tail node is null if head node becomes null
         */
        if (head == null) {
            tail = null;
        }
        prev.next = null;
        return prev.value;
    }

    public void offer(int value) {
        ListNode newNode = new ListNode(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}
