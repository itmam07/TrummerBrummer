/*
 * author: Itmam Alam
 * class: Geo
 * date: 07.10.2023
 * */

abstract class Geo {
    private String desc;
    private int circumference;
    private int area;

    public Geo(String desc) {
        setDesc(desc);
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void println() {
        System.out.println(getDesc());
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public abstract int getCircumference();

    public abstract int getArea();
}
