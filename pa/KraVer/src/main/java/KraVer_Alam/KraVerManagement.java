/**
 * @author : Itmam Alam
 * @class : KraVerManagement
 * @created : 15.11.2023
 **/

package KraVer_Alam;

public class KraVerManagement {
    public static int MAX = 10;
    public static final int NOT_FOUND = -1;
    private Model[] list;

    public KraVerManagement() {
        this(MAX);
    }

    public KraVerManagement(int size) {
        list = new Model[size];
    }

    public boolean addModel(String name, String insuranceNumber, int feeYear) {
        int id = getID();
        if (id == NOT_FOUND)
            return false;

        list[id] = ModelA.CreateModel(name, insuranceNumber, feeYear);
        return true;
    }

    public boolean addModel(String name, String insuranceNumber, double feeYear, double feeMonth) {
        int id = getID();
        if (id == NOT_FOUND)
            return false;

        list[id] = ModelB.CreateModel(name, insuranceNumber, feeYear, feeMonth);
        return true;
    }

    public void print() {
        for (Model m : list)
            if (m != null)
                System.out.println(m.getInfo());
    }

    public void print(int x) {
        for (Model m : list)
            if (m != null)
                m.printInfo(x);
    }

    public void reset() {
        list = new Model[list.length];
    }

    private int getID() {
        for (int i = 0; i < list.length; i++)
            if (list[i] == null)
                return i;
        return NOT_FOUND;
    }
}
