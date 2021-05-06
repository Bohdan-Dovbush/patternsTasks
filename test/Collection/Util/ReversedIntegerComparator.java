package Collection.Util;

import java.util.Comparator;

public class ReversedIntegerComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        return -(((Integer) o1).compareTo((Integer) o2));
    }
}
