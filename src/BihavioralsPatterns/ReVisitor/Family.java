package BihavioralsPatterns.ReVisitor;

public abstract class Family {
    private String action;
    public Family(String action) {
        this.action = action;
    }
    public abstract void Accept(Visitor visitor);
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
}
