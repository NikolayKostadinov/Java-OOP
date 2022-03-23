package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Collection<Player> civilPlayers;
    private Repository<Gun> gunRepository;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
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
                return GUN_TYPE_INVALID;

        }

        this.gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunRepository.getModels().isEmpty()) return GUN_QUEUE_IS_EMPTY;

        Gun gun = getFirstGun();

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        } else {
            Player player = this.civilPlayers.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
            if (player == null) return CIVIL_PLAYER_DOES_NOT_EXIST;
            player.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        }
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
        String message = "";
        if (mainPlayer.getLifePoints() == MainPlayer.INITIAL_LIFE_POINTS
                && this.civilPlayers.stream().allMatch(p -> p.getLifePoints() == CivilPlayer.INITIAL_LIFE_POINTS)) {
            message = FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, this.civilPlayers.stream().filter(p -> !p.isAlive()).count())).append(System.lineSeparator());
            sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.stream().filter(Player::isAlive).count()));
            message = sb.toString();
        }

        Collection<Player> deadPlayers = civilPlayers.stream().filter(p -> !p.isAlive()).collect(Collectors.toList());
        this.civilPlayers.removeAll(deadPlayers);

        return message;
    }

    private Gun getFirstGun() {
        Gun gun = this.gunRepository.getModels().stream().findFirst().orElse(null);
        this.gunRepository.remove(gun);
        return gun;
    }
}
