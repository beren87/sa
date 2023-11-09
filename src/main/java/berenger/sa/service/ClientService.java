package berenger.sa.service;

import berenger.sa.entites.Client;
import berenger.sa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
        Client clientDansLaBdd = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBdd == null){
            this.clientRepository.save(client);
        }

    }

    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }
}
