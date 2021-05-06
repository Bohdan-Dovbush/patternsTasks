package BihavioralsPatterns.Mediator;

import BihavioralsPatterns.Mediator.Chat.SimpleTextChat;
import BihavioralsPatterns.Mediator.Role.AdminRole;
import BihavioralsPatterns.Mediator.Role.Role;
import BihavioralsPatterns.Mediator.Role.UserRole;

public class MediatorPatternsMain {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();

        Role admin = new AdminRole(chat, "Admin");
        Role user1 = new UserRole(chat, "User 1");
        Role user2 = new UserRole(chat, "User 2");
        Role user3 = new UserRole(chat, "User 3");

        chat.setAdminRole(admin);
        chat.addRoleToChat(user1);
        chat.addRoleToChat(user2);
        chat.addRoleToChat(user3);

        user1.sendMessage("Hello it`s user 1 ");
        admin.sendMessage("Roger that. I am admin ");
    }
}
