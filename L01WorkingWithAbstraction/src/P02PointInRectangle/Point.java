package P02PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterThanOrEqual(Point p) {
        return this.x >= p.x && this.y >= p.y;
    }

    public boolean lassThanOrEqual(Point p) {
        return this.x <= p.x && this.y <= p.y;
    }
}
