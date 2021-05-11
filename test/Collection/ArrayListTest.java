package Collection;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListTest extends TestCase {

    List alist;
    Object[] objArray;

    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();
        objArray = new Object[100];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = i;
        }
        alist = new ArrayList();
        Collections.addAll(alist, objArray);
    }

    @Test
    public void testAddJavaObject() {
        Object o = new Object();
        int size = alist.size();
        alist.add(size, o);
        assertEquals("Failed to add Object", alist.get(size), o);
        assertEquals(alist.get(size - 2), objArray[size - 2]);
        assertEquals(alist.get(size - 1), objArray[size - 1]);
        alist.remove(size);
        size = alist.size();
        alist.add(size, null);
        assertNull("Should have returned null", alist.get(size));
        assertEquals(alist.get(size - 2), objArray[size - 2]);
        assertEquals(alist.get(size - 1), objArray[size - 1]);
    }

    @Test
    public void testAddAll() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
        ArrayList collection = new ArrayList();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        assertEquals(3, collection.size());
        list.addAll(0, collection);
        assertEquals(4, list.size());
        list.remove(0);
        list.remove(0);
        assertEquals(2, list.size());
        collection.add("4");
        collection.add("5");
        collection.add("6");
        collection.add("7");
        collection.add("8");
        collection.add("9");
        collection.add("10");
        collection.add("11");
        collection.add("12");
        assertEquals(12, collection.size());
        list.addAll(0, collection);
        assertEquals(14, list.size());

        ArrayList obj = new ArrayList();
        obj.addAll(0, obj);
        obj.addAll(obj.size(), obj);
        try {
            obj.addAll(-1, obj);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
            assertNotNull(e.getMessage());
        }
        try {
            obj.addAll(obj.size() + 1, obj);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
            assertNotNull(e.getMessage());
        }
        try {
            obj.addAll(0, null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Excepted
        }
        try {
            obj.addAll(obj.size() + 1, null);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
            assertNotNull(e.getMessage());
        }
        try {
            obj.addAll(-1, null);
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            // Expected
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testClear() {
        alist.clear();
        assertEquals("List did not clear", 0, alist.size());
        alist.add(null);
        alist.add(null);
        alist.add(null);
        alist.add("bam");
        alist.clear();
        assertEquals("List with nulls did not clear", 0, alist.size());

        for (Object o : alist) assertNull("Failed to clear list", o);
    }

    @Test
    public void testClone() {
        ArrayList x = (ArrayList) (((ArrayList) (alist)).clone());
        assertEquals("Cloned list was inequal to original", x, alist);
        for (int i = 0; i < alist.size(); i++)
            assertSame("Cloned list contains incorrect elements", alist.get(i), x.get(i));
        alist.add(null);
        alist.add(25, null);
        x = (ArrayList) (((ArrayList) (alist)).clone());
        assertEquals("nulls test - Cloned list was inequal to original", x, alist);
        for (int i = 0; i < alist.size(); i++)
            assertSame("nulls test - Cloned list contains incorrect elements", alist.get(i), x.get(i));
    }

    @Test
    public void testContains() {
        assertTrue("Returned false for valid element", alist
                .contains(objArray[99]));
        assertTrue("Returned false for equal element", alist
                .contains(8));
        assertFalse("Returned true for invalid element", alist
                .contains(new Object()));
        assertFalse("Returned true for null but should have returned false", alist.contains(null));
        alist.add(null);
        assertTrue("Returned false for null but should have returned true",
                alist.contains(null));
    }

    @Test
    public void test_isEmpty() {
        assertTrue("isEmpty returned false for new list", new ArrayList()
                .isEmpty());
        assertFalse("Returned true for existing list with elements", alist
                .isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("Returned incorrect size for exiting list", 100, alist
                .size());
        assertEquals("Returned incorrect size for new list", 0, new ArrayList()
                .size());
    }
}
