package BihavioralsPatterns.ReVisitor;

public class FamilyVisitor implements Visitor{
    @Override
    public void visit(Son son) {
        System.out.println("Son action: "+ son.getAction());
    }
    @Override
    public void visit(Father father) {
        System.out.println("Father action: "+ father.getAction());
    }
}
