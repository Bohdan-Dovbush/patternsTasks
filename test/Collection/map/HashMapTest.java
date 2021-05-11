package Collection.map;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HashMapTest extends TestCase {

    HashMap hm;
    final static int hmSize = 1000;
    Object[] objArray;
    Object[] objArray2;

    @BeforeEach
    protected void setUp() {
        objArray = new Object[hmSize];
        objArray2 = new Object[hmSize];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = i;
            objArray2[i] = objArray[i].toString();
        }
        hm = new HashMap();
        for (int i = 0; i < objArray.length; i++)
            hm.put(objArray2[i], objArray[i]);
            hm.put("test", null);
            hm.put(null, "test");
            hm.put(null, null);
    }

    @Test
    public void testClear() {
        hm.clear();
        assertEquals("Clear failed to reset size", 0, hm.size());
        for (int i = 0; i < hmSize; i++)
            assertNull("Failed to clear all elements",
                    hm.get(objArray2[i]));
        // Check clear on a large loaded map of Integer keys
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = -32767; i < 32768; i++) {
            map.put(i, "foobar");
        }
        map.clear();
        assertEquals("Failed to reset size on large integer map", 0, hm.size());
        for (int i = -32767; i < 32768; i++) {
            assertNull("Failed to clear integer map values", map.get(i));
        }
    }

    @Test
    public void testClone() {
        HashMap hm2 = (HashMap) hm.clone();
        assertNotSame("Clone answered equivalent HashMap", hm2, hm);
        for (int counter = 0; counter < hmSize; counter++)
            assertSame("Clone answered unequal HashMap", hm
                    .get(objArray2[counter]), hm2.get(objArray2[counter]));
        HashMap map = new HashMap();
        map.put("key", "value");
        // get the keySet() and values() on the original Map
        Set keys = map.keySet();
        Collection values = map.values();
        assertEquals("values() does not work",
                "value", values.iterator().next());
        assertEquals("keySet() does not work",
                "key", keys.iterator().next());
        AbstractMap map2 = (AbstractMap) map.clone();
        map2.put("key", "value2");
        Collection values2 = map2.values();
        assertNotSame("values() is identical", values2, values);
        // values() and keySet() on the cloned() map should be different
        assertEquals("values() was not cloned",
                "value2", values2.iterator().next());
        map2.clear();
        map2.put("key2", "value3");
        Set key2 = map2.keySet();
        assertNotSame("keySet() is identical", key2, keys);
        assertEquals("keySet() was not cloned",
                "key2", key2.iterator().next());
    }

    @Test
    public void testContainsKey() {
        int key = 876;
        assertTrue("Returned false for valid key", hm.containsKey(Integer.toString(key)));
        assertFalse("Returned true for invalid key", hm.containsKey("KKDKDKD"));
        HashMap m = new HashMap();
        m.put(null, "test");
        assertTrue("Failed with null key", m.containsKey(null));
        assertFalse("Failed with missing key matching null hash", m.containsKey(0));
    }

    @Test
    public void testContainsValue() {
        assertTrue("Returned false for valid value", hm.containsValue(875));
        assertFalse("Returned true for invalid value", hm.containsValue(-9));
    }

    @Test
    public void testEntrySet() {
        Set s = hm.entrySet();
        Iterator i = s.iterator();
        assertEquals("Returned set of incorrect size", hm.size(), s.size());
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            assertTrue("Returned incorrect entry set", hm.containsKey(m
                    .getKey())
                    && hm.containsValue(m.getValue()));
        }
        Iterator iter = s.iterator();
        s.remove(iter.next());
        assertEquals(1001, s.size());
        Set s1 = hm.entrySet();
        Set s2 = new HashMap(hm).entrySet();
        assertEquals(s1, s2);
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Returned false for new map", new HashMap().isEmpty());
        assertFalse("Returned true for non-empty", hm.isEmpty());
    }

    @Test
    public void testPut() {
        Integer myKey = 0;
        Short key = 0;
        hm.put("KEY", "VALUE");
        assertEquals("Failed to install key/value pair", "VALUE", hm.get("KEY"));
        HashMap<Object, Object> m = new HashMap<>();
        m.put(key, "short");
        m.put(null, "test");
        m.put(myKey, "int");
        assertEquals("Failed adding to bucket containing null", "short", m.get(key));
        assertEquals("Failed adding to bucket containing null2", "int", m.get(myKey));
        // Check my actual key instance is returned
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = -32767; i < 32768; i++) {
            map.put(i, "foobar");
        }
        // Put a new value at the old key position
        map.put(myKey, "myValue");
        assertTrue(map.containsKey(myKey));
        assertEquals("myValue", map.get(myKey));
        boolean found = false;
        for (Integer keyss : map.keySet()) {
            if (found = keyss.equals(myKey)) {
                break;
            }
        }
        assertTrue("Should not find new key instance in hashmap", found);
        // Add a new key instance and check it is returned
        assertNotNull(map.remove(myKey));
        map.put(myKey, "myValue");
        assertTrue(map.containsKey(myKey));
        assertEquals("myValue", map.get(myKey));
        for (Integer keys : map.keySet()) {
            if (found = keys.equals(myKey)) {
                break;
            }
        }
        assertTrue("Did not find new key instance in hashmap", found);
        // Ensure keys with identical hashcode are stored separately
        HashMap<Object, Object> objmap = new HashMap<>();
        for (int i = 0; i < 32768; i++) {
            objmap.put(i, "foobar");
        }
    }

    @Test
    public void testPutAll() {
        HashMap hm2 = new HashMap(hm);
        for (int i = 0; i < 1000; i++)
            assertEquals("Failed to clear all elements", hm2.get(Integer.toString(i)), (i));
        Random rnd = new Random(666);
        Map<Integer,Integer> m1 = new HashMap<>();
        int MID = 10000;
        for (int i = 0; i < MID; i++) {
            Integer j = rnd.nextInt();
            m1.put(j, j);
        }
        Map<Integer,Integer> m2 = new HashMap<>();
        int HI = 30000;
        for (int i = MID; i < HI; i++) {
            Integer j = rnd.nextInt();
            m2.put(j, j);
        }
        m1.putAll(m2);
        rnd = new Random(666);
        for (int i = 0; i < HI; i++) {
            Integer j = rnd.nextInt();
            assertEquals(j, m1.get(j));
        }
    }

    @Test
    public void testValues() {
        Collection c = hm.values();
        assertEquals("Returned collection of incorrect size()", c.size(), hm.size());
        for (Object o : objArray) assertTrue("Returned collection does not contain all keys", c.contains(o));
        HashMap myHashMap = new HashMap();
        for (int i = 0; i < 100; i++)
            myHashMap.put(objArray2[i], objArray[i]);
        Collection values = myHashMap.values();
        values.remove(0);
        assertFalse("Removing from the values collection should remove from the original map",
                myHashMap.containsValue(0));
    }

    @Test
    public void testRemove() {
        int size = hm.size();
        Integer y = 9;
        Integer x = ((Integer) hm.remove(y.toString()));
        assertEquals("Remove returned incorrect value", x, y);
        assertNull("Failed to remove given key", hm.get(y));
        assertEquals("Failed to decrement size", hm.size(), (size - 1));
        assertNull("Remove of non-existent key returned non-null", hm.remove("LCLCLC"));
        HashMap m = new HashMap();
        m.put(null, "test");
        assertNull("Failed with same hash as null", m.remove(0));
        assertEquals("Failed with null key", "test", m.remove(null));
        HashMap<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 32768; i++) {
            map.put(i, "const");
        }
        Object[] values = new Object[32768];
        for (int i = 0; i < 32768; i++) {
            values[i] = new Object();
            map.put(i, values[i]);
        }
        for (int i = 32767; i >= 0; i--) {
            assertEquals("Failed to remove same value", values[i], map.remove(i));
        }
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size", hm.size(), (objArray.length + 2));
    }

}
