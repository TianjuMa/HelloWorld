package test.unitTests.Implementations;

import coding.Implementations.MyHashMap;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * MyHashMap Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 1, 2017</pre>
 */
public class MyHashMapTest {
    MyHashMap<Integer, Integer> map;

    @Before
    public void before() throws Exception {
        map = new MyHashMap<>();
    }

    /**
     * Method: size()
     */
    @Test
    public void testSize1() throws Exception {
        assertEquals(0, map.size());
    }

    @Test
    public void testSize2() throws Exception {
        map.put(1, 1);
        assertEquals(1, map.size());
    }

    @Test
    public void testSize3() throws Exception {
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(2, map.size());
    }

    @Test
    public void testIsEmpty1() throws Exception {
        assertEquals(true, map.isEmpty());
    }

    @Test
    public void testIsEmpty2() throws Exception {
        map.put(1, 1);
        assertEquals(false, map.isEmpty());
    }

    @Test
    public void testClear() throws Exception {
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(2, map.size());
        map.clear();
        assertEquals(0, map.size());
        assertEquals(true, map.isEmpty());
    }

    @Test
    public void testPut() throws Exception {
        map.put(1, 1);
        map.put(2, 2);
        map.put(2, 3);
        assertEquals(2, map.size());
        assertEquals(2, (int) map.put(2, 4));
    }

    @Test
    public void testGet() throws Exception {
        map.put(1, 2);
        map.put(2, 3);
        assertEquals(2, (int) map.get(1));
        assertEquals(3, (int) map.get(2));
    }

    @Test
    public void testContainsKey() throws Exception {
        map.put(1, 2);
        map.put(2, 3);
        assertEquals(true, map.containsKey(1));
        assertEquals(true, map.containsKey(2));
        assertEquals(false, map.containsKey(3));
    }


    @Test
    public void testContainsValue() throws Exception {
        map.put(1, 2);
        map.put(2, 3);
        assertEquals(true, map.containsValue(2));
        assertEquals(true, map.containsValue(3));
        assertEquals(false, map.containsValue(4));
    }

    @Test
    public void testRemove() throws Exception {
        map.put(1, 2);
        map.put(2, 3);
        assertEquals(2, (int) map.remove(1));
        assertEquals(false, map.containsValue(2));
        assertEquals(true, map.containsValue(3));
        assertEquals(3, (int) map.remove(2));
        assertEquals(true, map.isEmpty());
    }
} 
