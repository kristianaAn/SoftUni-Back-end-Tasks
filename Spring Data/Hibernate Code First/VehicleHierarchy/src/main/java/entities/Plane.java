package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle {
    private final static String TYPE = "PLANE";
    @Column
    private int passengerCapacity;

    protected Plane() {}
    public Plane(int passengerCapacity) {
        super(TYPE);
        this.passengerCapacity = passengerCapacity;
    }
}
