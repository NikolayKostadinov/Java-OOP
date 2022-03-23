package P05JediGalaxy;

public class Player {
    private final PlayerType type;
    private final Point position;

    public Player(PlayerType type, Point position) {
        this.type = type;
        this.position = position;
    }

    public void move(){
        if (this.type == PlayerType.EVIL){
            this.position.decrementX();
            this.position.decrementY();
        } else if (this.type == PlayerType.JEDI){
            this.position.decrementX();
            this.position.incrementY();
        }
    }

    public Point getPosition() {
        return position;
    }
}
