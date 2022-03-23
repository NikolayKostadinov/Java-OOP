package viceCity.models.players;

public class MainPlayer extends BasePlayer{

    public static final int LIFE_POINTS = 100;
    public static final String PLAYER_NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(PLAYER_NAME, LIFE_POINTS);
    }
}
