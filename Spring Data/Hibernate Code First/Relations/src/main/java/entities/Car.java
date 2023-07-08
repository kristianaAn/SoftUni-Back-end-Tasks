package entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fuel_type;
    @Column
    private String model;
    @Column
    private double price;
    @Column
    private String type;
    @Column
    private int seats;
    @OneToOne
    private PlateNumber plateNumber;

    public Car() {
    }
}
