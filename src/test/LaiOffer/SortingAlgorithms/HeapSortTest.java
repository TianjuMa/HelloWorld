package test.LaiOffer.SortingAlgorithms;

import LaiOffer.SortingAlgorithms.HeapSort;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * HeapSort Tester.
 *
 * @author Tianju Ma
 * @version 1.0
 * @since <pre>Jun 28, 2017</pre>
 */
public class HeapSortTest {
    HeapSort hs;

    @Before
    public void before() throws Exception {
        hs = new HeapSort();
    }

    @Test
    public void testHeapSort1() throws Exception {
        assertArrayEquals(null, hs.heapSort(null));
    }

    @Test
    public void testHeapSort2() throws Exception {
        int[] array = {};
        assertArrayEquals(array, hs.heapSort(array));
    }

    @Test
    public void testHeapSort3() throws Exception {
        int[] array = {1};
        assertArrayEquals(array, hs.heapSort(array));
    }

    @Test
    public void testHeapSort4() throws Exception {
        int[] array = {1, 3, 2};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, hs.heapSort(array));
    }


    @Test
    public void testHeapSort5() throws Exception {
        int[] array = {1, 3, 2, 0};
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, hs.heapSort(array));
    }

    @Test
    public void testHeapSort6() throws Exception {
        int[] array = {0, 1, 1, 3};
        int[] expected = {0, 1, 1, 3};
        assertArrayEquals(expected, hs.heapSort(array));
    }

    @Test
    public void testHeapSort7() throws Exception {
        int[] array = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, hs.heapSort(array));
    }

    @Test
    public void testHeapSort8() throws Exception {
        int[] array = {1, 0};
        int[] expected = {0, 1};
        assertArrayEquals(expected, hs.heapSort(array));
    }

} 
