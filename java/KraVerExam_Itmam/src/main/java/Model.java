public abstract class Model {
    private String name;
    private String insuranceNumber;

    public Model(String name, String insuranceNumber) {
        this.name = name;
        this.insuranceNumber = insuranceNumber;
    }

    public static boolean isValid(String name, String insuranceNumber) {
        if (name.length() < 6 || insuranceNumber.length() != 8)
            return false;

        int sum = 0;
        for (int i = 0; i < insuranceNumber.length(); i++) {
            sum += insuranceNumber.charAt(i) - '0';
        }

        return (sum % 4 == 0);
    }

    public void printInfo(int hospitalDays) {
        System.out.println(name+" " + name + ", " + "fee/year: " + getFee() + ", retour:" + getRet(hospitalDays));
    }

    public abstract double getFee();
    public abstract double getRet(int hospitalDays);
}
