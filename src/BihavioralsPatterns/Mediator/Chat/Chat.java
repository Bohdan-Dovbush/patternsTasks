package BihavioralsPatterns.Mediator.Chat;

import BihavioralsPatterns.Mediator.Role.Role;

public interface Chat {
    void sendMessage(String message, Role user);
}
