package Collection;

import Collection.Helper.Person;
import Collection.Helper.PersonComparator;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

class PersonComparatorTest extends TestCase {

    @Test
    void compare() {
        PersonComparator personComparator = new PersonComparator();
        SortedSet<Person> set = new TreeSet<>(personComparator);
        assertEquals(set.comparator(), personComparator);
    }
}