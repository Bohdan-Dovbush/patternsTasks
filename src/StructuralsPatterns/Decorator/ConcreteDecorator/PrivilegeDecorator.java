package StructuralsPatterns.Decorator.ConcreteDecorator;

import StructuralsPatterns.Decorator.Role.Role;
import StructuralsPatterns.Decorator.Role.RoleDecorator;

public class PrivilegeDecorator extends RoleDecorator {

    final Role role;
    public PrivilegeDecorator(Role role) {
        this.role = role;
    }

    public String addAnotherRoles() {
        return "read and see all";
    }

    public String getTotalRoles() {
        return role.getTotalRoles() + " other roles are " + addAnotherRoles();
    }
}
