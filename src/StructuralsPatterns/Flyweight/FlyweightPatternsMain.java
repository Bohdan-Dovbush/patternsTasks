package StructuralsPatterns.Flyweight;

import GeneratingsPatterns.Role.Role;

import java.util.ArrayList;
import java.util.List;

public class FlyweightPatternsMain {
    public static void main(String[] args) {
        RoleFactory roleFactory = new RoleFactory();

        List<Role> roles = new ArrayList<>();

        roles.add(roleFactory.roleTypeS("User"));
        roles.add(roleFactory.roleTypeS("Admin"));

        for (Role role: roles) {
            role.roleType();
        }
    }
}
