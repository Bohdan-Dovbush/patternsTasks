package BihavioralsPatterns.ReVisitor;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class VisitorPatternsMain {
    public static void main(String[] args) {
        ArrayList<Family> arr = new ArrayList();
        arr.add(new Son("Homework"));
        arr.add(new Father("Job"));
        arr.add(new Son("Teach"));
        arr.add(new Father("Teacher"));

        Visitor visitor = new FamilyVisitor();
        for(Family a:arr){
            a.Accept(visitor);
        }
    }
}

