package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bet_games")
@Getter
@Setter
public class BetGame implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Game games;

    @Id
    @ManyToOne
    @JoinColumn
    private Bet bet;

    @OneToOne
    private ResultPrediction resultPrediction;

    public BetGame() {
    }
}
