package BihavioralsPatterns.ChainOfResponsibility;

public abstract class Notifier {
    private final int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String massage, int level){
        if(level >= priority){
            write(massage);
        }
        if(nextNotifier != null){
            nextNotifier.notifyManager(massage, level);
        }
    }

    public abstract void write(String massage);
}
