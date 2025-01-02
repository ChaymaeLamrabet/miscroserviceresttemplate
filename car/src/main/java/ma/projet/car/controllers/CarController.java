package ma.projet.car.controllers;


import ma.projet.car.entities.Car;
import ma.projet.car.models.CarResponse;
import ma.projet.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {
        return carService.findById(id);
    }
    @PostMapping
    public CarResponse save(@RequestBody Car car) {
        return carService.save(car);
    }
}
