package P05JediGalaxy;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean greaterThanOrEqual(Point p) {
        return this.x >= p.x && this.y >= p.y;
    }

    public boolean lessThan(Point p) {
        return this.x < p.x && this.y < p.y;
    }

    public void decrementX() {
        this.x--;
    }

    public void decrementY() {
        this.y--;
    }

    public void incrementY() {
        this.y++;
    }
}
