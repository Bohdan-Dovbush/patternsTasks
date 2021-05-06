package Collection;

import java.util.*;

import static Collection.Helper.Print.prettyPrint;
import static Collection.Helper.Print.println;

public class ListExample {

	private static final List<Integer> listOfNumbers = new ArrayList<>();
	private static final Collection<Integer> c = new LinkedList<>();

	public static void main(String[] args) {

		addNumbers();
		println(listOfNumbers); // prints the arraylist contents
		// return index of first occurrence of an element
		prettyPrint("Find the index of number '5' in the list", "Index: " + listOfNumbers.indexOf(5));
		println("List Size" + listOfNumbers.size());

		// using a list iterator to iterate through the list
		ListIterator<Integer> listIterator = listOfNumbers.listIterator();
		int i = 0;
		while (i <= listOfNumbers.size() - 1) {
			prettyPrint("List Iteration", "Index: " + i + " |||| Number: " + listIterator.next());
			i++;
		}

	}

	public static void addNumbers() {
		c.add(5);
		c.add(3);
		listOfNumbers.add(0);
		listOfNumbers.add(1);
		c.addAll(listOfNumbers);
		listOfNumbers.addAll(2, c);
	}

}
