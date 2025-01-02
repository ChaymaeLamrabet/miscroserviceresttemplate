package ma.projet.client;

import ma.projet.client.entities.Client;
import ma.projet.client.repositories.ClientRepository;
import ma.projet.client.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientService clientService) {
		return args -> {
			if (clientService.findAll().isEmpty()) {  // Only insert if empty
				clientService.addClient(new Client(null,"Rabab SELIMANI",23f));
				clientService.addClient(new Client(null,"Amal RAMI",22f));
				clientService.addClient(new Client(null,"Samin SAFI",22f));
			}
		};
	}
}
