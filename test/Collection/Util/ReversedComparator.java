package Collection.Util;

import java.util.Comparator;

public class ReversedComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        return -(((Comparable) o1).compareTo(o2));
    }

    public boolean equals(Object o1, Object o2) {
        return (((Comparable) o1).compareTo(o2)) == 0;
    }
}
