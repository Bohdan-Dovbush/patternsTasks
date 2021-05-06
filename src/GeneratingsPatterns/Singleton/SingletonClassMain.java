package GeneratingsPatterns.Singleton;

public class SingletonClassMain {
    public static void main(String[] args) {
        SingletonClassFirst singletonClassFirst = SingletonClassFirst.getClient();
        singletonClassFirst.setUp();
        SingletonClassSecond singletonClassSecond = SingletonClassSecond.getClient();
        singletonClassSecond.setUp();
    }
}
