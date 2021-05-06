package Collection;

import Collection.Helper.Product;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("ALL")
class QueueExampleTests extends TestCase {

	QueueExample qe = new QueueExample();
	Queue<Product> productsQueue = new LinkedList();
	
	@BeforeEach
	protected void setUp() {
		productsQueue = qe.getProductsQueue();
	}

	@Test
	void testQueueIsEmpty() {
		assertTrue(productsQueue.isEmpty());
	}
	
	@Test
	void testQueueIsNotEmpty() {
		qe.addProductsToTheQueue();
		assertFalse(productsQueue.isEmpty());
	}

	@Test
	void testQueueSize() {
		qe.addProductsToTheQueue();
		assertEquals(5, qe.getProductsQueue().size());
	}
}
