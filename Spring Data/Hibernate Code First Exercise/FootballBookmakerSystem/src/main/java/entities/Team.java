package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false, length = 3)
    private String initials;

    @ManyToOne
    @JoinColumn
    private Color primaryKitColor;

    @ManyToOne
    @JoinColumn
    private Color secondaryKitColor;

    @ManyToOne
    @JoinColumn
    private Town town;

    @Column
    private double budget;

    public Team() {
    }
}
