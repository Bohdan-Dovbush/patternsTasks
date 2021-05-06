package StructuralsPatterns.Flyweight;

import GeneratingsPatterns.Role.AdminRole;
import GeneratingsPatterns.Role.Role;
import GeneratingsPatterns.Role.UserRole;

import java.util.HashMap;
import java.util.Map;

public class RoleFactory {
    private static final Map<String, Role> roles = new HashMap<>();

    public Role roleTypeS(String s){
        Role role = roles.get(s);

        if(role == null){
            switch (s){
                case "User":
                    System.out.println("Create user ");
                    role = new UserRole();
                    break;
                case "Admin":
                    System.out.println("Create admin");
                    role = new AdminRole();
                    break;
            }
            roles.put(s,role);
        }
        return role;
    }
}
