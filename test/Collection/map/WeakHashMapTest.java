package Collection.map;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WeakHashMapTest extends TestCase {

    Object[] keyArray = new Object[100];
    Object[] valueArray = new Object[100];
    WeakHashMap<Object, Object> whm;

    @BeforeEach
    public void setUp() {
        whm = new WeakHashMap<>();
        for (int i = 0; i < 100; i++) {
            keyArray[i] = new Object();
            valueArray[i] = new Object();
        }
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 100; i++)
            whm.put(keyArray[i], valueArray[i]);
        whm.clear();
        assertTrue("Cleared map should be empty", whm.isEmpty());
        for (int i = 0; i < 100; i++)
            assertNull("Cleared map should only return null", whm.get(keyArray[i]));
    }

    @Test
    public void testEntrySet() {
        for (int i = 0; i < 100; i++)
            whm.put(keyArray[i], valueArray[i]);
        List keys = Arrays.asList(keyArray);
        List values = Arrays.asList(valueArray);
        Set<Map.Entry<Object, Object>> entrySet = whm.entrySet();
        assertEquals("Incorrect number of entries returned--wanted 100, got: "
                + entrySet.size(), 100, entrySet.size());
        for (Map.Entry<Object, Object> entry : entrySet) {
            assertTrue("Invalid map entry returned--bad key", keys
                    .contains(entry.getKey()));
            assertTrue("Invalid map entry returned--bad key", values
                    .contains(entry.getValue()));
        }

        keyArray[50] = null;
        int count = 0;
        do {
            System.gc();
            System.gc();
            count++;
        } while (count <= 5 && entrySet.size() == 100);
        assertEquals("Incorrect number of entries returned after gc--wanted 99, got: "
                + entrySet.size(), 99, entrySet.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("New map should be empty", whm.isEmpty());
        Object myObject = new Object();
        whm.put(myObject, myObject);
        assertFalse("Map should not be empty", whm.isEmpty());
        whm.remove(myObject);
        assertTrue("Map with elements removed should be empty", whm.isEmpty());
    }

    @Test
    public void testPut() {
        whm.put(null, "value"); // add null key
        System.gc();
        System.gc();
        whm.remove("nothing"); // Cause objects in queue to be removed
        assertEquals("null key was removed", 1, whm.size());
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 100; i++)
            whm.put(keyArray[i], valueArray[i]);
        assertSame("Remove returned incorrect value", whm.remove(keyArray[25]), valueArray[25]);
        assertNull("Remove returned incorrect value", whm.remove(keyArray[25]));
        assertEquals("Size should be 99 after remove", 99, whm.size());
    }

    @Test
    public void testKeySet() {
        for (int i = 0; i < 100; i++)
            whm.put(keyArray[i], valueArray[i]);
        List keys = Arrays.asList(keyArray);
        Set<Object> keySet = whm.keySet();
        assertEquals("Incorrect number of keys returned,", 100, keySet.size());
        for (Object key : keySet) {
            assertTrue("Invalid map entry returned--bad key", keys
                    .contains(key));
        }
        keyArray[50] = null;
        int count = 0;
        do {
            System.gc();
            System.gc();
            count++;
        } while (count <= 5 && keySet.size() == 100);
        assertEquals("Incorrect number of keys returned after gc,", 99, keySet.size());
    }

    @Test
    public void testValues() {
        for (int i = 0; i < 100; i++)
            whm.put(keyArray[i], valueArray[i]);
        List values = Arrays.asList(valueArray);
        Collection<Object> valuesCollection = whm.values();
        assertEquals("Incorrect number of keys returned,", 100,
                valuesCollection.size());
        for (Object value : valuesCollection) {
            assertTrue("Invalid map entry returned--bad value", values
                    .contains(value));
        }
        keyArray[50] = null;
        int count = 0;
        do {
            System.gc();
            System.gc();
            count++;
        } while (count <= 5 && valuesCollection.size() == 100);
        assertEquals("Incorrect number of keys returned after gc,", 99,
                valuesCollection.size());
    }

}
