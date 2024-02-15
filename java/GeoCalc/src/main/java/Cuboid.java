/*
 * author: Itmam Alam
 * class: Cuboid
 * date: 07.10.2023
 * */

public class Cuboid extends Geo3D {

    public Cuboid(String desc, Square base, int height) {
        super(desc, base, height);
    }

    @Override
    public int getSurfaceArea() {
        return getArea() * 6;
    }

    @Override
    public int getVolume() {
        return getArea() * getArea() * getArea();
    }
}
