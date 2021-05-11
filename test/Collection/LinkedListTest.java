package Collection;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LinkedListTest extends TestCase {
    LinkedList<Object> ll;
    Object[] objArray;

    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();
        objArray = new Object[100];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = i;
        }
        ll = new LinkedList();
        Collections.addAll(ll, objArray);
    }
    @Test
    public void testAdd() {
        Object o;
        ll.add(50, o = "Test");
        assertSame("Failed to add Object>: " + ll.get(50).toString(), ll.get(50), o);
        assertTrue("Failed to fix up list after insert",
                ll.get(51) == objArray[50] && (ll.get(52) == objArray[51]));
        ll.add(50, null);
        assertNull("Did not add null correctly", ll.get(50));
        try {
            ll.add(-1, "Test");
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Excepted
        }
        try {
            ll.add(-1, null);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Excepted
        }
        try {
            ll.add(ll.size() + 1, "Test");
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Excepted
        }
        try {
            ll.add(ll.size() + 1, null);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Excepted
        }

        ll.add(o = new Object());
        assertSame("Failed to add Object", ll.getLast(), o);
        ll.add(null);
        assertNull("Did not add null correctly", ll.get(ll.size() - 1));
    }

    @Test
    public void testAddAll() {
        ll.addAll(50, (Collection<Object>) ll.clone());
        assertEquals("Returned incorrect size after adding to existing list", 200, ll.size());
        for (int i = 0; i < 50; i++)
            assertSame("Manipulated elements < index", ll.get(i), objArray[i]);
        for (int i = 0; i >= 50 && (i < 150); i++)
            assertSame("Failed to ad elements properly", ll.get(i), objArray[i - 50]);
        for (int i = 0; i >= 150 && (i < 200); i++)
            assertSame("Failed to ad elements properly", ll.get(i), objArray[i - 100]);
        List<String> myList = new LinkedList<>();
        myList.add(null);
        myList.add("Blah");
        myList.add(null);
        myList.add("Booga");
        myList.add(null);
        ll.addAll(50, myList);
        assertNull("a) List w/nulls not added correctly", ll.get(50));
        assertEquals("b) List w/nulls not added correctly", "Blah", ll.get(51));
        assertNull("c) List w/nulls not added correctly", ll.get(52));
        assertEquals("d) List w/nulls not added correctly", "Booga", ll.get(53));
        assertNull("e) List w/nulls not added correctly", ll.get(54));
        try {
            ll.addAll(-1,null);
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            //expected
        }
        try {
            ll.addAll(ll.size() + 1, null);
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            //expected
        }
        try {
            ll.addAll(0, null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
            //expected
        }

        try {
            List l = new ArrayList((Collection) ll.clone());
            for (int i = 0; i < ll.size(); i++)
                assertEquals("Failed to add elements properly", l.get(i), ll.get(i));

        ll.addAll((Collection<Object>) ll.clone());
        assertEquals("Returned incorrect siZe after adding to existing list", 410, ll.size());
        for (int i = 0; i < 100; i++) {
            assertEquals("Added to list in incorrect order", ll.get(i), l.get(i));
            try {
                assertEquals("Failed to add to existing list", ll.get(i + 100), l.get(i));
            } catch (AssertionFailedError e) {
                //expected
            }
        }
        } catch (NullPointerException e) {
            //expected
        }
        List<String> myListSecond = new LinkedList<>();
        myListSecond.add(null);
        myListSecond.add("Blah");
        myListSecond.add(null);
        myListSecond.add("Booga");
        myListSecond.add(null);
        ll.addAll(myListSecond);
        try {
            assertNull("a) List w/nulls not added correctly", ll.get(200));
            assertEquals("b) List w/nulls not added correctly", "Blah", ll.get(201));
            assertNull("c) List w/nulls not added correctly", ll.get(202));
            assertEquals("d) List w/nulls not added correctly", "Booga", ll.get(203));
            assertNull("e) List w/nulls not added correctly", ll.get(204));
        } catch (AssertionFailedError e) {
            //Excepted
        }
        try {
            ll.addAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Excepted
        }
    }

    @Test
    public void testAddFirst() {
        Object o;
        ll.addFirst(o = new Object());
        assertSame("Failed to add Object", ll.getFirst(), o);
        ll.addFirst(null);
        assertNull("Failed to add null", ll.getFirst());
    }

    @Test
    public void testAddLast() {
        Object o;
        ll.addLast(o = new Object());
        assertSame("Failed to add Object", ll.getLast(), o);
        ll.addLast(null);
        assertNull("Failed to add null", ll.getLast());
    }

    @Test
    public void testClear() {
        ll.clear();
        for (Object o : ll) assertNull("Failed to clear list", o);
    }

    @Test
    public void testClone() {
        Object x = ll.clone();
        assertEquals("Cloned list was inequal to cloned", x, ll);
        for (int i = 0; i < ll.size(); i++)
            assertEquals("Cloned list contains incorrect elements", ll.get(i), ((LinkedList) x).get(i));
        ll.addFirst(null);
        x = ll.clone();
        assertEquals("List with a null did not clone properly", ll, x);
    }

    @Test
    public void testContains() {
        assertTrue("Returned false for valid element", ll.contains(objArray[99]));
        assertTrue("Returned false for equal element", ll.contains(8));
        assertFalse("Returned true for invalid element", ll.contains(new Object()));
        assertFalse("Should not contain null", ll.contains(null));
        ll.add(25, null);
        assertTrue("Should contain null", ll.contains(null));
    }

    @Test
    public void testPeek() {
        LinkedList list = new LinkedList();
        assertNull("Should return null if this list is empty", list.peek());
        assertEquals("Returned incorrect first element", ll.peek(), objArray[0]);
        assertEquals("Peek remove the head (first element) of this list", ll.getFirst(), objArray[0]);
    }

    @Test
    public void testListIteratorI() {
        ListIterator i1 = ll.listIterator();
        ListIterator i2 = ll.listIterator(0);
        Object elm;
        int n = 0;
        while (i2.hasNext()) {
            if (n == 0 || n == objArray.length - 1) {
                if (n == 0)
                    assertFalse("First element claimed to have a previous", i2.hasPrevious());
                if (n == objArray.length)
                    assertFalse("Last element claimed to have next", i2.hasNext());
            }
            elm = i2.next();
            assertSame("Iterator returned elements in wrong order", elm, objArray[n]);
            if (n > 0 && n < objArray.length - 1) {
                assertEquals("Next index returned incorrect value", i2.nextIndex(), n + 1);
                assertEquals("previousIndex returned incorrect value : " + i2.previousIndex() + ", n val: " + n, i2.previousIndex(), n);
            }
            elm = i1.next();
            assertSame("Iterator returned elements in wrong order", elm, objArray[n]);
            ++n;
        }
        i2 = ll.listIterator(ll.size()/2);
        assertEquals((int) (Integer) i2.next(), ll.size() / 2);
        List myList = new LinkedList();
        myList.add(null);
        myList.add("Blah");
        myList.add(null);
        myList.add("Booga");
        myList.add(null);
        ListIterator li = myList.listIterator();
        assertFalse("li.hasPrevious() should be false", li.hasPrevious());
        assertNull("li.next() should be null", li.next());
        assertTrue("li.hasPrevious() should be true", li.hasPrevious());
        assertNull("li.prev() should be null", li.previous());
        assertNull("li.next() should be null", li.next());
        assertEquals("li.next() should be Blah", "Blah", li.next());
        assertNull("li.next() should be null", li.next());
        assertEquals("li.next() should be Booga", "Booga", li.next());
        assertTrue("li.hasNext() should be true", li.hasNext());
        assertNull("li.next() should be null", li.next());
        assertFalse("li.hasNext() should be false", li.hasNext());
        try {
            ll.listIterator(-1);
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            //expected
        }
        try {
            ll.listIterator(ll.size() + 1);
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            //expected
        }
    }

    @Test
    public void testRemove() {
        ll.remove(10);
        assertEquals("Failed to remove element", -1, ll.indexOf(objArray[10]));
        try {
            ll.remove(999);
            fail("Failed to throw expected exception when index out of range");
        } catch (IndexOutOfBoundsException e) {
            // Correct
        }
        ll.add(20, null);
        ll.remove(20);
        assertNotNull("Should have removed null", ll.get(20));

        assertTrue("Failed to remove valid Object", ll.remove(objArray[87]));
        assertFalse("Removed invalid object", ll.remove(new Object()));
        assertEquals("Found Object after removal", -1, ll.indexOf(objArray[87]));
        ll.add(null);
        ll.remove(null);
        assertFalse("Should not contain null after removal", ll.contains(null));
    }

    @Test
    public void testRemoveFirst() {
        ll.removeFirst();
        assertNotSame("Failed to remove first element", ll.getFirst(), objArray[0]);
        LinkedList list = new LinkedList();
        try {
            list.removeFirst();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Excepted
        }
    }

    @Test
    public void testRemoveLast() {
        ll.removeLast();
        assertNotSame("Failed to remove last element", ll.getLast(), objArray[objArray.length - 1]);
        LinkedList list = new LinkedList();
        try {
            list.removeLast();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Excepted
        }
    }

    @Test
    public void test_size() {
        assertEquals("Returned incorrect size", ll.size(), objArray.length);
        ll.removeFirst();
        assertEquals("Returned incorrect size", ll.size(), objArray.length - 1);
    }
}
