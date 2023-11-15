/**
 * @author : Itmam Alam
 * @class : ModelB
 * @created : 15.11.2023
 **/

package KraVer_Alam;

public class ModelB extends Model {
    private double feeYear;
    private double feeMonth;

    private ModelB(String name, String insuranceNumber, double feeYear, double feeMonth) {
        super(name, insuranceNumber);
        this.feeYear = feeYear;
        this.feeMonth = feeMonth;
    }

    public static Model CreateModel(String name, String insuranceNumber, double feeYear, double feeMonth) {
        if (isValid(name, insuranceNumber))
            return new ModelB(name, insuranceNumber, feeYear, feeMonth);
        return null;
    }

    public double getFee() {
        return feeYear + 12 * feeMonth;
    }

    @Override
    public double getRet(int hospitalDays) {
        if (hospitalDays <= 10)
            return getFee() / 45 * hospitalDays;
        else if (hospitalDays <= 50)
            return (getFee() / 45 * hospitalDays * 10) +
                   (getFee() / 45 * hospitalDays * (18 - hospitalDays));
        else
            return (getFee() / 45 * hospitalDays * 10) +
                   (getFee() / 45 * hospitalDays * 10) +
                   (getFee() / 35 * hospitalDays * (hospitalDays - 20));
    }
}
