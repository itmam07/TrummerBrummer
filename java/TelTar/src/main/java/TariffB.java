/*
 * author: Itmam Alam
 * class: TariffB
 * date: 30.09.2023
 * */

public class TariffB extends Tariff {

    private double feeMonth;
    private double feeMinute;

    private TariffB(String desc, String number, double feeMonth, double feeMinute) {
        super(desc, number);
        setFeeMonth(feeMonth);
        setFeeMinute(feeMinute);
    }

    public static TariffB getTariff(String desc, String number, double feeMonth, double connectionFee) {
        return new TariffB(desc, number, feeMonth, connectionFee);
    }

    @Override
    public String getInfo() {
        return getDesc() + ", Fee " + getFeeMonth() + "€/month and " + getFeeMinute() + "€/minute";
    }

    @Override
    public double getFee(int x) {
        return ((x * getFeeMinute()) + getFeeMonth());
    }

    @Override
    public int getBonusPoints(int x) {
        if (x <= 1000) {
            return x;
        } else if (x <= 2000) {
            return 1000 + (x - 1000) * 2;
        } else {
            return 1000 + 2000 + (x - 2000) * 3;
        }
    }

    public void setFeeMonth(double feeMonth) {
        this.feeMonth = feeMonth;
    }

    public double getFeeMonth() {
        return feeMonth;
    }

    public void setFeeMinute(double feeMinute) {
        this.feeMinute = feeMinute;
    }

    public double getFeeMinute() {
        return feeMinute;
    }
}
