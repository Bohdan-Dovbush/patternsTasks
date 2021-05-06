package Collection;

import Collection.Helper.Product;

import java.util.LinkedList;
import java.util.Queue;

import static Collection.Helper.Print.println;

@SuppressWarnings("ALL")
public class QueueExample {

	private static final Queue<Product> productsQueue = new LinkedList();

	public static Queue<Product> getProductsQueue() {
		return productsQueue;
	}

	public static void main(String[] args) {
        
		//Some Manual Testing
		addProductsToTheQueue();
		println(productsQueue);
		println(productsQueue.poll()); // retrieves and removes the head of the queue
		println(productsQueue.poll());
		println(productsQueue); // printing the queue again
	}

	public static void addProductsToTheQueue() {
		productsQueue.add(new Product("Iphone 5s", 125)); // name and weight
		productsQueue.add(new Product("Protein Shaker", 349));
		productsQueue.add(new Product("Milk Chocolate", 200));
		productsQueue.add(new Product("Sweet Candy", 19));
		productsQueue.add(new Product("Pink Milk Cup", 99));
	}
}
