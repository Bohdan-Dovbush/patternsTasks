package GeneratingsPatterns.AbstractFactory.AbstractFact;

import GeneratingsPatterns.Client.Client;
import GeneratingsPatterns.Role.Role;

public interface AbstractFactory {
    Client getClient(String clientName);

    Role getRole(String roleType);
}
