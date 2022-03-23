package viceCity.core;

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
import java.util.List;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> civilPlayers;
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
        String message = null;
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                message = GUN_TYPE_INVALID;
                break;
        }
        if (gun != null) {
            message = String.format(GUN_ADDED, name, type);
            this.gunRepository.add(gun);
        }
        return message;
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.gunRepository.getModels().isEmpty())
            return GUN_QUEUE_IS_EMPTY;

        if (name.equals("Vercetti")) {
            String gunName = addGunToPlayer(mainPlayer);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunName, this.mainPlayer.getName());
        }

        Player player = this.civilPlayers
                .stream()
                .filter(pl -> pl.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (player == null)
            return CIVIL_PLAYER_DOES_NOT_EXIST;

        String gunName = addGunToPlayer(player);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunName, name);
    }

    private String addGunToPlayer(Player player) {
        Gun gun = this.gunRepository.getModels().stream().findFirst().orElse(null);
        player.getGunRepository().add(gun);
        this.gunRepository.remove(gun);
        return gun.getName();
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);

        boolean allLivePointsCivilPlayers = this.civilPlayers.stream()
                .allMatch(pl -> pl.getLifePoints() == CivilPlayer.LIFE_POINTS);
        if (mainPlayer.getLifePoints() == MainPlayer.LIFE_POINTS
                && allLivePointsCivilPlayers) {
            return FIGHT_HOT_HAPPENED;
        }

        long deadPlayersCount = this.civilPlayers.stream().filter(pl -> !pl.isAlive()).count();

        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED);
        sb.append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayersCount));
        sb.append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.size() - deadPlayersCount));

        return sb.toString();
    }
}
