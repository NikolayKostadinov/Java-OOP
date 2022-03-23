package P05JediGalaxy;

public class PlayGround {
    private final int[][] playGround;

    public PlayGround(int dimensionX, int dimensionY) {
        this.playGround = initPlayGround(dimensionX, dimensionY);
    }

    private int[][] initPlayGround(int dimensionX, int dimensionY) {
        int[][] playGround = new int[dimensionX][dimensionY];
        int value = 0;
        for (int i = 0; i < dimensionX; i++) {
            for (int j = 0; j < dimensionY; j++) {
                playGround[i][j] = value++;
            }
        }
        return playGround;
    }

    public int getValue(Point point) {
        return this.playGround[point.getX()][point.getY()];
    }

    public void setValue(Point point, int value) {
        this.playGround[point.getX()][point.getY()] = value;
    }

    public boolean isOverTopLeft(Point point) {
        return point.getX() >= 0 && point.getY() >= 0;
    }

    public boolean isOverTopRight(Point point) {
        return point.getX() >= 0 && point.getY() < this.playGround[0].length;
    }

    public boolean isUnderBottomLeft(Point point) {
        return point.getX() < playGround.length && point.getY() >= 0;
    }

    public boolean isUnderBottomRight(Point point) {
        return point.getX() < playGround.length && point.getY() < this.playGround[0].length;
    }
}
