package ma.projet.car.services;

import ma.projet.car.entities.Car;
import ma.projet.car.entities.Client;
import ma.projet.car.models.CarResponse;
import ma.projet.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String CLIENT_API = "http://localhost:8888/SERVICE-CLIENT/api/client/";

    public List<CarResponse> findAll() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new Exception("Car not found"));
        return mapToCarResponse(car);
    }
    public CarResponse save(Car car) {
        // Verify client exists before saving
        try {
            Client client = restTemplate.getForObject(CLIENT_API + car.getCliend_id(), Client.class);
            if (client != null) {
                Car savedCar = carRepository.save(car);
                return mapToCarResponse(savedCar);
            }
            throw new Exception("Client not found");
        } catch (Exception e) {
            throw new RuntimeException("Error saving car: " + e.getMessage());
        }
    }

    private CarResponse mapToCarResponse(Car car) {
        Client client = restTemplate.getForObject(CLIENT_API + car.getCliend_id(), Client.class);

        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setBrand(car.getBrand());
        response.setModel(car.getModel());
        response.setMatricule(car.getMatricule());
        response.setClient(client);
        return response;
    }
}