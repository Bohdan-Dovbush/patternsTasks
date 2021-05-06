package Collection.Helper;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {
	final int id;
	final int quantity;
	final Double price;
	String name;
	final String[] authors;
	final AtomicInteger ID_GENERATOR = new AtomicInteger();
	final Random randomNumber = new Random();

	public Book(String name, String[] authors) {
		id = ID_GENERATOR.incrementAndGet();
		this.quantity = randomNumber.nextInt(500);
		this.price = Math.random();
		this.name = name;
		this.authors = authors;

	}
	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAuthors() {
		return authors;
	}

}
