/*
 * author: Itmam Alam
 * class: Tariff
 * date: 30.09.2023
 * */

abstract class Tariff {

    protected String desc;
    protected TelNumber number;

    public Tariff(String desc, String number) {
        setDesc(desc);
        setNumber(number);
    }

    protected abstract String getInfo();

    protected abstract double getFee(int x);

    protected abstract int getBonusPoints(int x);

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNumber(String number) throws IllegalArgumentException {
        this.number = TelNumber.getInstance(number);
        if (getNumber() == null)
            throw new IllegalArgumentException("Ungültige Telefonnummer: " + number);
    }

    public TelNumber getNumber() {
        return number;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
