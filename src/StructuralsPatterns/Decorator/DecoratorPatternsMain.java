package StructuralsPatterns.Decorator;

import StructuralsPatterns.Decorator.ConcreteDecorator.AnotherDecorator;
import StructuralsPatterns.Decorator.ConcreteDecorator.PrivilegeDecorator;
import StructuralsPatterns.Decorator.Role.AdminRole;
import StructuralsPatterns.Decorator.Role.Role;
import StructuralsPatterns.Decorator.Role.UserRole;

public class DecoratorPatternsMain {
    public static void main(String[] args) {

        Role adminRoles = new AdminRole();
        Role userRoles = new UserRole();
        Role adminRolesAndAnotherRoles = new AnotherDecorator(adminRoles);
        Role adminRolesAndPrivilegeRoles = new PrivilegeDecorator(adminRoles);

        //без декоратора
        System.out.println("User " + userRoles.getTotalRoles());
        System.out.println("Admin " + adminRoles.getTotalRoles());

        //з декоратором
        System.out.println("Admin " + adminRolesAndAnotherRoles.getTotalRoles());
        System.out.println("Admin " + adminRolesAndPrivilegeRoles.getTotalRoles());
    }
}
