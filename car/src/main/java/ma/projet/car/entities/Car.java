package ma.projet.car.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int matricule;
    private Long cliend_id;


    public Car() {
    }

    public Car(Long id, String brand, String model, int matricule, Long cliend_id) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.matricule = matricule;
        this.cliend_id = cliend_id;
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

    public Long getCliend_id() {
        return cliend_id;
    }

    public void setCliend_id(Long cliend_id) {
        this.cliend_id = cliend_id;
    }
}
