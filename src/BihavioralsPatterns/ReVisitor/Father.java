package BihavioralsPatterns.ReVisitor;

public class Father extends Family {
    public Father(String action) {
        super(action);
    }
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }
}
