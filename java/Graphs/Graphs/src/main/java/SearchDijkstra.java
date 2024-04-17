import java.util.ArrayList;
import java.util.HashMap;

public class SearchDijkstra {
    private NodeManagement nodes;
    private OpenList ol;
    private ClosedList cl;

    public SearchDijkstra() {
        nodes = new NodeManagement();
        ol = new OpenList();
        cl = new ClosedList();
    }

    public SearchDijkstra(NodeManagement nodes) {
        this.nodes = nodes;
        ol = new OpenList();
        cl = new ClosedList();
    }

    public ArrayList<Node> search(String start, String dest) {

        Node startNode = nodes.getNode(start);
        Node destNode = nodes.getNode(dest);

        if (startNode == null || destNode == null) {
            System.out.println("not found");
            return null;
        }

        Entry e = new Entry(startNode, null, 0);
        HashMap<Node, Integer> neighbours;


        while (e != null && !e.getNode().getDescription().equals(destNode.getDescription())) {
            neighbours = e.getNode().getNeighbours();
            for (Node neigh : neighbours.keySet()) {
                if (cl.isInHashMap(neigh)) {}
                else if (ol.isInList(neigh) && e.getDistanceFromStart()+e.getNode().getDistanceTo(neigh) < ol.getDistanceFromStart(neigh))
                    ol.update(neigh, e.getNode(), e.getDistanceFromStart()+e.getNode().getDistanceTo(neigh));
                else if (!ol.isInList(neigh))
                    ol.add(new Entry(neigh, e.getNode(), e.getDistanceFromStart() + e.getNode().getDistanceTo(neigh)));
            }
            cl.add(e);
            e = ol.getBest();
        }

        if (e == null)
            System.out.println("not found");
        else {
            cl.add(e);
            ArrayList<Node> result = cl.getResult(destNode);
            System.out.println("path found: ");
            for (int i = result.size()-1; i >=0; i--)
                System.out.println("  " + result.get(i).getDescription());
            return result;
        }
        return null;
    }
}
