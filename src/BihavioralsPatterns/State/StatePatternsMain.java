package BihavioralsPatterns.State;

import BihavioralsPatterns.State.Activity.Activity;
import BihavioralsPatterns.State.Activity.Sleeping;

public class StatePatternsMain {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();

        developer.setActivity(activity);

        for (int i = 0; i < 10; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}
