package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column
    private String model;
    @Column
    private double price;
    @Column
    private String type;
    @Column(name = "load_capacity")
    private double loadCapacity;
    @ManyToMany(targetEntity = Driver.class, mappedBy = "trucks")
    private List<Driver> drivers;

    public Truck() {
    }

    public Truck(String fuelType, String model, double price, String type, double loadCapacity) {
        this.fuelType = fuelType;
        this.model = model;
        this.price = price;
        this.type = type;
        this.loadCapacity = loadCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
