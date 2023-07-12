package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;

    @Column(nullable = false, length = 3)
    private String name;

    @ManyToMany
    @JoinTable(name = "countries_continents",
               joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    private List<Continent> continent;

    public Country() {
    }
}
