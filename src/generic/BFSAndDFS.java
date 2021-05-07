package generic;

import generic.util.SimpleQueue;
import generic.util.SimpleStack;
import generic.util.Tree;

public class BFSAndDFS {

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
