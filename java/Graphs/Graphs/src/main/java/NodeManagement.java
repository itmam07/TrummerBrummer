import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeManagement implements Serializable {
    private HashMap<String, Node> nodes;

    public NodeManagement() {
        nodes = new HashMap<String, Node>();
    }

    public boolean addNode(String desc, int x, int y) {
        if (nodes.containsKey(desc))
            return false;

        nodes.put(desc, new Node(desc, x, y));
        return true;
    }

    public boolean addNeighbour(String from, String to, int distance) {
        if (!nodes.containsKey(from) || !nodes.containsKey(to))
            return false;

        return
                nodes.get(from).addNeighbour(nodes.get(to), distance) &&
                nodes.get(to).addNeighbour(nodes.get(from), distance);

    }

    public Node getNode(String desc) {
        return nodes.get(desc);
    }

    public void incWeight(Node n1, Node n2) {
        nodes.get(n1.getDescription()).incWeight(n2);
        nodes.get(n2.getDescription()).incWeight(n1);

    }

    public void decWeight(Node n1, Node n2) {
        nodes.get(n1.getDescription()).decWeight(n2);
        nodes.get(n2.getDescription()).decWeight(n1);
    }

    public void paint(Graphics g) {
        for (Node n: nodes.values())
            n.paintConnection(g);
        for (Node n: nodes.values())
            n.paint(g);
    }

    public Node isNearNode(int x, int y) {
        for (Node n : nodes.values()) {
            if (n.isNearNode(x, y))
                return n;
        }
        return null;
    }

    public Node isInNode(int x, int y) {
        for (Node n : nodes.values()) {
            if (n.isInNode(x, y))
                return n;
        }
        return null;
    }

    public Node[] isInWeight(int x, int y) {
        Node neigh;
        for (Node n : nodes.values()) {
            neigh = n.isInWeight(x, y);
            if (neigh != null)
                return new Node[] {n, neigh};
        }
        return null;
    }

    public void markPath(ArrayList<Node> result) {
        if (result != null)
            for (Node n : result)
                n.setIsSelected(true);
    }

    public void resetMarks(Node startNode, Node endNode) {
        for (Node n : nodes.values())
            if (n != startNode && n != endNode)
                n.setIsSelected(false);
    }
}
