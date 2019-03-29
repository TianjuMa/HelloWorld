package coding.Implementations;

import coding.HelperClass.ListNode;

/**
 * Created by matinaju on 4/21/17.
 */
public class StackByLinkedList {
    ListNode head;

    public StackByLinkedList() {
        head = null;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        head = head.next;
        /**
         * separate this element which need to be popped out from linked list.
         */
        prev.next = null;
        return prev.value;
    }

    public void push(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}
