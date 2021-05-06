package StructuralsPatterns.Bridge;

import StructuralsPatterns.Bridge.Client.Client;
import StructuralsPatterns.Bridge.Client.FirstClient;
import StructuralsPatterns.Bridge.Client.SecondClient;
import StructuralsPatterns.Bridge.Role.AdminRole;
import StructuralsPatterns.Bridge.Role.Role;
import StructuralsPatterns.Bridge.Role.UserRole;

public class BridgePatternsMain {
    public static void main(String[] args) {
        Client first = new FirstClient(new UserRole());
        Role user = first.createRole();
        user.roleType();
        Client second = new SecondClient(new AdminRole());
        Role admin = second.createRole();
        admin.roleType();
    }
}
