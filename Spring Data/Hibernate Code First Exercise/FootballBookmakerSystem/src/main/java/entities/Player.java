package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @ManyToOne
    @JoinColumn
    private Team team;

    @ManyToOne
    @JoinColumn
    private Position position;

    @Column(name = "is_currently_injured")
    private boolean isCurrentlyInjured;

    public Player() {
    }
}
