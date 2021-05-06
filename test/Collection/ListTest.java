package Collection;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class ListTest extends TestCase {

    List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
    }

    @Test
    public void test_add() {
        // Adding items to arrayList
        list.add("new Item");
        assertEquals(5, list.size());
    }

    @Test
    public void testContains() {
        assertTrue(list.contains("Item1"));
        assertFalse(list.contains("Item5"));
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testIsEmpty() {
        // Checking if array list is empty
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemove() {
        // removing the item in index 0
        list.remove(0);
        assertEquals(3, list.size());
        assertEquals("Item2", list.get(0));
        assertEquals("Item3", list.get(1));
        assertEquals("Item4", list.get(2));

        // removing the first occurrence of item "Item3"
        list.remove("Item3");
        assertEquals(2, list.size());
        assertEquals("Item2", list.get(0));
        assertEquals("Item4", list.get(1));
    }

    @Test
    public void testReplace() {
        list.set(1, "NewItem");
        assertEquals("Item1", list.get(0));
        assertEquals("NewItem", list.get(1));
        assertEquals("Item3", list.get(2));
        assertEquals("Item4", list.get(3));
    }
}
