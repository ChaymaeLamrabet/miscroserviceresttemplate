package ma.projet.car.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.car.entities.Client;

@Builder
@Data
public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private int matricule;
    private Client client;

    public CarResponse() {
    }

    public CarResponse(Long id, String brand, String model, int matricule, Client client) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.matricule = matricule;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}