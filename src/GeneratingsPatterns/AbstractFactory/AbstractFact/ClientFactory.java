package GeneratingsPatterns.AbstractFactory.AbstractFact;

import GeneratingsPatterns.Client.Client;
import GeneratingsPatterns.Client.FirstClient;
import GeneratingsPatterns.Client.SecondClient;
import GeneratingsPatterns.Role.Role;

public class ClientFactory implements AbstractFactory {

    final String First_Client = "First";
    final String Second_Client = "Second";

    @Override
    public Client getClient(String clientName) {
        if (First_Client.equalsIgnoreCase(clientName)) {
            return new FirstClient();
        } else if (Second_Client.equalsIgnoreCase(clientName)) {
            return new SecondClient();
        }
        return null;
    }

    @Override
    public Role getRole(String roleType) {
        return null;
    }
}
