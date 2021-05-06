package BihavioralsPatterns.State.Activity;

import BihavioralsPatterns.State.Activity.Activity;

public class Reading implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Reading book...");
    }
}
