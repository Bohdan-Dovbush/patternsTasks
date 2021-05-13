package Collection.map;

import Collection.Util.ReversedComparator;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class TreeMapTest extends TestCase {

    TreeMap tm;
    final Object[] objArray = new Object[1000];

    @BeforeEach
    protected void setUp() {
        tm = new TreeMap();
        for (int i = 0; i < objArray.length; i++) {
            Object x = objArray[i] = i;
            tm.put(x.toString(), x);
        }
    }

    @Test
    public void testComparator() {
        Integer i = 1;
        Integer j = 2;
        Comparator comp = new ReversedComparator();
        TreeMap reversedTreeMap = new TreeMap(comp);
        assertSame("TreeMap answered incorrect comparator", reversedTreeMap.comparator(), comp);
        reversedTreeMap.put(i.toString(), i);
        reversedTreeMap.put(j.toString(), j);
        assertEquals("TreeMap does not use comparator (firstKey was incorrect)",
                reversedTreeMap.firstKey(), j.toString());
        assertEquals("TreeMap does not use comparator (lastKey was incorrect)",
                reversedTreeMap.lastKey(), i.toString());
    }

    @Test
    public void test_clear() {
        tm.clear();
        assertEquals("Cleared map returned non-zero size", 0, tm.size());
    }

    @Test
    public void testClone() {
        TreeMap clonedMap = (TreeMap) tm.clone();
        assertEquals("Cloned map does not equal the original map", clonedMap, tm);
        assertNotSame("Cloned map is the same reference as the original map", clonedMap, tm);
        for (Object element : objArray) {
            assertSame("Cloned map contains incorrect elements", clonedMap
                    .get(element.toString()), tm.get(element.toString()));
        }
        TreeMap map = new TreeMap();
        map.put("key", "value");
        // get the keySet() and values() on the original Map
        Set keys = map.keySet();
        Collection values = map.values();
        assertEquals("values() does not work", "value", values.iterator().next());
        assertEquals("keySet() does not work", "key", keys.iterator().next());
        AbstractMap map2 = (AbstractMap) map.clone();
        map2.put("key", "value2");
        Collection values2 = map2.values();
        assertNotSame("values() is identical", values2, values);
        // values() and keySet() on the cloned() map should be different
        assertEquals("values() was not cloned", "value2", values2.iterator().next());
        map2.clear();
        map2.put("key2", "value3");
        Set key2 = map2.keySet();
        assertNotSame("keySet() is identical", key2, keys);
        assertEquals("keySet() was not cloned", "key2", key2.iterator().next());
    }

    @Test
    public void testContainsKey() {
        assertTrue("Returned false for valid key", tm.containsKey("95"));
        assertFalse("Returned true for invalid key", tm.containsKey("XXXXX"));
    }

    @Test
    public void testContainsValue() {
        assertTrue("Returned false for valid value", tm.containsValue(objArray[986]));
        assertFalse("Returned true for invalid value", tm.containsValue(new Object()));
    }

    @Test
    public void testEntrySet() {
        Set anEntrySet = tm.entrySet();
        Iterator entrySetIterator = anEntrySet.iterator();
        assertEquals("EntrySet is incorrect size", anEntrySet.size(), objArray.length);
        Map.Entry entry;
        while (entrySetIterator.hasNext()) {
            entry = (Map.Entry) entrySetIterator.next();
            assertSame("EntrySet does not contain correct mappings", tm
                    .get(entry.getKey()), entry.getValue());
        }
    }

    @Test
    public void testFirstKey() {
        assertEquals("Returned incorrect first key", "0", tm.firstKey());
    }

    @Test
    public void testLastKey() {
        assertEquals("Returned incorrect last key", tm.lastKey(), objArray[objArray.length - 1].toString());
        assertNotSame(objArray[objArray.length - 1].toString(), tm.lastKey());
        assertEquals(objArray[objArray.length - 2].toString(), tm.headMap("999").lastKey());
        assertEquals(objArray[objArray.length - 1].toString(), tm.tailMap("123").lastKey());
        assertEquals(objArray[objArray.length - 2].toString(), tm.subMap("99", "999").lastKey());
    }

    @Test
    public void testGet() {
        Object o = new Object();
        tm.put("Hello", o);
        assertSame("Failed to get mapping", tm.get("Hello"), o);
        // Test for the same key & same value
        tm = new TreeMap();
        Object o2 = new Object();
        Integer key1 = 1;
        Integer key2 = 2;
        assertNull(tm.put(key1, o));
        assertNull(tm.put(key2, o));
        assertEquals(2, tm.values().size());
        assertEquals(2, tm.keySet().size());
        assertSame(tm.get(key1), tm.get(key2));
        assertSame(o, tm.put(key1, o2));
        assertSame(o2, tm.get(key1));
    }

    @Test
    public void testHeadMap() {
        Map head = tm.headMap("100");
        assertEquals("Returned map of incorrect size", 3, head.size());
        assertTrue("Returned incorrect elements", head.containsKey("0")
                && head.containsValue(1)
                && head.containsKey("10"));
        TreeMap<Integer, Double> map = new TreeMap<>();
        map.put(1, 2.1);
        map.put(2, 3.1);
        map.put(3, 4.5);
        map.put(7, 21.3);
        map.put(null, null);
        SortedMap<Integer, Double> smap = map.headMap(null);
        assertEquals(0, smap.size());
        Set<Integer> keySet = smap.keySet();
        assertEquals(0, keySet.size());
        Set<Map.Entry<Integer, Double>> entrySet = smap.entrySet();
        assertEquals(0, entrySet.size());
        Collection<Double> valueCollection = smap.values();
        assertEquals(0, valueCollection.size());
        SortedMap<Integer, Integer> intMap, sub;
        int size = 16;
        intMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            intMap.put(i, i);
        }
        sub = intMap.headMap(-1);
        assertEquals("size should be zero", sub.size(), 0);
        assertTrue("submap should be empty", sub.isEmpty());
        try {
            sub.firstKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        TreeMap t = new TreeMap();
        try {
            SortedMap th = t.headMap(null);
            assertNull(th);
            fail("Should throw a NullPointerException");
        } catch (NullPointerException npe) {
            // expected
        }
        try {
            sub.lastKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        size = 256;
        intMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            intMap.put(i, i);
        }
        sub = intMap.headMap(-1);
        assertEquals("size should be zero", sub.size(), 0);
        assertTrue("submap should be empty", sub.isEmpty());
        try {
            sub.firstKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        try {
            sub.lastKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
    }

    @Test
    public void testTailMap() {
        Map tail = tm.tailMap(objArray[900].toString());
        assertEquals("Returned map of incorrect size : " + tail.size(), tail
                .size(), (objArray.length - 900) + 9);
        for (int i = 900; i < objArray.length; i++) {
            assertTrue("Map contains incorrect entries", tail.containsValue(objArray[i]));
        }
        SortedMap<Integer, Integer> intMap, sub;
        int size = 16;
        intMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            intMap.put(i, i);
        }
        sub = intMap.tailMap(size);
        assertEquals("size should be zero", sub.size(), 0);
        assertTrue("submap should be empty", sub.isEmpty());
        try {
            sub.firstKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        TreeMap t = new TreeMap();
        try {
            SortedMap th = t.tailMap(null);
            assertNull(th);
            fail("Should throw a NullPointerException");
        } catch (NullPointerException npe) {
            // expected
        }
        try {
            sub.lastKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        size = 256;
        intMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            intMap.put(i, i);
        }
        sub = intMap.tailMap(size);
        assertEquals("size should be zero", sub.size(), 0);
        assertTrue("submap should be empty", sub.isEmpty());
        try {
            sub.firstKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
        try {
            sub.lastKey();
            fail("java.util.NoSuchElementException should be thrown");
        } catch (java.util.NoSuchElementException e) {//
        }
    }

    @Test
    public void testPutAll() {
        TreeMap x = new TreeMap();
        x.putAll(tm);
        assertEquals("Map incorrect size after put", x.size(), tm.size());
        for (Object element : objArray) {
            assertEquals("Failed to put all elements", x.get(element.toString()), element);
        }
    }

    @Test
    public void testRemove() {
        tm.remove("990");
        assertFalse("Failed to remove mapping", tm.containsKey("990"));
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size", 1000, tm.size());
        assertEquals("Returned incorrect size", 447, tm.headMap("500").size());
        assertEquals("Returned incorrect size", 1000, tm.headMap("null").size());
        assertEquals("Returned incorrect size", 0, tm.headMap("").size());
        assertEquals("Returned incorrect size", 448, tm.headMap("500a").size());
        assertEquals("Returned incorrect size", 553, tm.tailMap("500").size());
        assertEquals("Returned incorrect size", 0, tm.tailMap("null").size());
        assertEquals("Returned incorrect size", 1000, tm.tailMap("").size());
        assertEquals("Returned incorrect size", 552, tm.tailMap("500a").size());
        assertEquals("Returned incorrect size", 111, tm.subMap("500", "600").size());
        try {
            tm.subMap("null", "600");
            fail("Should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
        assertEquals("Returned incorrect size", 1000, tm.subMap("", "null").size());
    }

    @Test
    public void testInvalidKeys() {
        TreeMap m1 = new TreeMap();
        try {
            m1.put(new Object(), "val1");
            fail("ClassCastException expected");
        } catch (ClassCastException expected) {
        }
    }

    @Test
    public void testEquals() {
        Map m1 = new TreeMap();
        Map m2 = new TreeMap();
        m1.put("key1", "val1");
        m1.put("key2", "val2");
        m2.put(1, "val1");
        m2.put(2, "val2");
        assertNotEquals("Maps should not be equal 1", m1, m2);
        assertNotEquals("Maps should not be equal 2", m2, m1);
        // comparing TreeMap with HashMap
        m1 = new TreeMap();
        m2 = new HashMap();
        m1.put("key", "val");
        m2.put(new Object(), "val");
        assertNotEquals("Maps should not be equal 3", m1, m2);
        assertNotEquals("Maps should not be equal 4", m2, m1);
    }

    @Test
    public void testSubMapIterator() {
        TreeMap<String, String> map = new TreeMap<>();
        String[] keys = { "1", "2", "3" };
        String[] values = { "one", "two", "three" };
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        assertEquals(3, map.size());
        Map subMap = map.subMap("", "test");
        assertEquals(3, subMap.size());
        Set entrySet = subMap.entrySet();
        Iterator iter = entrySet.iterator();
        int size = 0;
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
            assertTrue(map.containsKey(entry.getKey()));
            assertTrue(map.containsValue(entry.getValue()));
            size++;
        }
        assertEquals(map.size(), size);
        Set<String> keySet = subMap.keySet();
        iter = keySet.iterator();
        size = 0;
        while (iter.hasNext()) {
            String key = (String) iter.next();
            assertTrue(map.containsKey(key));
            size++;
        }
        assertEquals(map.size(), size);
    }

    @Test
    public void testValues() {
        Collection vals = tm.values();
        vals.iterator();
        assertEquals("Returned collection of incorrect size", vals.size(), objArray.length);
        for (Object element : objArray) {
            assertTrue("Collection contains incorrect elements", vals.contains(element));
        }
        assertEquals(1000, vals.size());
        int j = 0;
        for (Object ignored : vals) {
            j++;
        }
        assertEquals(1000, j);
        vals = tm.descendingMap().values();
        vals.iterator();
        assertEquals("Returned collection of incorrect size", vals.size(), objArray.length);
        for (Object element : objArray) {
            assertTrue("Collection contains incorrect elements", vals.contains(element));
        }
        assertEquals(1000, vals.size());
        j = 0;
        for (Object ignored : vals) {
            j++;
        }
        assertEquals(1000, j);
        TreeMap myTreeMap = new TreeMap();
        for (int i = 0; i < 100; i++) {
            myTreeMap.put(objArray[i], objArray[i]);
        }
    }
}
