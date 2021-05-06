package Collection.Helper;

import java.util.concurrent.atomic.AtomicInteger;

public class Store {
	private int id;
	private String name;

	public Store(String name) {
		AtomicInteger ID_GENERATOR = new AtomicInteger();
		id = ID_GENERATOR.getAndIncrement();
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
