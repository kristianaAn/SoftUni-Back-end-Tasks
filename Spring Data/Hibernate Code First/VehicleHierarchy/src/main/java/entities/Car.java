package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private final static String TYPE = "CAR";
    @Column
    private int seats;

    protected Car() {}
    public Car(int seats) {
        super(TYPE);
        this.seats = seats;
    }
}
