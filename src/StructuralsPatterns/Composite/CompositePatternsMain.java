package StructuralsPatterns.Composite;

import GeneratingsPatterns.Role.AdminRole;
import GeneratingsPatterns.Role.UserRole;

public class CompositePatternsMain {
    public static void main(String[] args) {
        AdminRole adminRole = new AdminRole();

        UserRole userRole1 = new UserRole();
        UserRole userRole2 = new UserRole();
        UserRole userRole3 = new UserRole();

        CompositeClientRole compositeClientRole = new CompositeClientRole();
        CompositeClientRole compositeClientRole1 = new CompositeClientRole();
        CompositeClientRole compositeClientRole2 = new CompositeClientRole();

        compositeClientRole1.add(adminRole);
        compositeClientRole2.add(userRole1);
        compositeClientRole2.add(userRole2);
        compositeClientRole2.add(userRole3);

        compositeClientRole.add(compositeClientRole1);
        compositeClientRole.add(compositeClientRole2);

        compositeClientRole.roleType();
    }
}
