package StructuralsPatterns.Bridge.Client;

import StructuralsPatterns.Bridge.Role.Role;

public abstract class Client {
   protected final Role role;
   public Client(Role role){
       this.role = role;
   }
   public abstract Role createRole();
}
