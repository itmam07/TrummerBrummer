import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OpenList {
    private ArrayList<Entry> list;
    private HashMap<Node, Entry> hash;

    public OpenList() {
        list = new ArrayList<Entry>();
        hash = new HashMap<Node, Entry>();
    }

    public void add(Entry entry) {
        list.add(entry);
        hash.put(entry.getNode(), entry);
    }

    public Entry getBest() {
        if (list.size() == 0)
            return null;
        Collections.sort(list);
        Entry e = list.get(0);
        list.remove(0);
        hash.remove(e.getNode());
        return e;
    }

    public boolean isInList(Node e) {
        return hash.containsKey(e);
    }

    public int getDistanceFromStart(Node n) {
        return hash.get(n).getDistanceFromStart();
    }

    public void update(Node n, Node predecessor, int distanceFromStart) {
        hash.get(n).update(predecessor, distanceFromStart);
    }


}