package ma.projet.car;

import ma.projet.car.entities.Car;
import ma.projet.car.services.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory =
				new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		return restTemplate;
	}
	@Bean
	CommandLineRunner commandLineRunner(CarService carService) {
		return args -> {
			if(carService.findAll().isEmpty()) {
				carService.save(new Car(null, "Toyota", "Camry", 12345, 1L));
				carService.save(new Car(null, "Honda", "Civic", 67890, 2L));
				carService.save(new Car(null, "Ford", "Focus", 11223, 3L));
				carService.save(new Car(null, "BMW", "X5", 44556, 1L));
				carService.save(new Car(null, "Mercedes", "C200", 77889, 2L));
			}

		};
	}
}
