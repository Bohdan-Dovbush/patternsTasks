package Collection;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest extends TestCase {

    HashSet hs;
    Object[] objArray;

    @BeforeEach
    protected void setUp() {
        objArray = new Object[1000];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = i;
        }
        hs = new HashSet();
        for (int i = 0; i < objArray.length; i++) {
            hs.add(objArray[i]);
        }
        hs.add(null);
    }

    @Test
    public void testAdd() {
        int size = hs.size();
        hs.add(8);
        assertTrue("Added element already contained by set", hs.size() == size);
        hs.add(-9);
        assertTrue("Failed to increment set size after add",
                hs.size() == size + 1);
        assertTrue("Failed to add element to set", hs.contains(-9));
    }

    @Test
    public void testClear() {
        Set orgSet = (Set) hs.clone();
        hs.clear();
        Iterator i = orgSet.iterator();
        assertEquals("Returned non-zero size after clear", 0, hs.size());
        while (i.hasNext())
            assertTrue("Failed to clear set", !hs.contains(i.next()));
    }

    @Test
    public void testClone() {
        HashSet hs2 = (HashSet) hs.clone();
        assertTrue("clone returned an equivalent HashSet", hs != hs2);
        assertTrue("clone did not return an equal HashSet", hs.equals(hs2));
    }

    @Test
    public void testContains() {
        assertTrue("Returned false for valid object", hs.contains(objArray[90]));
        assertTrue("Returned true for invalid Object", !hs.contains(new Object()));
        HashSet s = new HashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.contains(null));
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Empty set returned false", new HashSet().isEmpty());
        assertTrue("Non-empty set returned true", !hs.isEmpty());
    }

    @Test
    public void testIterator() {
        Iterator i = hs.iterator();
        int x = 0;
        while (i.hasNext()) {
            assertTrue("Failed to iterate over all elements", hs.contains(i.next()));
            ++x;
        }
        assertTrue("Returned iteration of incorrect size", hs.size() == x);
        HashSet s = new HashSet();
        s.add(null);
        assertNull("Cannot handle null", s.iterator().next());
    }

    @Test
    public void testRemove() {
        int size = hs.size();
        hs.remove(98);
        assertTrue("Failed to remove element", !hs.contains(98));
        assertTrue("Failed to decrement set size", hs.size() == size - 1);
        HashSet s = new HashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.remove(null));
        assertFalse(hs.remove(-98));
    }

    @Test
    public void testSize() {
        assertTrue("Returned incorrect size", hs.size() == (objArray.length + 1));
        hs.clear();
        assertEquals("Cleared set returned non-zero size", 0, hs.size());
    }
}
