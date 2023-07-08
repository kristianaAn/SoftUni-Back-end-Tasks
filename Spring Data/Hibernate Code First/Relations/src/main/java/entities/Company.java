package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "company", targetEntity = Plane.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plane> planes;

    public Company() {
    }
}
