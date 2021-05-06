package StructuralsPatterns.Bridge.Role;

public class AdminRole implements Role {
    @Override
    public Role createRole() {
        System.out.println("Created: Admin role");
        return new AdminRole();
    }

    @Override
    public void roleType() {
        System.out.println("It`s a Admin role");
    }
}
