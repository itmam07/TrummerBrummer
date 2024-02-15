/*
 * author: Itmam Alam
 * class: Main
 * date: 30.09.2023
 * */

public class Main {
    public static void main(String[] args) {
        TariffList tariffManager = new TariffList();

        tariffManager.addTariff("Itmam", "0699-023-456", 10);
        tariffManager.addTariff("Alam", "0699-103-457", 9.90, 0.01);

        tariffManager.print();
        System.out.println();

        tariffManager.reset();
        tariffManager.readFromFile("Tariffs.txt");

        tariffManager.print();
        System.out.println();

        tariffManager.print(20202022);
    }
}
