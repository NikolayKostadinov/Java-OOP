package viceCity.models.players;

public class MainPlayer extends BasePlayer{

    public static final int INITIAL_LIFE_POINTS = 100;
    public static final String MAIN_PLAYER_NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(MAIN_PLAYER_NAME, INITIAL_LIFE_POINTS);
    }
}
