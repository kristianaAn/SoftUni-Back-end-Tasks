package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Collection<Player> playerCollection;
    private GunRepository gunRepository;
    private Player mainPlayer;

    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        playerCollection = new ArrayList<>();
        gunRepository = new GunRepository();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        playerCollection.add(civilPlayer);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }

        gunRepository.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, gun.getClass().getSimpleName());
    }

    @Override
    public String addGunToPlayer(String name) {
        Player playersSearch = playerCollection.stream()
                .filter(player -> player.getName()
                        .equals(name))
                .findFirst().orElse(null);
        String civilPlayerGunName;

        if (gunRepository.getModels().isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            Gun firstGun = this.gunRepository.getModels().stream().findFirst().get();
            mainPlayer.getGunRepository().add(firstGun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, firstGun.getName(), mainPlayer.getName());
        } else if (playersSearch == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            Gun gunToBeAdded = this.gunRepository.getModels().stream().findFirst().get();
            playersSearch.getGunRepository().add(gunToBeAdded);
            civilPlayerGunName = gunToBeAdded.getName();
        }
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, civilPlayerGunName, name);
    }

    @Override
    public String fight() {
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        int mainPlayerInitialLifePoints = this.mainPlayer.getLifePoints();
        int civilPlayersInitialCount = this.playerCollection.size();
        int initialSumLifePoints = playerCollection.stream().mapToInt(Player::getLifePoints).sum();

        gangNeighbourhood.action(mainPlayer, playerCollection);

        int sumLifePointsAfterFight = playerCollection.stream().mapToInt(Player::getLifePoints).sum();
        int deadPlayers = civilPlayersInitialCount - playerCollection.size();

        if (mainPlayer.getLifePoints() == mainPlayerInitialLifePoints
                && playerCollection.size() == civilPlayersInitialCount
                && initialSumLifePoints == sumLifePointsAfterFight) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(ConstantMessages.FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, playerCollection.size()));
            return sb.toString();
        }
    }
}
