package test.LaiOffer.SortingAlgorithms;

import LaiOffer.HelperClass.ListNode;
import LaiOffer.SortingAlgorithms.MergeSort;
import LaiOffer.SortingAlgorithms.QuickSort;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * QuickSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 30, 2017</pre>
 */
public class QuickSortTest {
    QuickSort qs;

    @Before
    public void before() throws Exception {
        qs = new QuickSort();
    }

    @Test
    public void testQuickSort2() {
        int[] array = new int[]{};
        assertArrayEquals(array, qs.quickSort(array));
    }

    @Test
    public void testQuickSort3() {
        int[] array = new int[]{1};
        assertArrayEquals(array, qs.quickSort(array));
    }

    @Test
    public void testQuickSort4() {
        int[] array = new int[]{1, 2};
        assertArrayEquals(array, qs.quickSort(array));
    }

    @Test
    public void testQuickSort5() {
        int[] array = new int[]{1, 3, 2};
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, qs.quickSort(array));
    }

    @Test
    public void testQuickSort6() {
        int[] array = new int[]{1, 1, 3, 2};
        int[] expected = new int[]{1, 1, 2, 3};
        assertArrayEquals(expected, qs.quickSort(array));
    }

    @Test
    public void testQuickSort7() {
        int[] array = new int[]{1, 1, 1, 1};
        int[] expected = new int[]{1, 1, 1, 1};
        assertArrayEquals(expected, qs.quickSort(array));
    }

    @Test
    public void testQuickSort8() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node3.next = node2;
        node2.next = node4;
        node4.next = node1;
        node1.next = node5;
        assertEquals("1->2->3->4->5", qs.quickSort(node3).toString());
    }
} 
