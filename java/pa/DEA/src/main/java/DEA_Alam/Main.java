package DEA_Alam;

public class Main {
    public static void main(String[] args) {
        Machine m1 = new Machine("bankomat_valid.dea");
        System.out.println(m1.run(new String[] {"1", "0", "0"}));
        System.out.println(m1.run(new String[] {"1", "1", "0"}));
        System.out.println(m1.run(new String[] {"1", "1", "1", "1"}));
        System.out.println(m1.run(new String[] {"1", "0"}));
        m1.print(System.out);
    }
}