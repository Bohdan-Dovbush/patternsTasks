package generic;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    public void testSuccessSearch() {
        Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        BinarySearch<Integer> search = new BinarySearch<Integer>()
                .in(a).comparator(Comparator.comparingInt(o -> o));

        for(int i=0; i<a.length; i++) {
            BinarySearch.Result result = search.search(i);
            assertTrue(result.success);
            assertEquals(result.index, i);
        }
    }

    @Test
    public void testAddArraySize() {
        Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        BinarySearch<Integer> search = new BinarySearch<Integer>()
                .in(a).comparator(Comparator.comparingInt(o -> o));

        for(int i=0; i<a.length; i++) {
            BinarySearch.Result result = search.search(i);
            assertTrue(result.success);
            assertEquals(result.index, i);
        }
    }

    @Test
    public void testFails() {
        Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13 };
        BinarySearch<Integer> search = new BinarySearch<Integer>()
                .in(a).comparator(Comparator.comparingInt(o -> o));

        BinarySearch.Result result = search.search(-1);
        assertFalse(result.success);
        assertEquals(result.index, 0);

        result = search.search(8);
        assertFalse(result.success);
        assertEquals(result.index, 8);

        result = search.search(9);
        assertFalse(result.success);
        assertEquals(result.index, 8);

        result = search.search(100500);
        assertFalse(result.success);
        assertEquals(result.index, a.length);

    }
}