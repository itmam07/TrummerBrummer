/*
 * author: Itmam Alam
 * class: Cylinder
 * date: 07.10.2023
 * */

public class Cylinder extends Geo3D {
    private int radius;

    public Cylinder(String desc, Circle base, int height) {
        super(desc, base, height);
        this.radius = base.getRadius();
    }

    @Override
    public int getSurfaceArea() {
        return (2 * getArea()) + (getCircumference() * getHeight());
    }

    @Override
    public int getVolume() {
        return getArea() * getHeight();
    }
}
