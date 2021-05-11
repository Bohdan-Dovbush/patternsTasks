package Collection.map;

import generic.util.Size;
import generic.util.Color;
import generic.util.Empty;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class EnumMapTest extends TestCase {

    @Test
    public void testClear() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Small, 1);
        enumSizeMap.clear();
        assertNull("Failed to clear all elements", enumSizeMap.get(Size.Small));
    }

    @Test
    public void testContainsKey() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        assertFalse("Returned true for uncontained key", enumSizeMap.containsKey(Size.Small));
        enumSizeMap.put(Size.Small, 1);
        assertTrue("Returned false for contained key", enumSizeMap.containsKey(Size.Small));
        enumSizeMap.put(Size.Big, null);
        assertTrue("Returned false for contained key", enumSizeMap.containsKey(Size.Big));
        assertFalse("Returned true for uncontained key", enumSizeMap.containsKey(Color.Red));
        assertFalse("Returned true for uncontained key", enumSizeMap.containsKey(3));
        assertFalse("Returned true for uncontained key", enumSizeMap.containsKey(null));
    }

    @Test
    public void testContainsValue() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        Double double1 = 3.0;
        Double double2 = 3.0;
        assertFalse("Returned true for uncontained value", enumSizeMap.containsValue(double1));
        enumSizeMap.put(Size.Middle, 2);
        enumSizeMap.put(Size.Small, double1);
        assertTrue("Returned false for contained value", enumSizeMap.containsValue(double1));
        assertTrue("Returned false for contained value", enumSizeMap.containsValue(double2));
        assertTrue("Returned false for contained value", enumSizeMap.containsValue(2));
        assertFalse("Returned true for uncontained value", enumSizeMap.containsValue(1));
        assertFalse("Returned true for uncontained value", enumSizeMap.containsValue(null));
        enumSizeMap.put(Size.Big, null);
        assertTrue("Returned false for contained value", enumSizeMap.containsValue(null));
    }

    @Test
    public void testEntrySet() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        MockEntry mockEntry = new MockEntry(Size.Middle, 1);
        Set set = enumSizeMap.entrySet();
        Set set1 = enumSizeMap.entrySet();
        assertSame("Should be same", set1, set);
        try {
            set.add(mockEntry);
            fail("Should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {// Expected
        }
        assertTrue("Returned false for contained object", set.contains(mockEntry));
        mockEntry = new MockEntry(Size.Middle, null);
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        assertFalse("Returned true for uncontained object", set.contains(Size.Small));
        mockEntry = new MockEntry(1, 1);
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        assertFalse("Returned true for uncontained object", set.contains(1));
        mockEntry = new MockEntry(Size.Big, null);
        assertTrue("Returned false for contained object", set.contains(mockEntry));
        assertTrue("Returned false when the object can be removed", set.remove(mockEntry));
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        assertFalse("Returned true when the object can not be removed", set.remove(mockEntry));
        mockEntry = new MockEntry(1, 1);
        assertFalse("Returned true when the object can not be removed", set.remove(mockEntry));
        assertFalse("Returned true when the object can not be removed", set.remove(1));
        // The set is backed by the map so changes to one are reflected by the other.
        enumSizeMap.put(Size.Big, 3);
        mockEntry = new MockEntry(Size.Big, 3);
        assertTrue("Returned false for contained object", set.contains(mockEntry));
        enumSizeMap.remove(Size.Big);
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        assertEquals("Wrong size", 1, set.size());
        set.clear();
        assertTrue("Wrong size", set.isEmpty());
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        Collection c = new ArrayList();
        c.add(new MockEntry(Size.Middle, 1));
        assertTrue("Return wrong value", set.containsAll(c));
        assertTrue("Remove does not success", set.removeAll(c));
        enumSizeMap.put(Size.Middle, 1);
        c.add(new MockEntry(Size.Big, 3));
        assertTrue("Remove does not success", set.removeAll(c));
        assertFalse("Should return false", set.removeAll(c));
        assertEquals("Wrong size", 1, set.size());
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        c = new ArrayList();
        c.add(new MockEntry(Size.Middle, 1));
        c.add(new MockEntry(Size.Big, 3));
        assertTrue("Retain does not success", set.retainAll(c));
        assertEquals("Wrong size", 1, set.size());
        assertFalse("Should return false", set.retainAll(c));
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        Object[] array = set.toArray();
        assertEquals("Wrong length", 2, array.length);
        Map.Entry entry = (Map.Entry) array[0];
        assertEquals("Wrong key", Size.Middle, entry.getKey());
        assertEquals("Wrong value", 1, entry.getValue());
        Object[] array1;
        array1 = set.toArray();
        assertEquals("Wrong length", 2, array1.length);
        entry = (Map.Entry) array[0];
        assertEquals("Wrong key", Size.Middle, entry.getKey());
        assertEquals("Wrong value", 1, entry.getValue());
        array1 = new Object[10];
        array1 = set.toArray(array1);
        assertEquals("Wrong length", 10, array1.length);
        entry = (Map.Entry) array[1];
        assertEquals("Wrong key", Size.Big, entry.getKey());
        assertNull("Should be null", array1[2]);
        set = enumSizeMap.entrySet();
        Integer integer = 1;
        assertFalse("Returned true when the object can not be removed", set.remove(integer));
        assertTrue("Returned false when the object can be removed", set.remove(entry));
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        Iterator iter = set.iterator();
        entry = (Map.Entry) iter.next();
        assertTrue("Returned false for contained object", set.contains(entry));
        mockEntry = new MockEntry(Size.Middle, 2);
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        mockEntry = new MockEntry(2, 2);
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        entry = (Map.Entry) iter.next();
        assertTrue("Returned false for contained object", set.contains(entry));
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.remove(Size.Big);
        mockEntry = new MockEntry(Size.Big, null);
        assertEquals("Wrong size", 1, set.size());
        assertFalse("Returned true for uncontained object", set.contains(mockEntry));
        enumSizeMap.put(Size.Big, 2);
        mockEntry = new MockEntry(Size.Big, 2);
        assertTrue("Returned false for contained object", set.contains(mockEntry));
        iter.remove();
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        try {
            entry.setValue(2);
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        try {
            set.contains(entry);
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        iter = set.iterator();
        entry = (Map.Entry) iter.next();
        assertEquals("Wrong key", Size.Middle, entry.getKey());
        assertTrue("Returned false for contained object", set.contains(entry));
        enumSizeMap.put(Size.Middle, 3);
        assertTrue("Returned false for contained object", set.contains(entry));
        entry.setValue(2);
        assertTrue("Returned false for contained object", set.contains(entry));
        assertFalse("Returned true for uncontained object", set.remove(1));
        iter.next();
        assertEquals("Wrong key", Size.Middle, entry.getKey());
        set.clear();
        assertEquals("Wrong size", 0, 0);
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.entrySet();
        iter = set.iterator();
        mockEntry = new MockEntry(Size.Middle, 1);
        assertNotEquals("Wrong result", entry, mockEntry);
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        entry = (Map.Entry) iter.next();
        assertEquals("Wrong key", Size.Middle, entry.getKey());
        assertEquals("Should return true", entry, mockEntry);
        assertEquals("Should be equal", mockEntry.hashCode(), entry.hashCode());
        mockEntry = new MockEntry(Size.Big, 1);
        assertNotEquals("Wrong result", entry, mockEntry);
        entry = (Map.Entry) iter.next();
        assertNotEquals("Wrong result", entry, mockEntry);
        assertEquals("Wrong key", Size.Big, entry.getKey());
        iter.remove();
        assertNotEquals("Wrong result", entry, mockEntry);
        assertEquals("Wrong size", 1, set.size());
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        try {
            iter.next();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {// Expected
        }
    }

    @Test
    public void testKeySet() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 2);
        enumSizeMap.put(Size.Big, null);
        Set set = enumSizeMap.keySet();
        Set set1 = enumSizeMap.keySet();
        assertSame("Should be same", set1, set);
        try {
            set.add(Size.Big);
            fail("Should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {// Expected
        }
        assertTrue("Returned false for contained object", set.contains(Size.Middle));
        assertTrue("Returned false for contained object", set.contains(Size.Big));
        assertFalse("Returned true for uncontained object", set.contains(Size.Small));
        assertFalse("Returned true for uncontained object", set.contains(1));
        assertTrue("Returned false when the object can be removed", set.remove(Size.Big));
        assertFalse("Returned true for uncontained object", set.contains(Size.Big));
        assertFalse("Returned true when the object can not be removed", set.remove(Size.Big));
        assertFalse("Returned true when the object can not be removed", set.remove(1));
        // The set is backed by the map so changes to one are reflected by the other.
        enumSizeMap.put(Size.Big, 3);
        assertTrue("Returned false for contained object", set.contains(Size.Big));
        enumSizeMap.remove(Size.Big);
        assertFalse("Returned true for uncontained object", set.contains(Size.Big));
        assertEquals("Wrong size", 1, set.size());
        set.clear();
        assertEquals("Wrong size", 0, 0);
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.keySet();
        Collection c = new ArrayList();
        c.add(Size.Big);
        assertTrue("Should return true", set.containsAll(c));
        c.add(Size.Small);
        assertFalse("Should return false", set.containsAll(c));
        assertTrue("Should return true", set.removeAll(c));
        assertEquals("Wrong size", 1, set.size());
        assertFalse("Should return false", set.removeAll(c));
        assertEquals("Wrong size", 1, set.size());
        try {
            set.addAll(c);
            fail("Should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {// Expected
        }
        enumSizeMap.put(Size.Big, null);
        assertEquals("Wrong size", 2, set.size());
        assertTrue("Should return true", set.retainAll(c));
        assertEquals("Wrong size", 1, set.size());
        assertFalse("Should return false", set.retainAll(c));
        assertEquals(1, set.size());
        Object[] array = set.toArray();
        assertEquals("Wrong length", 1, array.length);
        assertEquals("Wrong key", Size.Big, array[0]);
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.keySet();
        c = new ArrayList();
        c.add(Color.Blue);
        assertFalse("Should return false", set.remove(c));
        assertEquals("Wrong size", 2, set.size());
        assertTrue("Should return true", set.retainAll(c));
        assertEquals("Wrong size", 0, set.size());
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.keySet();
        Iterator iter = set.iterator();
        Enum enumKey = (Enum) iter.next();
        assertTrue("Returned false for contained object", set.contains(enumKey));
        enumKey = (Enum) iter.next();
        assertTrue("Returned false for contained object", set.contains(enumKey));
        enumSizeMap.remove(Size.Big);
        assertFalse("Returned true for uncontained object", set.contains(enumKey));
        iter.remove();
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        assertFalse("Returned true for uncontained object", set.contains(enumKey));
        iter = set.iterator();
        enumKey = (Enum) iter.next();
        assertTrue("Returned false for contained object", set.contains(enumKey));
        enumSizeMap.put(Size.Middle, 3);
        assertTrue("Returned false for contained object", set.contains(enumKey));
        enumSizeMap = new EnumMap(Size.class);
        enumSizeMap.put(Size.Middle, 1);
        enumSizeMap.put(Size.Big, null);
        set = enumSizeMap.keySet();
        iter = set.iterator();
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        enumKey = (Enum) iter.next();
        assertEquals("Wrong key", Size.Middle, enumKey);
        assertSame("Wrong key", Size.Middle, enumKey);
        assertNotEquals("Returned true for unequal object", iter, enumKey);
        iter.remove();
        assertFalse("Returned true for uncontained object", set.contains(enumKey));
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        assertEquals("Wrong size", 1, set.size());
        enumKey = (Enum) iter.next();
        assertEquals("Wrong key", Size.Big, enumKey);
        iter.remove();
        try {
            iter.next();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {// Expected
            }
    }

    @Test
    public void testPut() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        try {
            enumSizeMap.put(Color.Red, 2);
            fail("Expected ClassCastException");
        } catch (ClassCastException e) {// Expected
        }
        assertNull("Return non-null for non mapped key", enumSizeMap.put(Size.Small, 1));
        EnumMap enumColorMap = new EnumMap<Color, Double>(Color.class);
        try {
            enumColorMap.put(Size.Big, 2);
            fail("Expected ClassCastException");
        } catch (ClassCastException e) {// Expected
        }
        try {
            enumColorMap.put(null, 2);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {// Expected
        }
        assertNull("Return non-null for non mapped key", enumColorMap.put(Color.Green, 2));
        assertEquals("Return wrong value", 2, enumColorMap.put(Color.Green, 4.0));
        assertEquals("Return wrong value", 4.0, enumColorMap.put(Color.Green, 3));
        assertEquals("Return wrong value", 3, enumColorMap.put(Color.Green, null));
        Float f = (float) 3.4;
        assertNull("Return non-null for non mapped key", enumColorMap.put(Color.Green, f));
        assertNull("Return non-null for non mapped key", enumColorMap.put(Color.Blue, 2));
        assertEquals("Return wrong value", 2, enumColorMap.put(Color.Blue, 4.0));
    }

    @Test
    public void testRemove() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        assertNull("Remove of non-mapped key returned non-null", enumSizeMap.remove(Size.Big));
        enumSizeMap.put(Size.Big, 3);
        enumSizeMap.put(Size.Middle, 2);
        assertNull("Get returned non-null for non mapped key", enumSizeMap.get(Size.Small));
        assertEquals("Remove returned incorrect value", 3, enumSizeMap.remove(Size.Big));
        assertNull("Get returned non-null for non mapped key", enumSizeMap.get(Size.Big));
        assertNull("Remove of non-mapped key returned non-null", enumSizeMap.remove(Size.Big));
        assertNull("Remove of non-existent key returned non-null", enumSizeMap.remove(Color.Red));
        assertNull("Remove of non-existent key returned non-null", enumSizeMap.remove(4.0));
        assertNull("Remove of non-existent key returned non-null", enumSizeMap.remove(null));
        EnumMap enumColorMap = new EnumMap<Color, Double>(Color.class);
        assertNull("Get returned non-null for non mapped key", enumColorMap.get(Color.Green));
        enumColorMap.put(Color.Green, 4.0);
        assertEquals("Remove returned incorrect value", 4.0, enumColorMap.remove(Color.Green));
        assertNull("Get returned non-null for non mapped key", enumColorMap.get(Color.Green));
        enumColorMap.put(Color.Green, null);
        assertNull("Can not handle null value", enumColorMap.remove(Color.Green));
        assertNull("Get returned non-null for non mapped key", enumColorMap.get(Color.Green));
    }

    @Test
    public void testSize() {
        EnumMap enumSizeMap = new EnumMap(Size.class);
        assertEquals("Wrong size", 0, enumSizeMap.size());
        enumSizeMap.put(Size.Small, 1);
        assertEquals("Wrong size", 1, enumSizeMap.size());
        enumSizeMap.put(Size.Small, 0);
        assertEquals("Wrong size", 1, enumSizeMap.size());
        try {
            enumSizeMap.put(Color.Red, 2);
            fail("Expected ClassCastException");
        } catch (ClassCastException e) {// Expected
        }
        assertEquals("Wrong size", 1, enumSizeMap.size());
        enumSizeMap.put(Size.Middle, null);
        assertEquals("Wrong size", 2, enumSizeMap.size());
        enumSizeMap.remove(Size.Big);
        assertEquals("Wrong size", 2, enumSizeMap.size());
        enumSizeMap.remove(Size.Middle);
        assertEquals("Wrong size", 1, enumSizeMap.size());
        enumSizeMap.remove(Color.Green);
        assertEquals("Wrong size", 1, enumSizeMap.size());
        EnumMap enumColorMap = new EnumMap<Color, Double>(Color.class);
        enumColorMap.put(Color.Green, 2);
        assertEquals("Wrong size", 1, enumColorMap.size());
        enumColorMap.remove(Color.Green);
        assertEquals("Wrong size", 0, enumColorMap.size());
        EnumMap enumEmptyMap = new EnumMap<Empty, Double>(Empty.class);
        assertEquals("Wrong size", 0, enumEmptyMap.size());
    }

    @Test
    public void testValues() {
        EnumMap enumColorMap = new EnumMap<Color, Double>(Color.class);
        enumColorMap.put(Color.Red, 1);
        enumColorMap.put(Color.Blue, null);
        Collection collection = enumColorMap.values();
        Collection collection1 = enumColorMap.values();
        assertSame("Should be same", collection1, collection);
        try {
            collection.add(1);
            fail("Should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {// Expected
        }
        assertTrue("Returned false for contained object", collection.contains(1));
        assertTrue("Returned false for contained object", collection.contains(null));
        assertFalse("Returned true for uncontained object", collection.contains(2));
        assertTrue("Returned false when the object can be removed", collection.remove(null));
        assertFalse("Returned true for uncontained object", collection.contains(null));
        assertFalse("Returned true when the object can not be removed", collection.remove(null));
        // The set is backed by the map so changes to one are reflected by the other.
        enumColorMap.put(Color.Blue, 3);
        assertTrue("Returned false for contained object", collection.contains(3));
        enumColorMap.remove(Color.Blue);
        assertFalse("Returned true for uncontained object", collection.contains(3));
        assertEquals("Wrong size", 1, collection.size());
        collection.clear();
        assertEquals("Wrong size", 0, 0);
        enumColorMap = new EnumMap<Color, Double>(Color.class);
        enumColorMap.put(Color.Red, 1);
        enumColorMap.put(Color.Blue, null);
        collection = enumColorMap.values();
        Collection c = new ArrayList();
        c.add(1);
        assertTrue("Should return true", collection.containsAll(c));
        c.add(3.4);
        assertFalse("Should return false", collection.containsAll(c));
        assertTrue("Should return true", collection.removeAll(c));
        assertEquals("Wrong size", 1, collection.size());
        assertFalse("Should return false", collection.removeAll(c));
        assertEquals("Wrong size", 1, collection.size());
        try {
            collection.addAll(c);
            fail("Should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {// Expected
        }
        enumColorMap.put(Color.Red, 1);
        assertEquals("Wrong size", 2, collection.size());
        assertTrue("Should return true", collection.retainAll(c));
        assertEquals("Wrong size", 1, collection.size());
        assertFalse("Should return false", collection.retainAll(c));
        assertEquals(1, collection.size());
        Object[] array = collection.toArray();
        assertEquals("Wrong length", 1, array.length);
        assertEquals("Wrong key", 1, array[0]);
        enumColorMap = new EnumMap<Color, Double>(Color.class);
        enumColorMap.put(Color.Red, 1);
        enumColorMap.put(Color.Blue, null);
        collection = enumColorMap.values();
        assertEquals("Wrong size", 2, collection.size());
        assertFalse("Returned true when the object can not be removed", collection.remove(10));
        Iterator iter = enumColorMap.values().iterator();
        Object value = iter.next();
        assertTrue("Returned false for contained object", collection.contains(value));
        value = iter.next();
        assertTrue("Returned false for contained object", collection.contains(value));
        enumColorMap.put(Color.Green, 1);
        enumColorMap.remove(Color.Blue);
        assertFalse("Returned true for uncontained object", collection.contains(value));
        iter.remove();
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        assertFalse("Returned true for uncontained object", collection.contains(value));
        iter = enumColorMap.values().iterator();
        value = iter.next();
        assertTrue("Returned false for contained object", collection.contains(value));
        enumColorMap.put(Color.Green, 3);
        assertTrue("Returned false for contained object", collection.contains(value));
        assertTrue("Returned false for contained object", collection.remove(1));
        assertEquals("Wrong size", 1, collection.size());
        collection.clear();
        assertSame("Wrong size", 0, 0);
        enumColorMap = new EnumMap<Color, Double>(Color.class);
        Integer integer1 = 1;
        enumColorMap.put(Color.Green, integer1);
        enumColorMap.put(Color.Blue, null);
        collection = enumColorMap.values();
        iter = enumColorMap.values().iterator();
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        value = iter.next();
        assertEquals("Wrong value", integer1, value);
        assertSame("Wrong value", integer1, value);
        assertNotEquals("Returned true for unequal object", iter, value);
        iter.remove();
        assertNotEquals("Returned true for unequal object", iter, value);
        try {
            iter.remove();
            fail("Should throw IllegalStateException");
        } catch (IllegalStateException e) {// Expected
        }
        assertEquals("Wrong size", 1, collection.size());
        value = iter.next();
        assertNotEquals("Returned true for unequal object", iter, value);
        iter.remove();
        try {
            iter.next();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {// Expected
        }
    }

    private static class MockEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        public MockEntry(K key, V value) {
            this.key   = key;
            this.value = value;
        }
        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public V setValue(V object) { V oldValue = value;
            value = object;
            return oldValue;
        }
    }
}
