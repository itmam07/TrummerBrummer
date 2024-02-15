/**
 * @author : Itmam Alam
 * @class : ModelA
 * @created : 15.11.2023
 **/

package KraVer_Alam;

public class ModelA extends Model {
    private int feeYear;

    private ModelA(String name, String insuranceNumber, int feeYear) {
        super(name, insuranceNumber);
        this.feeYear = feeYear;
    }

    public static Model CreateModel(String name, String insuranceNumber, int feeYear) {
        if (isValid(name, insuranceNumber))
            return new ModelA(name, insuranceNumber, feeYear);
        return null;
    }

    @Override
    public double getFee() {
        return feeYear;
    }

    @Override
    public double getRet(int hospitalDays) {
        return getFee() / 40;
    }
}
