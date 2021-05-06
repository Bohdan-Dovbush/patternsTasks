package BihavioralsPatterns.Strategy;

import BihavioralsPatterns.State.Activity.Coding;
import BihavioralsPatterns.State.Activity.Reading;
import BihavioralsPatterns.State.Activity.Sleeping;
import BihavioralsPatterns.State.Activity.Training;

public class StrategyPatternsMain {
    public static void main(String[] args) {
        Developer developer = new Developer();

        developer.setActivity(new Sleeping());
        developer.executeActivity();

        developer.setActivity(new Training());
        developer.executeActivity();

        developer.setActivity(new Coding());
        developer.executeActivity();

        developer.setActivity(new Reading());
        developer.executeActivity();

        developer.setActivity(new Sleeping());
        developer.executeActivity();
    }
}
