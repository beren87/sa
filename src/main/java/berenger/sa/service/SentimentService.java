package berenger.sa.service;

import berenger.sa.entites.Client;
import berenger.sa.entites.Sentiment;
import berenger.sa.enums.TypeSentiment;
import berenger.sa.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment){
        Client client = this.clientService.LireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> recherche() {
        return this.sentimentRepository.findAll();
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
