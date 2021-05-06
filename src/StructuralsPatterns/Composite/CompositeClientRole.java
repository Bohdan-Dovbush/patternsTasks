package StructuralsPatterns.Composite;

import GeneratingsPatterns.Role.Role;

import java.util.ArrayList;
import java.util.List;

public class CompositeClientRole implements Role {

    private final List<Role> childRoles = new ArrayList<>();

    @Override
    public void roleType() {
        for (Role role : childRoles) {
            role.roleType();
        }
    }

    public void add(Role role){
        childRoles.add(role);
    }

    public void remove(Role role){
        childRoles.remove(role);
    }
}
