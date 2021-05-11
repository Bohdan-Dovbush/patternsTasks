package Collection.map;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class IdentityHashMapTest extends TestCase {

    IdentityHashMap hm;
    final static int hmSize = 1000;
    Object[] objArray;
    Object[] objArray2;

    @BeforeEach
    public void setUp() {
        objArray = new Object[hmSize];
        objArray2 = new Object[hmSize];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = i;
            objArray2[i] = objArray[i].toString();
        }
        hm = new IdentityHashMap();
        for (int i = 0; i < objArray.length; i++)
            hm.put(objArray2[i], objArray[i]);
        hm.put("test", null);
        hm.put(null, "test");
    }

    @Test
    public void testClear() {
        hm.clear();
        assertEquals("Clear failed to reset size", 0, hm.size());
        for (int i = 0; i < hmSize; i++)
            assertNull("Failed to clear all elements", hm.get(objArray2[i]));
    }

    @Test
    public void testContainsKey() {
        assertTrue("Returned false for valid key", hm.containsKey(objArray2[23]));
        assertFalse("Returned true for copy of valid key", hm.containsKey(Integer.toString(23)));
        assertFalse("Returned true for invalid key", hm.containsKey("KKDKDKD"));
        IdentityHashMap m = new IdentityHashMap();
        m.put(null, "test");
        assertTrue("Failed with null key", m.containsKey(null));
        assertFalse("Failed with missing key matching null hash", m.containsKey(0));
    }

    @Test
    public void testContainsValue() {
        assertTrue("Returned false for valid value", hm.containsValue(objArray[19]));
        assertFalse("Returned true for invalid value", hm.containsValue(-9));
    }

    @Test
    public void testEntrySet() {
        Set s = hm.entrySet();
        Iterator i = s.iterator();
        assertEquals("Returned set of incorrect size", hm.size(), s.size());
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            assertTrue("Returned incorrect entry set", hm.containsKey(m.getKey())
                    && hm.containsValue(m.getValue()));
        }
    }

    @Test
    public void testGet() {
        assertNull("Get returned non-null for non existent key", hm.get("T"));
        hm.put("T", "HELLO");
        assertEquals("Get returned incorecct value for existing key", "HELLO", hm.get("T")
        );
        IdentityHashMap m = new IdentityHashMap();
        m.put(null, "test");
        assertEquals("Failed with null key", "test", m.get(null));
        assertNull("Failed with missing key matching null hash", m.get(0));
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Returned false for new map", new IdentityHashMap().isEmpty());
        assertFalse("Returned true for non-empty", hm.isEmpty());
    }

    @Test
    public void testKeySet() {
        Set s = hm.keySet();
        assertEquals("Returned set of incorrect size()", s.size(), hm.size());
        for (int i = 0; i < objArray.length; i++) {
            assertTrue("Returned set does not contain all keys", s.contains(objArray2[i]));
        }
        IdentityHashMap<Object, String> m = new IdentityHashMap<>();
        m.put(null, "test");
        assertTrue("Failed with null key", m.containsKey(null));
        assertNull("Failed with null key", m.keySet().iterator().next());
        Map<Integer, String> map = new IdentityHashMap<>(101);
        map.put(1, "1");
        map.put(102, "102");
        map.put(203, "203");
        Iterator<Integer> it = map.keySet().iterator();
        Integer remove1 = it.next();
        it.hasNext();
        it.remove();
        Integer remove2 = it.next();
        it.remove();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 102, 203));
        list.remove(remove1);
        list.remove(remove2);
        assertEquals("Wrong result", it.next(), list.get(0));
        assertEquals("Wrong size", 1, map.size());
        assertEquals("Wrong contents", map.keySet().iterator().next(), list.get(0));
        Map<Integer, String> map2 = new IdentityHashMap<>(101);
        map2.put(1, "1");
        map2.put(4, "4");
        Iterator<Integer> it2 = map2.keySet().iterator();
        Integer remove3 = it2.next();
        int next;
        if (remove3 == 1) next = 4;
        else next = 1;
        it2.hasNext();
        it2.remove();
        assertEquals("Wrong result 2", (int) it2.next(), next);
        assertEquals("Wrong size 2", 1, map2.size());
        assertEquals("Wrong contents 2", (int) map2.keySet().iterator().next(), next);

        // tests with null keys and values
        IdentityHashMap<String, String> imap = new IdentityHashMap<>();
        String result;
        // null key and null value
        result = imap.put(null, null);
        assertTrue("testA can not find null key", imap.containsKey(null));
        assertTrue("testA can not find null value", imap.containsValue(null));
        assertNull("testA can not get null value for null key", imap.get(null));
        assertNull("testA put returned wrong value", result);
        // null value
        String value = "a value";
        result = imap.put(null, value);
        assertTrue("testB can not find null key", imap.containsKey(null));
        assertTrue("testB can not find a value with null key", imap.containsValue(value));
        assertSame("testB can not get value for null key", imap.get(null), value);
        assertNull("testB put returned wrong value", result);
        // a null key
        String key = "a key";
        result = imap.put(key, null);
        assertTrue("testC can not find a key with null value", imap.containsKey(key));
        assertTrue("testC can not find null value", imap.containsValue(null));
        assertNull("testC can not get null value for key", imap.get(key));
        assertNull("testC put returned wrong value", result);
        // another null key
        String anothervalue = "another value";
        result = imap.put(null, anothervalue);
        assertTrue("testD can not find null key", imap.containsKey(null));
        assertTrue("testD can not find a value with null key", imap.containsValue(anothervalue));
        assertSame("testD can not get value for null key", imap.get(null), anothervalue);
        assertSame("testD put returned wrong value", result, value);
        // remove a null key
        result = imap.remove(null);
        assertSame("testE remove returned wrong value", result, anothervalue);
        assertFalse("testE should not find null key", imap.containsKey(null));
        assertFalse("testE should not find a value with null key", imap.containsValue(anothervalue));
        assertNull("testE should not get value for null key",
                imap.get(null));
    }

    @Test
    public void testPut() {
        hm.put("KEY", "VALUE");
        assertEquals("Failed to install key/value pair", "VALUE", hm.get("KEY"));
        IdentityHashMap<Number, String> m = new IdentityHashMap<>();
        Short s0 = 0;
        m.put(s0, "short");
        m.put(null, "test");
        Integer i0 = 0;
        m.put(i0, "int");
        assertEquals("Failed adding to bucket containing null", "short", m.get(s0));
        assertEquals("Failed adding to bucket containing null2", "int", m.get(i0));
        IdentityHashMap<Object, Object> map = new IdentityHashMap<>();
        // Test null as a key.
        String value = "Some value";
        map.put(null, value);
        assertSame("Assert 0: Failure getting null key", value, map.get(null));
        // Test null as a value
        String key = "Some key";
        map.put(key, null);
        assertNull("Assert 1: Failure getting null value", map.get(key));
    }

    @Test
    public void testRemove() {
        int size = hm.size();
        Integer x = ((Integer) hm.remove(objArray2[9]));
        assertEquals("Remove returned incorrect value", 9, (int) x);
        assertNull("Failed to remove given key", hm.get(objArray2[9]));
        assertEquals("Failed to decrement size", hm.size(), (size - 1));
        assertNull("Remove of non-existent key returned non-null", hm.remove("LCLCLC"));
        IdentityHashMap m = new IdentityHashMap();
        m.put(null, "test");
        assertNull("Failed with same hash as null", m.remove(objArray[0]));
        assertEquals("Failed with null key", "test", m.remove(null));
        IdentityHashMap<String, String> hashMap = new IdentityHashMap<>();
        assertEquals("Assert 0: Size is incorrect", 0, hashMap.size());
        hashMap.put("key", "value");
        hashMap.remove("key");
        assertEquals("Assert 1: After removing non-null element size is incorrect", 0, hashMap.size());
        hashMap.put(null, null);
        assertEquals("Assert 2: adding literal null failed", 1, hashMap.size());
        hashMap.remove(null);
        assertEquals("Assert 3: After removing null element size is incorrect", 0, hashMap.size());
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size, ", (objArray.length + 2), hm.size());
    }

    @Test
    public void testValues() {
        IdentityHashMap<Integer, Integer> map = new IdentityHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        Integer key = 20;
        Integer value = 40;
        map.put(key, value);
        Collection<Integer> vals = map.values();
        boolean result = vals.remove(key);
        assertSame("removed entries incorrectly", map.size() == 11, !result);
        assertTrue("removed key incorrectly", map.containsKey(key));
        assertTrue("removed value incorrectly", map.containsValue(value));
        result = vals.remove(value);
        assertSame("Did not remove entry as expected", map.size() == 10, result);
        assertFalse("Did not remove key as expected", map.containsKey(key));
        assertFalse("Did not remove value as expected", map.containsValue(value));
        // put an equivalent key to a value
        key = 1;
        value = 100;
        map.put(key, value);
        result = vals.remove(key);
        assertSame("TestB. removed entries incorrectly", map.size() == 11, result);
        assertTrue("TestB. removed key incorrectly", map.containsKey(key));
        assertTrue("TestB. removed value incorrectly", map.containsValue(value));
        result = vals.remove(value);
        assertSame("TestB. Did not remove entry as expected", map.size() == 10, !result);
        assertFalse("TestB. Did not remove key as expected", map.containsKey(key));
        assertFalse("TestB. Did not remove value as expected", map.containsValue(value));
        vals.clear();
        assertEquals("Did not remove all entries as expected", 0, map.size());
    }
}
