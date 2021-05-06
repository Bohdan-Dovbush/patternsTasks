package GeneratingsPatterns.Factory;

import GeneratingsPatterns.AbstractFactory.AbstractFact.AbstractFactory;
import GeneratingsPatterns.Client.Client;
import GeneratingsPatterns.Role.AdminRole;
import GeneratingsPatterns.Role.Role;
import GeneratingsPatterns.Role.UserRole;

public class RoleFactory implements AbstractFactory {
    final String User_Role = "User";
    final String Admin_Role = "Admin";

    @Override
    public Client getClient(String clientName) {
        return null;
    }

    @Override
    public Role getRole(String roleType) {
        if (User_Role.equals(roleType)) {
            return new UserRole();
        } else if (Admin_Role.equals(roleType)) {
            return new AdminRole();
        }
        return null;
    }
}

