package BihavioralsPatterns.Iterator;

public class IteratorPatternsMain {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "MySQL"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Dovbush Bohdan", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Family: " + javaDeveloper.getName());
        System.out.print("Skills: ");

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }
    }
}
