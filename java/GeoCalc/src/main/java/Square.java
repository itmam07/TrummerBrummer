/*
 * author: Itmam Alam
 * class: Square
 * date: 07.10.2023
 * */

public class Square extends Geo2D {
    public Square(String desc, Point p1, Point p2) {
        super(desc, p1, p2);
    }

    @Override
    public int getCircumference() {
        return (getP1().getDistance(getP2()) * 4);
    }

    @Override
    public int getArea() {
        int a = getP1().getDistance(getP2());
        return a * a;
    }
}
