package BihavioralsPatterns.ChainOfResponsibility;

public class SMSNotifier extends Notifier {

    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String massage) {
        System.out.println("Sending SMS to manager: " + massage);
    }
}
