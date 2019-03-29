package test.unitTests.SortingAlgorithms;

import coding.HelperClass.ListNode;
import coding.SortingAlgorithms.MergeSort;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * MergeSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 30, 2017</pre>
 */
public class MergeSortTest {
    MergeSort ms;

    @Before
    public void before() throws Exception {
        ms = new MergeSort();
    }

    /**
     * Method: mergeSort(int[] input)
     */
    @Test
    public void testMergeSort2() {
        int[] array = new int[]{};
        assertArrayEquals(array, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort3() {
        int[] array = new int[]{1};
        assertArrayEquals(array, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort4() {
        int[] array = new int[]{1, 2};
        assertArrayEquals(array, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort5() {
        int[] array = new int[]{1, 3, 2};
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort6() {
        int[] array = new int[]{1, 1, 3, 2};
        int[] expected = new int[]{1, 1, 2, 3};
        assertArrayEquals(expected, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort7() {
        int[] array = new int[]{1, 1, 1, 1};
        int[] expected = new int[]{1, 1, 1, 1};
        assertArrayEquals(expected, ms.mergeSort(array));
    }

    @Test
    public void testMergeSort8() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node3.next = node2;
        node2.next = node4;
        node4.next = node1;
        node1.next = node5;
        assertEquals("1->2->3->4->5", ms.mergeSort(node3).toString());
    }
} 
