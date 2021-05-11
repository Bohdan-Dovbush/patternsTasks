package Collection.set;

import Collection.SetExample;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static Collection.Helper.Print.println;

@SuppressWarnings("ALL")
class SetExampleTest extends TestCase {
	@Test
	void testSize() {
		SetExample s = new SetExample();
		Set <String> names = new HashSet<>();
		SetExample.addValuesTo(names);
		println(names.toString());
		
		//assertEquals(expected value, actual value)
		assertEquals(6, names.size());	
	}
	
	@Test
	void testIsEmpty() {
		SetExample s = new SetExample();
		Set <String> names = new HashSet<>();

		assertTrue(true);
	}
	
	@Test
	void testContains() {
		SetExample s = new SetExample();
		Set <String> names = new HashSet<>();
		s.addValuesTo(names);

		//Asserts that a condition is true.
		assertTrue(names.contains("Navjot Singh"));
		//Asserts that a condition is false.
		assertFalse(names.contains("Cat"));
	}
	
	@Test
	void testRemove() {
		SetExample s = new SetExample();
		Set <String> names = new HashSet<>();
		s.addValuesTo(names);

		//testing if the following names exists in the set
		assertTrue(names.contains("Navjot Singh"));
		assertTrue(names.contains("Jashan Deep"));
		
		//remove the names from the set
		names.remove("Navjot Singh");
		names.remove("Jashan Deep");
		
		//test/check if the names were removed or still exist in the set
		assertFalse(names.contains("Navjot Singh"));
		assertFalse(names.contains("Jashan Deep"));
	}

}
