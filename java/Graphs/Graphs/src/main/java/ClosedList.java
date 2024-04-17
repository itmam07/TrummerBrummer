import java.util.ArrayList;
import java.util.HashMap;

public class ClosedList {
    private HashMap<Node, Entry> hash;

    public ClosedList() {
        hash = new HashMap<Node, Entry>();
    }

    public void add(Entry entry) {
        hash.put(entry.getNode(), entry);
    }

    public boolean isInHashMap(Node node) {
        return hash.containsKey(node);
    }

    public ArrayList<Node> getResult(Node dest) {
        ArrayList<Node> result = new ArrayList<>();
        Entry e = hash.get(dest);

        while (e != null) {
            result.add(e.getNode());
            e = hash.get(e.getPredecessor());
        };
        return result;
    }
}