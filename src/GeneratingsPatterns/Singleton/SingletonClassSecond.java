package GeneratingsPatterns.Singleton;

public class SingletonClassSecond {
    private static final SingletonClassSecond client = new SingletonClassSecond();
    private SingletonClassSecond() { }

    public static SingletonClassSecond getClient() {
        return client;
    }
    public void setUp() {
        System.out.println("setSecond");
    }
}
