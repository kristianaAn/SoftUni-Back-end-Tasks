package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;

    @Column(name = "position_description")
    private String positionDescription;

    public Position() {
    }
}
