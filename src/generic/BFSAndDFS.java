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
        SimpleQueue<Tree> queue = new SimpleQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return "Wide";
    }
}
