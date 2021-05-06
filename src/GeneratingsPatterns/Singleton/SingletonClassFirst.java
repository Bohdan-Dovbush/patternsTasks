package GeneratingsPatterns.Singleton;

public class SingletonClassFirst {
    private static volatile SingletonClassFirst client = null;
    private SingletonClassFirst() { }

    public static SingletonClassFirst getClient() {
        if(client == null){
            synchronized (SingletonClassFirst.class){
                if(client == null){
                    client = new SingletonClassFirst();
                }
            }
        }
        return client;
    }
    public void setUp() {
        System.out.println("setFirst");
    }
}
