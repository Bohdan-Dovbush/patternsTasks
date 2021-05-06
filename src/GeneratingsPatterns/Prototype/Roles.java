package GeneratingsPatterns.Prototype;

abstract class Roles implements Cloneable{
    abstract public void roleType();

    public Object cloneRole()   {
        Object cloneRole = null;
        try {
            cloneRole = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneRole;
    }
}
