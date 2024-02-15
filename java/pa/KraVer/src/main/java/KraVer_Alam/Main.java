package KraVer_Alam;

public class Main {
    public static void main(String[] args) {
        KraVerManagement km = new KraVerManagement();

        km.addModel("Itmam Alam", "12345678", 1000);
        km.addModel("Max Muster", "87654321", 1000.12, 100.1);

        km.print();
        System.out.println("-----ohne retour------");
        km.print(120);
        System.out.println("-----mit retour------");
        km.reset();

        km.addModel("Error", "00000000", 100);
        km.addModel("Error", "00000000", 1000.12, 100.1);

        km.print();
        System.out.println("------Fehler-----");
        km.print(120);
        System.out.println("------Fehler-----");
        km.reset();
    }
}