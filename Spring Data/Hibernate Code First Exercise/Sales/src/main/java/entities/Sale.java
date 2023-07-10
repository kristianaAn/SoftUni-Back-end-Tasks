package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date date;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private StoreLocation storeLocation;

    public Sale() {
    }
}
