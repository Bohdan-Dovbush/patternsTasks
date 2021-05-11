package Collection.map;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LinkedHashMapTest extends TestCase {

    LinkedHashMap hm;
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
        hm = new LinkedHashMap();
        for (int i = 0; i < objArray.length; i++)
            hm.put(objArray2[i], objArray[i]);
        hm.put("test", null);
        hm.put(null, "test");
    }

    public void testGet() {
        assertNull("Get returned non-null for non existent key", hm.get("T"));
        hm.put("T", "HELLO");
        assertEquals("Get returned incorecct value for existing key", "HELLO", hm.get("T"));
        LinkedHashMap m = new LinkedHashMap();
        m.put(null, "test");
        assertEquals("Failed with null key", "test", m.get(null));
        assertNull("Failed with missing key matching null hash", m.get(0));
    }

    @Test
    public void testPut() {
        hm.put("KEY", "VALUE");
        assertEquals("Failed to install key/value pair", "VALUE", hm.get("KEY"));
        LinkedHashMap m = new LinkedHashMap();
        m.put((short) 0, "short");
        m.put(null, "test");
        m.put(0, "int");
        assertEquals("Failed adding to bucket containing null", "short", m.get((short) 0));
        assertEquals("Failed adding to bucket containing null2", "int", m.get(0));

        Map<String, String> n = new LinkedHashMap<>(8, .75f, true);
        n.put("KEY", "VALUE");
        n.put("WOMBAT", "COMBAT");
        n.put("KEY", "VALUE");
        Map.Entry newest = null;
        for (Map.Entry<String, String> e : n.entrySet()) {
            newest = e;
        }
        if (newest != null) {
            assertEquals("KEY", newest.getKey());
            assertEquals("VALUE", newest.getValue());
        }
        LinkedHashMap hm2 = new LinkedHashMap(hm);
        for (int i = 0; i < 1000; i++)
            assertEquals("Failed to clear all elements", hm2.get(
                    Integer.toString(i)), (i));
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
    public void testKeySet() {
        Set s = hm.keySet();
        assertEquals("Returned set of incorrect size()", s.size(), hm.size());
        for (Object o : objArray)
            assertTrue("Returned set does not contain all keys", s
                    .contains(o.toString()));
        LinkedHashMap m = new LinkedHashMap();
        m.put(null, "test");
        assertTrue("Failed with null key", m.containsKey(null));
        assertNull("Failed with null key", m.keySet().iterator().next());
        Map map = new LinkedHashMap(101);
        map.put(1, "1");
        map.put(102, "102");
        map.put(203, "203");
        Iterator it = map.keySet().iterator();
        Integer remove1 = (Integer) it.next();
        it.hasNext();
        it.remove();
        Integer remove2 = (Integer) it.next();
        it.remove();
        ArrayList list = new ArrayList(Arrays.asList(1, 102, 203));
        list.remove(remove1);
        list.remove(remove2);
        assertEquals("Wrong result", it.next(), list.get(0));
        assertEquals("Wrong size", 1, map.size());
        assertEquals("Wrong contents", map.keySet().iterator().next(), list.get(0));
        Map map2 = new LinkedHashMap(101);
        map2.put(1, "1");
        map2.put(4, "4");
        Iterator it2 = map2.keySet().iterator();
        Integer remove3 = (Integer) it2.next();
        int next;
        if (remove3 == 1) next = 4;
        else next = 1;
        it2.hasNext();
        it2.remove();
        assertEquals("Wrong result 2", it2.next(), next);
        assertEquals("Wrong size 2", 1, map2.size());
        assertEquals("Wrong contents 2", map2.keySet().iterator().next(), next);
    }

    @Test
    public void testValues() {
        Collection c = hm.values();
        assertEquals("Returned collection of incorrect size()", c.size(), hm.size());
        for (Object o : objArray) assertTrue("Returned collection does not contain all keys", c.contains(o));
        LinkedHashMap myLinkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 100; i++)
            myLinkedHashMap.put(objArray2[i], objArray[i]);
        Collection values = myLinkedHashMap.values();
        values.remove(0);
        assertFalse("Removing from the values collection should remove from the original map", myLinkedHashMap.containsValue(0));
    }

    @Test
    public void testRemove() {
        int size = hm.size();
        int y = 9;
        Integer x = ((Integer) hm.remove(Integer.toString(y)));
        assertEquals("Remove returned incorrect value", 9, (int) x);
        assertNull("Failed to remove given key", hm.get(9));
        assertEquals("Failed to decrement size", hm.size(), (size - 1));
        assertNull("Remove of non-existent key returned non-null", hm.remove("LCLCLC"));
        LinkedHashMap m = new LinkedHashMap();
        m.put(null, "test");
        assertNull("Failed with same hash as null", m.remove(0));
        assertEquals("Failed with null key", "test", m.remove(null));
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
        assertTrue("Returned false for valid key", hm.containsKey(Integer.toString(876)));
        assertFalse("Returned true for invalid key", hm.containsKey("KKDKDKD"));
        LinkedHashMap m = new LinkedHashMap();
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
    public void testIsEmpty() {
        assertTrue("Returned false for new map", new LinkedHashMap().isEmpty());
        assertFalse("Returned true for non-empty", hm.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size", hm.size(), (objArray.length + 2));
    }
}
