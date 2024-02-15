/*
 * author: Itmam Alam
 * class: Prism
 * date: 07.10.2023
 * */

public class Prism extends Geo3D {
    public Prism(String desc, Triangle base, int height) {
        super(desc, base, height);
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
