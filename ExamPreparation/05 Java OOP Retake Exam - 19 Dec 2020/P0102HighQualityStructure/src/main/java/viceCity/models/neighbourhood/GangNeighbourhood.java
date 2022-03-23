package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();

        for (Gun gun : guns) {
            while (gun.canFire()) {
                Player player = civilPlayers.stream().filter(pl -> pl.isAlive()).findFirst().orElse(null);
                if (player == null) break;
                player.takeLifePoints(gun.fire());
            }
        }

        for (Player player : civilPlayers) {
            guns = player.getGunRepository().getModels();
            for (Gun gun : guns) {
                while (gun.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }
                if (!mainPlayer.isAlive()) break;
            }
            if (!mainPlayer.isAlive()) break;
        }
    }
}
