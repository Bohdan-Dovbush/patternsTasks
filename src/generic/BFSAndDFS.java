package generic;

import generic.util.SimpleQueue;
import generic.util.SimpleStack;
import generic.util.Tree;

public class BFSAndDFS {
    public static void main(String[] params) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)),
                                new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        System.out.println(wide(root));
        System.out.println();
        System.out.println(deep(root));
    }

    public static String deep(Tree root) {
        SimpleStack<Tree> stack = new SimpleStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return "Deep";
    }

    public static String wide(Tree root) {
        SimpleQueue<Tree> stack = new SimpleQueue<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Tree node = stack.remove();
            System.out.println(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return "Wide";
    }
}
