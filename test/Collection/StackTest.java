package Collection;

import Collection.Util.BugStack;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest extends TestCase {

    Stack s;

    @BeforeEach
    protected void setUp() {
        s = new Stack();
    }

    @Test
    public void testEmpty() {
        assertTrue("New stack answers non-empty", s.empty());
        s.push("blah");
        assertFalse("Stack should not be empty but answers empty", s.empty());
        s.pop();
        assertTrue("Stack should be empty but answers non-empty", s.empty());
        s.push(null);
        assertFalse("Stack with null should not be empty but answers empty", s.empty());
    }

    @Test
    public void testPeek() {
        String item1 = "One";
        String item2 = "Two";
        String item3 = "Tree";
        s.push(item1);
        assertSame("Peek did not return top item when it was the only item", s.peek(), item1);
        s.push(item2);
        s.push(item3);
        assertSame("Peek did not return top item amount many other items", s.peek(), item3);
        s.pop();
        assertSame("Peek did not return top item after a pop", s.pop(), item2);
        s.push(null);
        assertNull("Peek did not return top item (wanted: null)", s.peek());
        s.pop();
        s.pop();
        try {
            s.pop();
            fail("EmptyStackException expected");
        } catch (EmptyStackException e) {
            //expected
        }
    }

    @Test
    public void testPop() {
        String item1 = "One";
        String item2 = "Two";
        Object lastPopped;
        s.push(item1);
        s.push(item2);
        try {
            lastPopped = s.pop();
            assertSame("a) Pop did not return top item", lastPopped, item2);
        } catch (EmptyStackException e) {
            fail("a) Pop threw EmptyStackException when stack should not have been empty");
        }
        try {
            lastPopped = s.pop();
            assertSame("b) Pop did not return top item", lastPopped, item1);
        } catch (EmptyStackException e) {
            fail("b) Pop threw EmptyStackException when stack should not have been empty");
        }
        s.push(null);
        try {
            lastPopped = s.pop();
            assertNull("c) Pop did not return top item", lastPopped);
        } catch (EmptyStackException e) {
            fail("c) Pop threw EmptyStackException when stack should not have been empty");
        }
        try {
            lastPopped = s.pop();
            assertNotNull(lastPopped);
            fail("d) Pop did not throw EmptyStackException when stack should have been empty");
        } catch (EmptyStackException e) {//
        }
    }

    @Test
    public void testPush() {
        Object [] array = {0, new Object()};
        Stack<Object> stack = new Stack<>();
        for (Object o : array) {
            stack.push(o);
        }
        for(int i = 0; i < array.length; i++) {
            assertEquals(array.length - i, stack.search(array[i]));
        }
    }

    @Test
    public void testSearch() {
        String item1 = "One";
        String item2 = "Two";
        String item3 = "Tree";
        s.push(item1);
        s.push(item2);
        s.push(item3);
        assertEquals("Search returned incorrect value for equivalent object", 3, s.search(item1));
        assertEquals("Search returned incorrect value for equal object", 3, s.search("One"));
        s.pop();
        assertEquals("Search returned incorrect value for equivalent object at top of stack", 1, s.search(item2));
        assertEquals("Search returned incorrect value for equal object at top of stack", 1, s.search("Two"));
        s.push(null);
        assertEquals("Search returned incorrect value for search for null at top of stack", 1, s.search(null));
        s.push("Tree");
        assertEquals("Search returned incorrect value for search for null", 2, s.search(null));
        s.pop();
        s.pop();
        assertEquals("Search returned incorrect value for search for null--wanted -1", -1, s.search(null));
    }

    @Test
    public void testPopModifyElement() {
        BugStack<String> testStack = new BugStack<>();
        testStack.push("A");
        testStack.push("B");
        testStack.setLength(20);
        try {
            testStack.pop();
            fail("Should throw ArrayIndexOutOfBoundsException here");
        } catch (ArrayIndexOutOfBoundsException e) {
            //Expected to throw ArrayIndexOutOfBoundsException here
        } catch (EmptyStackException e) {
            fail("Should throw ArrayIndexOutOfBoundsException here");
        }
    }
}
