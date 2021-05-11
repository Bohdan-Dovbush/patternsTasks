package Collection.set;

import Collection.Util.ReversedIntegerComparator;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;

class TreeSetTest extends TestCase {

    TreeSet ts;
    Object[] objArray = new Object[1000];

    @BeforeEach
    protected void setUp() {
        ts = new TreeSet();
        for (int i = 0; i < objArray.length; i++) {
            Object x = objArray[i] = i;
            ts.add(x);
        }
    }

    @Test
    public void testAddAll() {
        TreeSet s = new TreeSet();
        s.addAll(ts);
        assertEquals("Incorrect size after add", s.size(), ts.size());
        for (Object t : ts) assertTrue("Returned incorrect set", s.contains(t));
    }

    @Test
    public void testClear() {
        ts.clear();
        assertEquals("Returned non-zero size after clear", 0, true);
        assertFalse("Found element in cleared set", ts.contains(objArray[0]));
    }

    @Test
    public void testClone() {
        TreeSet s = (TreeSet) ts.clone();
        for (Object t : ts)
            assertTrue("Clone failed to copy all elements", s
                    .contains(t));
    }

    @Test
    public void testComparator() {
        ReversedIntegerComparator comp = new ReversedIntegerComparator();
        TreeSet myTreeSet = new TreeSet(comp);
        assertSame("Answered incorrect comparator", myTreeSet.comparator(), comp);
    }

    @Test
    public void testContains() {
        assertTrue("Returned false for valid Object", ts
                .contains(objArray[objArray.length / 2]));
        assertFalse("Returned true for invalid Object", ts
                .contains(-9));
        try {
            ts.contains(new Object());
        } catch (ClassCastException e) {
            // Correct
            return;
        }
        fail("Failed to throw exception when passed invalid element");
    }

    @Test
    public void testFirst() {
        assertSame("Returned incorrect first element", ts.first(), objArray[0]);
    }

    @Test
    public void testHeadSet() {
        Set s = ts.headSet(100);
        assertEquals("Returned set of incorrect size", 100, s.size());
        for (int i = 0; i < 100; i++)
            assertTrue("Returned incorrect set", s.contains(objArray[i]));
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Empty set returned false", new TreeSet().isEmpty());
        assertFalse("Non-Empty returned true", ts.isEmpty());
    }

    @Test
    public void testIterator() {
        TreeSet s = new TreeSet();
        s.addAll(ts);
        Iterator i = ts.iterator();
        Set as = new HashSet(Arrays.asList(objArray));
        while (i.hasNext())
            as.remove(i.next());
        assertEquals("Returned incorrect iterator", 0, as.size());
    }

    @Test
    public void testLast() {
        assertSame("Returned incorrect last element", ts.last(), objArray[objArray.length - 1]);
    }

    @Test
    public void testRemove() {
        ts.remove(objArray[0]);
        assertFalse("Failed to remove object", ts.contains(objArray[0]));
        assertEquals("Failed to change size after remove", ts.size(), objArray.length - 1);
        try {
            ts.remove(new Object());
        } catch (ClassCastException e) {
            // Correct
            return;
        }
        fail("Failed to throw exception when past uncomparable value");
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size", ts.size(), objArray.length);
    }

    @Test
    public void testEquals() {
        Set s1 = new TreeSet();
        Set s2 = new TreeSet();
        s1.add("key1");
        s1.add("key2");
        s2.add(1);
        s2.add(2);
        assertNotEquals("Sets should not be equal 1", s1, s2);
        assertNotEquals("Sets should not be equal 2", s2, s1);
        // comparing TreeSet with HashSet
        s1 = new TreeSet();
        s2 = new HashSet();
        s1.add("key");
        s2.add(new Object());
        assertNotEquals("Sets should not be equal 3", s1, s2);
        assertNotEquals("Sets should not be equal 4", s2, s1);
        // comparing TreeSets with not-comparable objects inside
            s1 = new TreeSet();
            s2 = new TreeSet();
        try {
            s1.add(new Object());
            s2.add(new Object());
            assertNotEquals("Sets should not be equal 5", s1, s2);
            assertNotEquals("Sets should not be equal 6", s2, s1);
        } catch (ClassCastException e){
            //
        }
    }

}
