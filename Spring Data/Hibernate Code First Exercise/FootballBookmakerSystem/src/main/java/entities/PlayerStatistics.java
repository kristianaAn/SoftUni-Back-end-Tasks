package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
@Getter
@Setter
public class PlayerStatistics implements Serializable {
    @Id
    @ManyToOne
    private Game game; //PK

    @Id
    @ManyToOne
    @JoinColumn
    private Player player; //PK

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column(name = "player_assists")
    private int playerAssists;

    @Column(name = "played_minutes_during_game")
    private int playedMinutesDuringGame;

    public PlayerStatistics() {
    }
}
