package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String fullName;
    @ManyToMany
    @JoinTable(name = "d_t",
            joinColumns = @JoinColumn(name = "d_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "t_id", referencedColumnName = "id"))
    private List<Truck> trucks;

    public Driver() {
    }

    public Driver(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
