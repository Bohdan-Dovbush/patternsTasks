package BihavioralsPatterns.Mediator.Role;

import BihavioralsPatterns.Mediator.Chat.Chat;

public class AdminRole implements Role {

    final Chat chat;
    String name;

    public AdminRole(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message: " + message + ".");
    }
}
