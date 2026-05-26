
public class Circle {
    private Point center;
    private int radius;
    private Color color;

    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}
