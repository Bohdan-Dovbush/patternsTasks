package BihavioralsPatterns.Mediator.Chat;

import BihavioralsPatterns.Mediator.Role.Role;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextChat implements Chat {
    Role admin;
    final List<Role> roles = new ArrayList<>();


    public void setAdminRole(Role admin) {
        this.admin = admin;
    }

    public void addRoleToChat(Role role){
        this.roles.add(role);
    }

    @Override
    public void sendMessage(String message, Role role) {
        for (Role r: roles) {
            if(r != role){
                r.getMessage(message);
            }
        }
        admin.getMessage(message);
    }


}
