package Collection.Helper;

public class Print {
	
	public Print() {}
	
	public static void println(Object message) {
		System.out.println(""+message);
	}

	public static void prettyPrint(String title, Object message) {
		System.out.println("------------ "+title+" ------------");
		System.out.println(""+message);
		System.out.println("------------ ------------ ------------");
	}
}
