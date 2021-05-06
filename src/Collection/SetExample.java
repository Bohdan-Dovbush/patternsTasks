package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static Collection.Helper.Print.*;

public class SetExample {

	// HashSet | Use where order and sorting is not important
	private static final Set<String> names = new HashSet<>();
	
	//LinkedHashet | Use where the order in which elements are added is important
	private static final Set<String> namesInOrder = new LinkedHashSet<>();
	
	//TreeSet | Use where you require sorted results
	private static final Set<String> sortedNames = new TreeSet<>();

	public static void main(String[] args) {

		// adding values to the set (HashSet) and printing the values
		addValuesTo(names);
		prettyPrint("HashSet Results", names.toString());
		
		//example 1 - iteration through the set
		for(String name: names) {
			println(name);
		}
		
		//example 2 - does set contains a given element
		String name = "Navjot Singh"; //change this value to test for different names
		if(names.contains(name)) {
			println("Set Contains: "+name+" == "+true);
		}else {
			println("Set Contains: "+name+" == "+false);
		}
		
		//example 2 - using a switch statement
		int i; //since switch doesn't work with booleans, for demo purpose we will use 0 for false, and 1 for true
		if(names.contains(name)) {
			i = 1;
		}else { i = 0; }
		
		switch(i) {
		case 0:
			println("Set Contains: "+name+" == "+false);
			break;
		case 1:
			println("Set Contains: "+name+" == "+true);
			break;
		default: 
			println("Something went wrong");
			break;
		}
		
		// adding the values to LinkedHashSet (this set remembers the order) and printing
		addValuesTo(namesInOrder);
		prettyPrint("LinkedHashSet Results", namesInOrder.toString());

		// adding the values to TreeSet(this set sorts the elements) and printing
		addValuesTo(sortedNames);
		prettyPrint("TreeSet Results", sortedNames.toString());

	}

	/*
	 * this function receives the variable name of the set, and allows us to add
	 * values to the set according to its type - HashSet, LinkedHashSet, or TreeSet
	 * and removes the need to repeat code in order to demonstrate all types of sets
	 * with the same input values
	 */
	public static void addValuesTo(Set<String> name) {
		name.add("Navjot Singh");
		name.add("Jashan Deep");
		name.add("Ranbir Singh");
		name.add("Amrit Singh");
		name.add("Baljinder Kaur");
		name.add("Kuldeep Virk");
		println("No. of Elements: "+name.size());
		
		//duplicate values (In sets duplicates are ignored)
		
		name.add("Ranbir Singh");
		name.add("Amrit Singh");
		name.add("Baljinder Kaur");
		name.add("Kuldeep Virk");
		println("No. of Elements after adding duplicates: "+name.size());

	}
}
