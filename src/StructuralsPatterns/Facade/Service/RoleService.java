package StructuralsPatterns.Facade.Service;

import GeneratingsPatterns.Role.AdminRole;
import GeneratingsPatterns.Role.Role;

public class RoleService {
    public static Role getRole() {
        return new AdminRole();
    }
}
