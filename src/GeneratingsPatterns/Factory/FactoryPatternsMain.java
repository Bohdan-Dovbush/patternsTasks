package GeneratingsPatterns.Factory;
import GeneratingsPatterns.Role.Role;

public class FactoryPatternsMain {
    public static void main(String[] args) {
        RoleFactory roleFactory = new RoleFactory();

        Role userRole = roleFactory.getRole("User");
        userRole.roleType();
        Role adminRole = roleFactory.getRole("Admin");
        adminRole.roleType();
    }
}
