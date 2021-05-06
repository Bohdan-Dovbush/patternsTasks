package BihavioralsPatterns.ReVisitor;

public class Son extends Family {
    public Son(String action) {
        super(action);
    }
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }
}
