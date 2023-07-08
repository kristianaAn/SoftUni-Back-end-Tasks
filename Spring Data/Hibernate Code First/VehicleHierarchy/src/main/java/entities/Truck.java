package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    private final static String TYPE = "TRUCK";
    @Column
    private double loadCapacity;

    protected Truck(){}
    public Truck(double loadCapacity) {
        super(TYPE);
        this.loadCapacity = loadCapacity;
    }
}
