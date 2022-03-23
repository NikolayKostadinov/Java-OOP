package P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player player = this.players.stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Player %s is not in %s team.", playerName, this.name))
                );

        this.players.remove(player);
    }

    public double getRating() {
        return this.players.stream()
                .map(Player::overallSkillLevel)
                .mapToDouble(Double::doubleValue)
                .average().orElse(0);
    }
}
