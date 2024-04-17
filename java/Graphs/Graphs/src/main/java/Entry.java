public class Entry implements Comparable {
    private Node node;
    private Node predecessor;
    private int distanceFromStart;
    private int distanceToDest;

    public Entry(Node node, Node predecessor, int distanceFromStart) {
        this.node = node;
        this.predecessor = predecessor;
        this.distanceFromStart = distanceFromStart;
    }
    public void update(Node predecessor, int distanceFromStart) {
        this.predecessor = predecessor;
        this.distanceFromStart = distanceFromStart;
    }
    public Node getNode() {
        return node;
    }
    public Node getPredecessor() {
        return predecessor;
    }
    public int getDistanceFromStart() {
        return distanceFromStart;
    }
    @Override
    public int compareTo(Object o) {
        return distanceFromStart - ((Entry)o).distanceFromStart;
    }
}