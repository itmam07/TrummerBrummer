/**
 * @author : Itmam Alam
 * @class : Model
 * @created : 15.11.2023
 **/

package KraVer_Alam;

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
            sum += insuranceNumber.charAt(i);
        }
        return (sum % 4 == 0);
    }

    public void printInfo(int hospitalDays) {
        System.out.println(name + " " + name + ", fee/year: " + getFee() + ", retour: " + getRet(hospitalDays));
    }

    public String getInfo() {
        return name + " " + insuranceNumber + ", fee: " + getFee();
    }

    public abstract double getFee();
    public abstract double getRet(int hospitalDays);
}
