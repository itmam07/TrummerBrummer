/*
 * author: Itmam Alam
 * class: Geo2D
 * date: 07.10.2023
 * */

abstract class Geo2D extends Geo {
    private Point p1;
    private Point p2;

    public Geo2D(String desc, Point p1, Point p2) {
        super(desc);
        setP1(p1);
        setP2(p2);
    }

    public abstract int getCircumference();

    public abstract int getArea();

    public void println() {
        System.out.println("\n2D Object - " + getDesc());
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public Point getP1() {
        return p1;
    }

    private void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    private void setP2(Point p2) {
        this.p2 = p2;
    }
}