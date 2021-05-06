package StructuralsPatterns.Bridge.Role;

public class UserRole implements Role {
    @Override
    public Role createRole() {
        System.out.println("Created: User role");
        return new UserRole();
    }

    @Override
    public void roleType() {
        System.out.println("It`s a User role");
    }
}
