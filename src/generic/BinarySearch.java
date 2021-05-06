package generic;

import java.util.Comparator;

public class BinarySearch<T> {

    T[] objects;
    Comparator<? super T> comparator;
    private int first;
    private int last;

    public BinarySearch<T> in(T[] objects) {
        this.objects = objects;
        this.first = 0;
        this.last = objects.length;
        return this;
    }

    public BinarySearch<T> comparator(Comparator<? super T> comparator) {
        this.comparator = comparator;
        return this;
    }

    public Result search(T x) {
        return search(objects, first, last, x, comparator);
    }

    public static class Result {
        public final boolean success;
        public final int index;

        public Result(boolean success, int index) {
            this.success = success;
            this.index = index;
        }
    }

    public static <T> Result search(T[] objects, int first, int last, T x, Comparator<? super T> comparator) {

        if(objects.length < last) {
            last = objects.length;
        }
        if (last == 0) {
            // not found, if you need to insert the element then in position 0
            return new Result(false, 0);
        }

        int cmp = comparator.compare(objects[first], x);
        if (cmp > 0) {
            // not found, if you need to insert the element then in first position
            return new Result(false, first);
        } else if(cmp == 0) {
            return new Result(true, first);
        }

        cmp = comparator.compare(objects[last - 1],x);

        if (cmp < 0) {
            // not found, if you need to insert element then in last position
            return new Result(false, last);
        } else if (cmp == 0) {
            return new Result(true, last-1);
        }

        while (first < last) {
            int mid = first + (last - first) / 2;

            cmp = comparator.compare(x, objects[mid]);
            if (cmp < 0) {
                last = mid;
            } else if (cmp == 0) {
                return new Result(true, mid);
            } else {
                first = mid + 1;
            }
        }

        if (comparator.compare(objects[last], x) == 0) {
            return new Result(true, last);
        } else {
            // Not found, if you need to insert the element then it's place - last
            return new Result(false, last);
        }
    }
}
