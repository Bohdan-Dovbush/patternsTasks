package generic;

import generic.util.SimpleQueue;
import generic.util.SimpleStack;
import generic.util.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static generic.BFSAndDFS.deep;
import static generic.BFSAndDFS.wide;

class BFSAndDFSTest {
    Tree root;
    SimpleStack<Integer> stack = new SimpleStack<>();
    SimpleQueue<Integer> queue = new SimpleQueue<>();
    @BeforeEach
    public void setUp() {
        root = new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)),
                                new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println();
    }

    @Test
    public void testQueue() {
        System.out.println("Queue: ");
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            queue.add(i);
        }
        System.out.println("\n");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        System.out.println();
    }

    @Test
    public void testStack() {
        System.out.println("Stack: ");
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            stack.push(i);
        }
        System.out.println("\n");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println();
    }

    @Test
    void testDeep() {
        System.out.println(deep(root));
    }

    @Test
    void testWide() {
        System.out.println(wide(root));
    }
}