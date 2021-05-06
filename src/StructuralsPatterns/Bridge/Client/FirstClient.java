package StructuralsPatterns.Bridge.Client;

import StructuralsPatterns.Bridge.Role.Role;

public class FirstClient extends Client {

    public FirstClient(Role role){
        super(role);
    }

    @Override
    public Role createRole() {
        System.out.print("Create your role with First Client. ");
        return role;
    }
}
