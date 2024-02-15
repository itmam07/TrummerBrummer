/*
 * author: Itmam Alam
 * class: Geo3D
 * date: 07.10.2023
 * */

abstract class Geo3D extends Geo {
    protected Geo2D base;
    protected int height;
    private int surface;
    private int volume;

    public Geo3D(String desc, Geo2D base, int height) {
        super(desc);
        setBase(base);
        setHeight(height);
    }

    abstract int getSurfaceArea();

    abstract int getVolume();

    public int getCircumference() {
        return base.getCircumference();
    }

    public int getArea() {
        return base.getArea();
    }

    public void println() {
        System.out.println("\n3D Object - " + getDesc());
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
        System.out.println("Surface Area: " + getSurfaceArea());
        System.out.println("Volume: " + getVolume());
    }

    private void setBase(Geo2D base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }
}
