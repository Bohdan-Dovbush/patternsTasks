package BihavioralsPatterns.State.Activity;

import BihavioralsPatterns.State.Activity.Activity;

public class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
