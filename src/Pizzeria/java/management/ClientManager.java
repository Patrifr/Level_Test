package management;

import models.Client;

public class ClientManager {

    public Client createNewClient(String name, String address) {
        Client newClient = new Client(name, address);
        return newClient;
    }
}
