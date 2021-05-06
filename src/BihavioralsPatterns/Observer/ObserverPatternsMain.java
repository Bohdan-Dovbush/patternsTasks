package BihavioralsPatterns.Observer;

public class ObserverPatternsMain {
    public static void main(String[] args) {
        JavaDeveloperJobSite javaDeveloperJobSite = new JavaDeveloperJobSite();

        javaDeveloperJobSite.addVacancy("Junior Java Family");
        javaDeveloperJobSite.addVacancy("Middle Java Family");

        Observer firstSubscriber = new Subscriber("Bohdan Dovbush");
        Observer secondSubscriber = new Subscriber("Yurij Dovbush");

        javaDeveloperJobSite.addObserver(firstSubscriber);
        javaDeveloperJobSite.addObserver(secondSubscriber);

        javaDeveloperJobSite.addVacancy("Senior Java Family");

        javaDeveloperJobSite.removeVacancy("Junior Java Family");
    }
}
