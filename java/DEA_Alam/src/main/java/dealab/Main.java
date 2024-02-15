/**
 * @author: Itmam Alam
 * @class: Main
 * @created: 23.10.2023
 **/

package dealab;

public class Main {
    public static void main(String[] args) {
        Machine a = new Machine("aut1_valid.dea");
        Machine b = new Machine("aut1_invalid.dea");
        Machine c = new Machine("aut2_valid.dea");
        Machine d = new Machine("aut2_invalid.dea");
        Machine e = new Machine("aut3_valid.dea");
        Machine f = Machine.ImportMachine("aut3_invalid.dea");
        Machine g = Machine.ImportMachine("aut4_valid.dea");
        Machine h = Machine.ImportMachine("aut4_invalid.dea");
        Machine i = Machine.ImportMachine("bankomat_valid.dea");
        Machine j = Machine.ImportMachine("bankomat_invalid.dea");

        System.out.println(a.isValidMachine()); // true
        System.out.println(b.isValidMachine()); // false
        System.out.println(c.isValidMachine()); // true
        System.out.println(d.isValidMachine()); // false
        System.out.println(e.isValidMachine()); // true
        System.out.println(f.isValidMachine()); // false
        System.out.println(g.isValidMachine()); // true
        System.out.println(h.isValidMachine()); // false
        System.out.println(i.isValidMachine()); // true
        System.out.println(j.isValidMachine()); // false

        System.out.println("---");
        System.out.println(a.run(new String[] {"a", "b", "b"})); // true

    }
}
