package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository<Player>{
    Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Player player) {
        if(player == null)
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        this.models.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return this.models.remove(player);
    }

    @Override
    public Player findByName(String username) {
        return this.models
                .stream()
                .filter(p->p.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Player> getModels() {
        return models;
    }
}
