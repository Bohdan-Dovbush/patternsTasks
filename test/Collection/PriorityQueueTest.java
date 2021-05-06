package Collection;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PriorityQueueTest extends TestCase {

    @Test
    public void testIterator() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<Integer>();
        Integer[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }
        Iterator<Integer> iter = integerQueue.iterator();
        assertNotNull(iter);
        ArrayList<Integer> iterResult = new ArrayList<Integer>();
        while (iter.hasNext()) {
            iterResult.add(iter.next());
        }
        Object[] resultArray = iterResult.toArray();
        Arrays.sort(array);
        Arrays.sort(resultArray);
        assertTrue(Arrays.equals(array, resultArray));

        PriorityQueue<Integer> integerQueues = new PriorityQueue<>();
        Iterator<Integer> iters = integerQueues.iterator();
        try {
            iters.next();
            fail("should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }
        iters = integerQueue.iterator();
        try {
            iters.remove();
            fail("should throw IllegalStateException");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void testSize() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        assertEquals(0, integerQueue.size());
        int[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }
        assertEquals(array.length, integerQueue.size());
    }

    @Test
    public void testPoll() {
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        String[] array = { "MYTESTSTRING", "AAAAA", "BCDEF", "ksTRD", "AAAAA" };
        for (int i = 0; i < array.length; i++) {
            stringQueue.offer(array[i]);
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], stringQueue.poll());
        }
        assertEquals(0, stringQueue.size());
        assertNull(stringQueue.poll());

        PriorityQueue<Object> queue = new PriorityQueue<>();
        assertEquals(0, queue.size());
        assertNull(queue.poll());
    }

    @Test
    public void testPeek() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        int[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.add(array[i]);
        }
        Arrays.sort(array);
        assertEquals(Integer.valueOf(array[0]), integerQueue.peek());
        assertEquals(Integer.valueOf(array[0]), integerQueue.peek());

        PriorityQueue<Object> queue = new PriorityQueue<>();
        assertEquals(0, queue.size());
        assertNull(queue.peek());
        assertNull(queue.peek());
    }

    @Test
    public void testСlear() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        int[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }
        integerQueue.clear();
        assertTrue(integerQueue.isEmpty());
    }

    @Test
    public void testAdd() {
        PriorityQueue<Object> queue = new PriorityQueue<>();
        queue.add(10);
        try {
            queue.add(null);
            fail("should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
        try {
            queue.add(1.3);
            fail("should throw ClassCastException");
        } catch (ClassCastException e) {
            // expected
        }
        queue = new PriorityQueue<>();
        queue.add(10);
        try {
            queue.add(new Object());
            fail("should throw ClassCastException");
        } catch (ClassCastException e) {
            // expected
        }

        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        Integer[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.add(array[i]);
        }
        Arrays.sort(array);
        assertEquals(array.length, integerQueue.size());
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], integerQueue.poll());
        }
        assertEquals(0, integerQueue.size());
    }

    @Test
    public void testRemove() {
        Integer[] array = { 2, 45, 7, -12, 9, 23, 17, 1118, 10, 16, 39 };
        List<Integer> list = Arrays.asList(array);
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>(list);
        assertFalse(integerQueue.remove(null));
        assertTrue(integerQueue.remove(16));
        Integer[] newArray = { 2, 45, 7, -12, 9, 23, 17, 1118, 10, 39 };
        Arrays.sort(newArray);
        for (int i = 0; i < newArray.length; i++) {
            assertEquals(newArray[i], integerQueue.poll());
        }
        assertEquals(0, integerQueue.size());
        PriorityQueue<Integer> integerQueues = new PriorityQueue<>(list);
        assertFalse(integerQueues.remove(111));
        assertFalse(integerQueues.remove(null));
        assertFalse(integerQueues.remove(""));
    }

    @Test
    public void testContains() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        Integer[] array = { 2, 45, 7, -12, 9 };
        for (int i = 0; i < array.length; i++) {
            integerQueue.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            assertTrue(integerQueue.contains(array[i]));
        }
        assertFalse(integerQueue.contains(null));
    }
}
