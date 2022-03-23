package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = getPlayers(players, "Terrorist");
        List<Player> counterTerrorist = getPlayers(players, "CounterTerrorist");

        while (!allDead(terrorists) && !allDead(counterTerrorist)) {
            attack(terrorists, counterTerrorist);
            attack(counterTerrorist, terrorists);
        }

        return (allDead(terrorists))? OutputMessages.COUNTER_TERRORIST_WINS : OutputMessages.TERRORIST_WINS;
    }

    private boolean allDead(List<Player> players) {
        return players.stream().allMatch(p -> !p.isAlive());
    }

    private void attack(List<Player> attackers, List<Player> defenders) {
        var liveAttackers = getLivePlayers(attackers);
        for (Player attacker : liveAttackers) {
            var liveDefenders = getLivePlayers(defenders);
            for (Player liveDefender : liveDefenders) {
                liveDefender.takeDamage(attacker.getGun().fire());
            }
        }
    }

    private List<Player> getPlayers(Collection<Player> players, String playerType) {
        return players.stream().filter(x -> x.getClass().getSimpleName().equals(playerType)).collect(Collectors.toList());
    }

    private List<Player> getLivePlayers(Collection<Player> players) {
        return players.stream().filter(Player::isAlive).collect(Collectors.toList());
    }
}
