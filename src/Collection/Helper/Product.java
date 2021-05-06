package Collection.Helper;

public class Product {
	
	//variables
	private String name;
	private final int weight;
	
	//constructor
	public Product(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	//getters
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Product { Name: " +name+ ", Weight: " +weight+ " }";
	}
	
}
