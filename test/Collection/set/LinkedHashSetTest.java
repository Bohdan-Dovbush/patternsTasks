package Collection.set;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest extends TestCase {

    LinkedHashSet hs;
    Object[] objArray;

    @BeforeEach
    protected void setUp() {
        objArray = new Object[1000];
        for (int i = 0; i < objArray.length; i++)
            objArray[i] = i;
        hs = new LinkedHashSet();
        Collections.addAll(hs, objArray);
        hs.add(null);
    }

    public void testAdd() {
        int size = hs.size();
        hs.add(8);
        assertEquals("Added element already contained by set", hs.size(), size);
        hs.add(-9);
        assertEquals("Failed to increment set size after add", hs.size(), size + 1);
        assertTrue("Failed to add element to set", hs.contains(-9));
    }

    @Test
    public void test_clear() {
        Set orgSet = (Set) hs.clone();
        hs.clear();
        Iterator i = orgSet.iterator();
        assertEquals("Returned non-zero size after clear", 0, hs.size());
        while (i.hasNext()) assertFalse("Failed to clear set", hs.contains(i.next()));
    }

    @Test
    public void test_clone() {
        LinkedHashSet hs2 = (LinkedHashSet) hs.clone();
        assertNotSame("clone returned an equivalent LinkedHashSet", hs, hs2);
        assertEquals("clone did not return an equal LinkedHashSet", hs, hs2);
    }

    @Test
    public void test_containsLjava_lang_Object() {
        assertTrue("Returned false for valid object", hs.contains(objArray[90]));
        assertFalse("Returned true for invalid Object", hs.contains(new Object()));
        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.contains(null));
    }

    @Test
    public void test_isEmpty() {
        assertTrue("Empty set returned false", new LinkedHashSet().isEmpty());
        assertFalse("Non-empty set returned true", hs.isEmpty());
    }

    @Test
    public void testIterator() {
        Iterator i = hs.iterator();
        int x = 0;
        int j;
        for (j = 0; i.hasNext(); j++) {
            Object oo = i.next();
            if (oo != null) {
                Integer ii = (Integer) oo;
                assertEquals("Incorrect element found", ii.intValue(), j);
            } else {
                assertTrue("Cannot find null", hs.contains(oo));
            }
            ++x;
        }
        assertEquals("Returned iteration of incorrect size", hs.size(), x);
        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertNull("Cannot handle null", s.iterator().next());
    }

    @Test
    public void testRemove() {
        int size = hs.size();
        hs.remove(98);
        assertFalse("Failed to remove element", hs.contains(98));
        assertEquals("Failed to decrement set size", hs.size(), size - 1);
        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.remove(null));
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size", hs.size(), (objArray.length + 1));
        hs.clear();
        assertEquals("Cleared set returned non-zero size", 0, true);
    }
}
