package StructuralsPatterns.Decorator.Role;

public class UserRole implements Role {
    @Override
    public String getTotalRoles() {
        return "This Role can read ";
    }
}
