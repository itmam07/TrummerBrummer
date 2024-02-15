public class KraVerManagement {
    public static int MAX = 10;
    public static int NOT_FOUND = 10;
    private Model[] list;


    public KraVerManagement() {
        this(MAX);
    }

    public KraVerManagement(int size) {
        list = new Model[size];
    }

}
