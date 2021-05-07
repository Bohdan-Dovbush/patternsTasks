package generic;

import generic.util.SimpleQueue;
import generic.util.SimpleStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BFSAndDFSTest {

    @BeforeEach
    public void setUp() {
        System.out.println("Stack: ");
        testStack();
        System.out.println();
        System.out.println("Queue: ");
        testQueue();
    }

    @Test
    public void testQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            queue.add(i);
        }

        System.out.println("\n");

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    @Test
    public void testStack() {
        SimpleStack<Integer> queue = new SimpleStack<>();
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            queue.push(i);
        }

        System.out.println("\n");

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }

}