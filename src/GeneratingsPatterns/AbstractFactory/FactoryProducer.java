package GeneratingsPatterns.AbstractFactory;

import GeneratingsPatterns.AbstractFactory.AbstractFact.AbstractFactory;
import GeneratingsPatterns.Role.Role;

public class FactoryProducer{

    private final GeneratingsPatterns.Client.Client client;
    private final Role role;
    final static String Client = "Client";
    final static String Role = "Role";

    public FactoryProducer(AbstractFactory factory) {
        client = factory.getClient(Client);
        role = factory.getRole(Role);
    }

    public void getClientAndGetRole() {
        client.clientName();
        role.roleType();
    }
}
