package P02Shapes;

public class Rectangle extends Shape{

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2*(this.height + this.width));
    }

    @Override
    public void calculateArea() {
        this.setArea(this.height * this.width);
    }
}
