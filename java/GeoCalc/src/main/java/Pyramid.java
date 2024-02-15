/*
 * author: Itmam Alam
 * class: Pyramid
 * date: 07.10.2023
 * */

public class Pyramid extends Geo3D {

    public Pyramid(String desc, Triangle base, int height) {
        super(desc, base, height);
    }

    @Override
    public int getSurfaceArea() {
        return getArea() + (base.getArea() * 4);
    }

    @Override
    public int getVolume() {
        return ((base.getArea() * getHeight()) / 3);
    }
}
