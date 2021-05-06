package StructuralsPatterns.Decorator.ConcreteDecorator;

import StructuralsPatterns.Decorator.Role.Role;
import StructuralsPatterns.Decorator.Role.RoleDecorator;

public class AnotherDecorator extends RoleDecorator {

    final Role role;
    public AnotherDecorator(Role role){
        super();
        this.role = role;
    }

    public String addAnotherRoles() {
        return "read";
    }

    public String getTotalRoles() {
        return role.getTotalRoles() + " other roles are " + addAnotherRoles();
    }
}
