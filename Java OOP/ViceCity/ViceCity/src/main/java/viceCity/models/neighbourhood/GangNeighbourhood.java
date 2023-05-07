package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> gunCollection = mainPlayer.getGunRepository().getModels();

        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : gunCollection) {
                while (civilPlayer.isAlive() && gun.getTotalBullets() > 0) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
                if (!civilPlayer.isAlive()) {
                    civilPlayers.remove(civilPlayer);
                } else if (gun.getTotalBullets() <= 0) {
                    gunCollection.remove(gun);
                }
            }
        }

        for (Player remainingPlayer : civilPlayers) {
            Collection<Gun> guns = remainingPlayer.getGunRepository().getModels();
            for (Gun gun : guns) {
                while (mainPlayer.isAlive() && gun.getTotalBullets() > 0) {
                    mainPlayer.takeLifePoints(gun.fire());
                }
            }
        }
    }
}
