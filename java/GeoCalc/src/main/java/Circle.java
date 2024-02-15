/*
 * author: Itmam Alam
 * class: Circle
 * date: 07.10.2023
 * */

public class Circle extends Geo2D {
    private final double PI = 3.141592653589793;
    private int radius;

    public Circle(String desc, Point p1, Point p2) {
        super(desc, p1, p2);
        this.radius = getP1().getDistance(getP2());  // introduce radius, needed by other functions
    }

    @Override
    public int getCircumference() {
        return (int) Math.round(radius * PI);  // cast to integer -> Math.round returns double
    }

    @Override
    public int getArea() {
        return (int) Math.round((radius * radius) * PI);  // cast to integer -> Math.round returns double
    }

    public int getRadius() {
        return radius;
    }
}
