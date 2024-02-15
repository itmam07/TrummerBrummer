/*
 * author: Itmam Alam
 * class: TariffList
 * date: 30.09.2023
 * */

import java.io.*;

public class TariffList {
    private Tariff[] tariffList;

    private static int max = 10;

    public static final int NOT_FOUND = -1;

    public TariffList() {
        this(max);
    }

    public TariffList(int x) {
        setMax(x);
        tariffList = new Tariff[x];
    }

    public boolean addTariff(String desc, String phoneNumber, int feeMonth) {
        int id = getID();
        if (id == NOT_FOUND)
            return false;
        tariffList[id] = TariffA.getTariff(desc, phoneNumber, feeMonth);
        return true;
    }

    public boolean addTariff(String desc, String phoneNumber, double feeMonth, double feeMinute) {
        int id = getID();
        if (id == NOT_FOUND)
            return false;
        tariffList[id] = TariffB.getTariff(desc, phoneNumber, feeMonth, feeMinute);
        return true;
    }

    public void print() {
        for (Tariff tariff : tariffList) {
            if (tariff != null) {
                System.out.println(tariff + " " + tariff.getNumber());
            }
        }
    }

    public void print(int x) {
        for (Tariff tariff : tariffList) {
            if (tariff != null) {
                System.out.println(tariff + ", Bonus: " + tariff.getBonusPoints(x) + " " + tariff.getNumber());
            }
        }
    }

    public void reset() {
        tariffList = new Tariff[max];
    }

    public void readFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            String[] parts;

            while ((line = br.readLine()) != null) {
                parts = line.split(";");
                if (parts.length == 3) {
                    if (!addTariff(parts[0], parts[1], Integer.parseInt(parts[2])))
                        System.out.println("\nKein Platz mehr");
                } else if (parts.length == 4) {
                    if (!addTariff(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3])))
                        System.out.println("\nKein Platz mehr");
                } else {
                    br.close();
                    throw new ArrayIndexOutOfBoundsException("Unzureichende Parameter!");
                }
            }
            br.close();
        } catch (IOException ioe) {
            System.err.println("\nFehler beim Lesen von " + fileName + " please check the file path!");
            System.err.println(ioe.getMessage());
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("\nFehler in Datei: " + fileName);
            System.err.println(a.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("\nFalsche Formatierung in Datei: " + fileName);
            System.err.println(nfe.getMessage());
            System.err.println("\nBeispiel für TariffA: Test;0699-123-456;9");
            System.err.println("Beispiel für TariffB: Test;0699-123-456;11;12.1");
        }
    }

    private static void setMax(int max) {
        TariffList.max = max;
    }

    private int getID() {
        for (int i = 0; i < tariffList.length; i++)
            if (tariffList[i] == null)
                return i;
        return NOT_FOUND;
    }
}
