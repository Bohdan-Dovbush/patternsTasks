package generic.util;

public class Tree {
    public int val;
    public Tree left = null;
    public Tree right = null;

    public Tree(int val) {
        this.val = val;
    }

    public Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
