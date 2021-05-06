package Collection.Util;

import java.util.Stack;

public class BugStack<E> extends Stack<E> {
    public void setLength(int elementCount) {
        this.elementCount = elementCount;
    }
}
