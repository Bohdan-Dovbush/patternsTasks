package StructuralsPatterns.Proxy;

import GeneratingsPatterns.Role.AdminRole;
import GeneratingsPatterns.Role.Role;

public class ProxyAdminRole implements Role {

    private Role adminRole;

    public void roleType() {
        if(adminRole == null){
            adminRole = new AdminRole();
        }
        adminRole.roleType();
    }
}
