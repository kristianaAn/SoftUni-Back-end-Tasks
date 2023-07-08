package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {
    private final static String TYPE = "BIKE";

    protected Bike() {
        super(TYPE);
    }
}
