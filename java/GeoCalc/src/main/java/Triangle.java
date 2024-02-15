/*
 * author: Itmam Alam
 * class: Triangle
 * date: 07.10.2023
 * */

public class Triangle extends Geo2D {
    public Triangle(String desc, Point p1, Point p2) {
        super(desc, p1, p2);
    }

    @Override
    public int getCircumference() {
        return (getP1().getDistance(getP2()) * 3);
    }

    @Override
    public int getArea() {
        int a = getP1().getDistance(getP2());
        return (int) (Math.round((a * a) * Math.sqrt(3)) / 4); // cast to integer -> Math.round returns double
    }
}
