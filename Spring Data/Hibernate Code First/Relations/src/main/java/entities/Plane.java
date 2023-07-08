package entities;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class Plane {
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
    @Column
    private String airline;
    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    @ManyToOne
    private Company company;

    public Plane() {
    }
}
