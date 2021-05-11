package Collection.set;

import Collection.Util.EmptyEnum;
import Collection.Util.EnumFoo;
import Collection.Util.HugeEnum;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class EnumSetTest extends TestCase {

    @Test
    public void testRemove() {
        Set<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        Enum[] elements = EnumFoo.class.getEnumConstants();
        for (Enum element : elements) {
            set.add((EnumFoo) element);
        }
        boolean result = set.remove(null);
        assertFalse("'set' does not contain null", result);
        result = set.remove(EnumFoo.a);
        assertTrue("Should return true", result);
        result = set.remove(EnumFoo.a);
        assertFalse("Should return false", result);
        assertEquals("Size of set should be 63:", 63, set.size());
        // test enum with more than 64 elements
        Set<HugeEnum> hugeSet = EnumSet.allOf(HugeEnum.class);
        result = hugeSet.remove(null);
        assertFalse("'set' does not contain null", result);
        result = hugeSet.remove(HugeEnum.a);
        assertTrue("Should return true", result);
        result = hugeSet.remove(HugeEnum.a);
        assertFalse("Should return false", result);
        assertEquals("Size of set should be 64:", 64, hugeSet.size());
    }

    @Test
    public void testEquals() {
        Set<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        Enum[] elements = EnumFoo.class.getEnumConstants();
        for (Enum element : elements) {
            set.add((EnumFoo) element);
        }
        assertNotEquals("Should return false", null, set);
        assertNotEquals("Should return false", set, new Object());
        Set<EnumFoo> anotherSet = EnumSet.noneOf(EnumFoo.class);
        elements = EnumFoo.class.getEnumConstants();
        for (Enum element : elements) {
            anotherSet.add((EnumFoo) element);
        }
        assertEquals("Should return true", set, anotherSet);
        anotherSet.remove(EnumFoo.a);
        assertNotEquals("Should return false", set, anotherSet);
        // test enum type with more than 64 elements
        Set<HugeEnum> hugeSet;
        hugeSet = EnumSet.allOf(HugeEnum.class);
        assertNull(hugeSet);
        assertEquals(hugeSet, new Object());
        Set<HugeEnum> anotherHugeSet = EnumSet.allOf(HugeEnum.class);
        anotherHugeSet.remove(HugeEnum.a);
        assertEquals(hugeSet, anotherHugeSet);
    }

    @Test
    public void testClear() {
        Set<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        set.add(EnumFoo.a);
        set.add(EnumFoo.b);
        assertEquals("Size should be 2", 2, set.size());
        set.clear();
        assertEquals("Size should be 0", 0, set.size());
        // test enum type with more than 64 elements
        Set<HugeEnum> hugeSet = EnumSet.allOf(HugeEnum.class);
        assertEquals(65, hugeSet.size());
        boolean result = hugeSet.contains(HugeEnum.aa);
        assertTrue(result);
        hugeSet.clear();
        assertEquals(0, hugeSet.size());
        result = hugeSet.contains(HugeEnum.aa);
        assertFalse(result);
    }

    @Test
    public void testSize() {
        Set<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        set.add(EnumFoo.a);
        set.add(EnumFoo.b);
        assertEquals("Size should be 2", 2, set.size());
        // test enum type with more than 64 elements
        Set<HugeEnum> hugeSet = EnumSet.noneOf(HugeEnum.class);
        hugeSet.add(HugeEnum.a);
        hugeSet.add(HugeEnum.bb);
        assertEquals("Size should be 2", 2, hugeSet.size());
    }

    @Test
    public void test_contains() {
        Set<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        Enum[] elements = EnumFoo.class.getEnumConstants();
        for (Enum element : elements) {
            set.add((EnumFoo) element);
        }
        boolean result = set.contains(null);
        assertFalse("Should not contain null:", result);
        result = set.contains(EnumFoo.a);
        assertTrue("Should contain EnumFoo.a", result);
        result = set.contains(EnumFoo.ll);
        assertTrue("Should contain EnumFoo.ll", result);
        result = set.contains(EnumFoo.b);
        assertTrue("Should contain EnumFoo.b", result);
        result = set.contains(new Object());
        assertFalse("Should not contain Object instance", result);
        set = EnumSet.noneOf(EnumFoo.class);
        set.add(EnumFoo.aa);
        set.add(EnumFoo.bb);
        set.add(EnumFoo.cc);
        assertEquals("Size of set should be 3", 3, set.size());
        assertTrue("set should contain EnumFoo.aa", set.contains(EnumFoo.aa));
        // test enum type with more than 64 elements
        Set<HugeEnum> hugeSet = EnumSet.allOf(HugeEnum.class);
        hugeSet.add(HugeEnum.a);
        result = hugeSet.contains(HugeEnum.a);
        assertTrue(result);
        result = hugeSet.contains(HugeEnum.b);
        assertTrue(result);
        result = hugeSet.contains(null);
        assertFalse(result);
        result = hugeSet.contains(HugeEnum.a);
        assertTrue(result);
        result = hugeSet.contains(HugeEnum.ll);
        assertTrue(result);
        result = hugeSet.contains(new Object());
        assertFalse(result);
        result = hugeSet.contains(Enum.class);
        assertFalse(result);
    }

    @Test
    public void testContainsAll() {
        EnumSet<EnumFoo> set = EnumSet.noneOf(EnumFoo.class);
        Enum[] elements = EnumFoo.class.getEnumConstants();
        for (Enum element : elements) {
            set.add((EnumFoo) element);
        }
        try {
            set.containsAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
        EnumSet<EmptyEnum> emptySet = EnumSet.noneOf(EmptyEnum.class);
        elements = EmptyEnum.class.getEnumConstants();
        for (Enum element : elements) {
            emptySet.add((EmptyEnum) element);
        }
        boolean result = set.containsAll(emptySet);
        assertTrue("Should return true", result);
        Collection rawCollection = new ArrayList();
        result = set.containsAll(rawCollection);
        assertTrue("Should contain empty collection:", result);
        rawCollection.add(1);
        result = set.containsAll(rawCollection);
        assertFalse("Should return false", result);
        EnumSet rawSet = EnumSet.noneOf(EnumFoo.class);
        result = set.containsAll(rawSet);
        assertTrue("Should contain empty set", result);
        emptySet = EnumSet.noneOf(EmptyEnum.class);
        result = set.containsAll(emptySet);
        assertTrue("No class cast should be performed on empty set", result);
        Collection<EnumFoo> collection = new ArrayList();
        collection.add(EnumFoo.a);
        result = set.containsAll(collection);
        assertTrue("Should contain all elements in collection", result);
        EnumSet<EnumFoo> fooSet = EnumSet.noneOf(EnumFoo.class);
        fooSet.add(EnumFoo.a);
        result = set.containsAll(fooSet);
        assertTrue("Should return true", result);
        set.clear();
        try {
            set.containsAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
        // test enum type with more than 64 elements
        Set<HugeEnum> hugeSet = EnumSet.noneOf(HugeEnum.class);
        hugeSet.add(HugeEnum.a);
        hugeSet.add(HugeEnum.b);
        hugeSet.add(HugeEnum.aa);
        hugeSet.add(HugeEnum.bb);
        hugeSet.add(HugeEnum.cc);
        hugeSet.add(HugeEnum.dd);
        Set<HugeEnum> anotherHugeSet = EnumSet.noneOf(HugeEnum.class);
        hugeSet.add(HugeEnum.b);
        hugeSet.add(HugeEnum.cc);
        result = hugeSet.containsAll(anotherHugeSet);
        assertTrue(result);
        try {
            hugeSet.containsAll(null);
            fail("Should throw NullPointerException");
        } catch(NullPointerException e) {
            // expected
        }
        rawCollection = new ArrayList();
        result = hugeSet.containsAll(rawCollection);
        assertTrue("Should contain empty collection:", result);
        rawCollection.add(1);
        result = hugeSet.containsAll(rawCollection);
        assertFalse("Should return false", result);
        rawSet = EnumSet.noneOf(HugeEnum.class);
        result = hugeSet.containsAll(rawSet);
        assertTrue("Should contain empty set", result);
        Collection<HugeEnum> hugeCollection = new ArrayList();
        hugeCollection.add(HugeEnum.a);
        result = hugeSet.containsAll(hugeCollection);
        assertTrue("Should contain all elements in collection", result);
        hugeSet.clear();
        try {
            hugeSet.containsAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }
}
