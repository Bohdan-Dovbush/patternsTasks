package BihavioralsPatterns.State.Activity;

import BihavioralsPatterns.State.Activity.Activity;

public class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
