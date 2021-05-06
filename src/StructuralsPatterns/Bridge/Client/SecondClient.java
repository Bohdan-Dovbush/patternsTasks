package StructuralsPatterns.Bridge.Client;

import StructuralsPatterns.Bridge.Role.Role;

public class SecondClient extends Client {

    public SecondClient(Role role){
        super(role);
    }

    @Override
    public Role createRole() {
        System.out.print("Create your role with Second Client. ");
        return role;
    }
}
