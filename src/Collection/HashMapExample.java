package Collection;

import Collection.Helper.Book;
import Collection.Helper.Store;

import java.util.ArrayList;
import java.util.HashMap;

import static Collection.Helper.Print.*;

@SuppressWarnings("ALL")
public class HashMapExample {

	// this map stores store as key and book as value for the HashMap
	private static final HashMap<Store, Book> availableBooksInDifferentStores = new HashMap<>();

	// this map stores store as key and an array of books as Value for the HashMap
	private static final HashMap<Store, Book[]> bookStores = new HashMap<>();

	// this arraylist stores all the books
	private static final ArrayList<Book> books = new ArrayList<>();

	// this arraylist stores all the stores available
	private static final ArrayList<Store> stores = new ArrayList<>();

	public static void main(String[] args) {
		getBooks();
		printAllBooks();
		printBookAtIndex();

		getStores();
		printAllStores();

		addAvailableBooksInDifferentStoresToTheHashMap();
		addBooksToTheStores();
		printAllTheBooksInAnStore();

	}

	private static void printAllTheBooksInAnStore() {
		prettyPrint("", "There are " + bookStores.size() + " Stores available in the bookStores HashMap");
		int index = 1;
		
		Book[] booksArray = bookStores.get(stores.get(index));
		booksArray[0].setName("New Edition: The Jungle Book");//updating a books name
		bookStores.put(stores.get(index), booksArray);
		println("There are " + booksArray.length + " books available in this book store - Store Name: "
				+ stores.get(index).getName());
		
		// printing all the available books in a store
		for (Book book : booksArray) {
			println(book.getName());
		}

	}

	private static void addBooksToTheStores() {
		Book[] booksArray = new Book[books.size()]; // setting the array size to the size of books arrayList
		for (int i = 0; i <= stores.size() - 1; i++) {
			for (int j = 0; j <= books.size() - 1; j++) {
				Book book = books.get(j);
				booksArray[j] = book;
				println(booksArray[j].getName());
				bookStores.put(stores.get(i), booksArray);
			}
			println("Store name: " + stores.get(i).getName());
		}
	}

	private static void addAvailableBooksInDifferentStoresToTheHashMap() {
		for (int i = 0; i <= stores.size() - 1; i++) {
			for (int j = 0; j <= books.size() - 1; j++) {
				availableBooksInDifferentStores.put(stores.get(i), books.get(j));
				println("Store name: " + stores.get(i).getName() + " ----- Book Name: " + books.get(j).getName());
			}
		}
	}

	private static void getBooks() {
		books.add(new Book("The Jungle King", new String[] { "Billu Cheetah", "Gillu Lion", "Tillu Monkey" }));
		books.add(new Book("Gym and Nutrition", new String[] { "Navjot Singh Virk" }));
		books.add(new Book("Money Machine", new String[] { "Chiku Robbins", "Chuck Adams" }));
		books.add(new Book("Foreign Students Misery", new String[] { "Navjot Singh Virk" }));
	}

	private static void getStores() {
		stores.add(new Store("Easons"));
		stores.add(new Store("Twinkle Tisons"));

	}

	private static void printBookAtIndex() {
		Book book = books.get(0);
		println("Id: " + book.getId());
		println("Name: " + book.getName());
		println("Quantity: " + book.getQuantity());
		println("Price: " + book.getPrice() + " �");
		int i = 0;
		for (String author : book.getAuthors()) {
			println("Author Name " + i + ": " + author);
			i++;
		}

	}

	private static void printAllBooks() {
		prettyPrint("All Books", "");
		for (int index = 0; index <= books.size() - 1; index++) {
			Book book = books.get(index);
			println("Id: " + book.getId());
			println("Name: " + book.getName());
			println("Quantity: " + book.getQuantity());
			println("Price: " + book.getPrice() + " �");
			int i = 0;
			for (String author : book.getAuthors()) {
				println("Author Name " + i + ": " + author);
				i++;
			}
			println("---------------------------");
		}
	}

	private static void printAllStores() {
		prettyPrint("All Stores", "");
		for (int index = 0; index <= stores.size() - 1; index++) {
			Store store = stores.get(index);
			println("Id: " + store.getId());
			println("Name: " + store.getName());
			println("--------------------------");
		}
	}
}
