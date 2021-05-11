package Collection;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDequeTest extends TestCase {

    private Object testObjOne;
    private Object testObjTwo;
    private Object testObjThree;
    private Object testObjFour;
    private Object testObjLast;
    private ArrayDeque<Object> testQue;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        testObjOne = new Object();
        testObjTwo = new Object();
        testObjThree = new Object();
        testObjFour = new Object();
        testObjLast = new Object();
        testQue = new ArrayDeque<>();
    }

    @Test
    public void testAdd() {
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertEquals(testObjOne, testQue.peekFirst());
        assertEquals(testObjThree, testQue.peekLast());
        try {
            testQue.add(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }

    @Test
    public void testAddFirst() {
        testQue.addFirst(testObjOne);
        assertEquals(1, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.addFirst(testObjOne);
        assertEquals(2, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.addFirst(testObjTwo);
        assertEquals(3, testQue.size());
        assertEquals(testObjTwo, testQue.peek());
        assertEquals(testObjOne, testQue.getLast());
        try {
            testQue.addFirst(null);
            fail("should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }

    @Test
    public void testAddLast() {
        testQue.addLast(testObjOne);
        assertEquals(1, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.addLast(testObjOne);
        assertEquals(2, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.addLast(testObjTwo);
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        assertEquals(testObjTwo, testQue.getLast());
        try {
            testQue.addLast(null);
            fail("should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }

    @Test
    public void testRemoveFirst() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.removeFirst());
        assertEquals(2, testQue.size());
        assertEquals(testObjTwo, testQue.removeFirst());
        assertEquals(testObjThree, testQue.removeFirst());
        assertEquals(0, testQue.size());
        try {
            testQue.removeFirst();
            fail("should throw NoSuchElementException ");
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void testRemoveLast() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjThree, testQue.removeLast());
        assertEquals(2, testQue.size());
        assertEquals(testObjTwo, testQue.removeLast());
        assertEquals(testObjOne, testQue.removeLast());
        assertEquals(0, testQue.size());
        try {
            testQue.removeLast();
            fail("should throw NoSuchElementException ");
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void testPollFirst() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.pollFirst());
        assertEquals(2, testQue.size());
        assertEquals(testObjTwo, testQue.pollFirst());
        assertEquals(testObjThree, testQue.pollFirst());
        assertEquals(0, testQue.size());
        assertNull(testQue.pollFirst());
    }

    @Test
    public void testPollLast() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjThree, testQue.pollLast());
        assertEquals(2, testQue.size());
        assertEquals(testObjTwo, testQue.pollLast());
        assertEquals(testObjOne, testQue.pollLast());
        assertEquals(0, testQue.size());
        assertNull(testQue.pollFirst());
    }

    @Test
    public void testPeekFirst() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.peekFirst());
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.pollFirst());
        assertEquals(testObjTwo, testQue.peekFirst());
        assertEquals(testObjTwo, testQue.pollFirst());
        assertEquals(testObjThree, testQue.pollFirst());
        assertEquals(0, testQue.size());
        assertNull(testQue.peekFirst());
    }

    @Test
    public void testPeekLast() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjThree, testQue.peekLast());
        assertEquals(3, testQue.size());
        assertEquals(testObjThree, testQue.pollLast());
        assertEquals(testObjTwo, testQue.peekLast());
        assertEquals(testObjTwo, testQue.pollLast());
        assertEquals(testObjOne, testQue.pollLast());
        assertEquals(0, testQue.size());
        assertNull(testQue.peekLast());
    }

    @Test
    public void testPush() {
        testQue.push(testObjOne);
        assertEquals(1, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.push(testObjOne);
        assertEquals(2, testQue.size());
        assertEquals(testObjOne, testQue.peek());
        testQue.push(testObjTwo);
        assertEquals(3, testQue.size());
        assertEquals(testObjTwo, testQue.peek());
        assertEquals(testObjOne, testQue.getLast());
        try {
            testQue.push(null);
            fail("should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }

    @Test
    public void testPop() {
        assertTrue(testQue.offerLast(testObjOne));
        assertTrue(testQue.offerLast(testObjTwo));
        assertTrue(testQue.offerLast(testObjThree));
        assertEquals(3, testQue.size());
        assertEquals(testObjOne, testQue.pop());
        assertEquals(2, testQue.size());
        assertEquals(testObjTwo, testQue.pop());
        assertEquals(testObjThree, testQue.pop());
        assertEquals(0, testQue.size());
        try {
            testQue.pop();
            fail("should throw NoSuchElementException ");
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void testSize() {
        assertEquals(0, testQue.size());
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertEquals(2, testQue.size());
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertEquals(4, testQue.size());
        testQue.remove();
        testQue.remove();
        assertEquals(2, testQue.size());
        testQue.clear();
        assertEquals(0, testQue.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testQue.isEmpty());
        assertTrue(testQue.add(testObjOne));
        assertFalse(testQue.isEmpty());
        assertTrue(testQue.add(testObjTwo));
        assertFalse(testQue.isEmpty());
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertFalse(testQue.isEmpty());
        testQue.remove();
        testQue.remove();
        assertFalse(testQue.isEmpty());
        testQue.clear();
        assertTrue(testQue.isEmpty());
    }

    @Test
    public void testIterator() {
        assertFalse(testQue.iterator().hasNext());
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertTrue(testQue.add(testObjLast));
        Iterator result = testQue.iterator();
        assertEquals(5, testQue.size());
        try {
            result.remove();
            fail("should throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
        assertTrue(testQue.add(testObjThree));
        try {
            result.next();
            fail("should throw ConcurrentModificationException");
        } catch (ConcurrentModificationException | AssertionFailedError e) {
            // expected
        }
        result = testQue.iterator();
        assertEquals(testObjOne, result.next());
        assertEquals(testObjTwo, result.next());
        assertEquals(testObjOne, result.next());
        assertEquals(testObjThree, result.next());
        assertEquals(testObjLast, result.next());
        assertTrue(result.hasNext());
        result.remove();
        assertEquals(testObjThree, result.next());
        assertFalse(result.hasNext());
        try {
            result.next();
            fail("should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }
        // test a full array
        ArrayDeque<Object> ad = new ArrayDeque<>();
        // fill the array
        for (int i = 0; i < 16; ++i) {
            ad.addLast(new Object());
        }
        assertTrue(ad.iterator().hasNext());
        Iterator<Object> iter = ad.iterator();
        for (int i = 0; i < 16; ++i) {
            assertTrue(iter.hasNext());
            iter.next();
        }
        iter.remove();
        // test un-full array
        ad = new ArrayDeque<>();
        // fill the array
        for (int i = 0; i < 5; ++i) {
            ad.addLast(new Object());
        }
        iter = ad.iterator();
        for (int i = 0; i < 5; ++i) {
            assertTrue(iter.hasNext());
            iter.next();
        }
        iter.remove();
        ad = new ArrayDeque<>();
        // fill the array
        for (int i = 0; i < 16; ++i) {
            ad.addLast(new Object());
        }
        iter = ad.iterator();
        assertTrue(iter.hasNext());
        for (int i = 0; i < ad.size(); ++i) {
            iter.next();
        }
        assertFalse(iter.hasNext());
        iter.remove();
        ad.add(new Object());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testContains() {
        assertFalse(testQue.contains(testObjFour));
        assertFalse(testQue.contains(null));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertTrue(testQue.add(testObjLast));
        assertTrue(testQue.contains(testObjOne));
        assertTrue(testQue.contains(testObjTwo));
        assertTrue(testQue.contains(testObjThree));
        assertTrue(testQue.contains(testObjLast));
        assertFalse(testQue.contains(null));
        testQue.clear();
        assertFalse(testQue.contains(testObjOne));
        assertFalse(testQue.contains(testObjTwo));
    }

    @Test
    public void testClear() {
        assertTrue(testQue.isEmpty());
        testQue.clear();
        assertTrue(testQue.isEmpty());
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        testQue.clear();
        assertTrue(testQue.isEmpty());
    }

    @Test
    public void testClone() {
        ArrayDeque<Object> cloned = testQue.clone();
        assertEquals(0, cloned.size());
        assertNotSame(cloned, testQue);
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjTwo));
        assertTrue(testQue.add(testObjOne));
        assertTrue(testQue.add(testObjThree));
        assertTrue(testQue.add(testObjLast));
        assertTrue(testQue.add(testQue));
        cloned = testQue.clone();
        assertEquals(6, cloned.size());
        while (0 != testQue.size()) {
            assertEquals(testQue.remove(), cloned.remove());
        }
    }
}
