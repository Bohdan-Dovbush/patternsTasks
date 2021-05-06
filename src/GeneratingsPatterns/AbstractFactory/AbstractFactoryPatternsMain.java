package GeneratingsPatterns.AbstractFactory;

import GeneratingsPatterns.Role.Role;
import GeneratingsPatterns.Factory.RoleFactory;

public class AbstractFactoryPatternsMain{
    public static void main(String[] args) {
        RoleFactory roleFactory = new RoleFactory();

        Role userRole = roleFactory.getRole("User");
        userRole.roleType();
        Role adminRole = roleFactory.getRole("Admin");
        adminRole.roleType();
    }
}
