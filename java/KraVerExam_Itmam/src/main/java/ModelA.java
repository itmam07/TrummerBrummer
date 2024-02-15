public class ModelA extends Model {
    private int feeYear;
    private ModelA(String name, String insuranceNumber, int feeYear) {
        super(name, insuranceNumber);
        this.feeYear = feeYear;
    }
    public static Model createModel(String name, String insuranceNumber, int feeYear) {
        if (isValid(name, insuranceNumber))
            return new ModelA(name, insuranceNumber, feeYear);
        return null;
    }

    public double getFee() {
        return feeYear;
    }

    public double getRet(int hospitalDays) {
        return getFee() / 40;
    }
}
