/*
 * author: Itmam Alam
 * class: TariffA
 * date: 30.09.2023
 * */

public class TariffA extends Tariff {

    private int feeMonth;

    private TariffA(String desc, String number, int feeMonth) {
        super(desc, number);
        setFeeMonth(feeMonth);
    }

    public static TariffA getTariff(String desc, String number, int feeMonth) {
        return new TariffA(desc, number, feeMonth);
    }

    @Override
    public String getInfo() {
        return getDesc() + ", Fee: " + getFeeMonth() + "€/month";
    }

    @Override
    public double getFee(int x) {
        return getFeeMonth();
    }

    @Override
    public int getBonusPoints(int x) {
        return x * 2;
    }

    public int getFeeMonth() {
        return feeMonth;
    }

    public void setFeeMonth(int feeMonth) {
        this.feeMonth = feeMonth;
    }
}
