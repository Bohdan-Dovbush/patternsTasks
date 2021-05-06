package StructuralsPatterns.Decorator.Role;

public class AdminRole implements Role {
    @Override
    public String getTotalRoles() {
        return "This Role can record ";
    }
}
