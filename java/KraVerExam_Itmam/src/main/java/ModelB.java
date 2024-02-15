public class ModelB extends Model {
    private double feeYear;
    private double feeMonth;
    private ModelB(String name, String insuranceNumber, double feeYear, double feeMonth) {
        super(name, insuranceNumber);
        this.feeYear = feeYear;
    }

    public static Model createModel(String name, String insuranceNumber, double feeYear, double feeMonth) {
        if (isValid(name, insuranceNumber))
            return new ModelB(name, insuranceNumber, feeYear, feeMonth);
        return null;
    }

    public double getFee() {
        return feeYear + 12 * feeMonth;
    }

    public double getRet(int hospitalDays) {
        if (hospitalDays <= 10)
            return getFee() / 45 * hospitalDays;
        else if (hospitalDays <= 20)
            return getFee() / 45 * hospitalDays * 10 +
                   getFee() / 40 * hospitalDays * (18-hospitalDays);
        else
            return getFee() / 45 * hospitalDays * 10 +
                   getFee() / 40 * hospitalDays * 10 +
                   getFee() / 35 * hospitalDays * (hospitalDays - 20);
    }


}
