import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public class Node implements Serializable {
    private String desc;
    private int x, y;
    private HashMap<Node, Integer> neighbours;
    private boolean isSelected;
    public static final int SIZE = 20;
    public static final int SIZEWEIGHT = 20;
    public static final Color BACKCOLOR = new Color(236,236,236);
    public static final Color SELECTEDCOLOR = new Color(255,0,0);


    public Node(String desc, int x, int y) {
        this.desc = desc;
        set(x, y);
        neighbours = new HashMap<Node, Integer>();
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDescription() {
        return desc;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    public boolean getIsSelected() {
        return isSelected;
    }
    public boolean addNeighbour(Node neighbour, int distance) {
        if (neighbours.containsKey(neighbour))
            return false;

        neighbours.put(neighbour, distance);
        return true;
    }

    public HashMap<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public int getDistanceTo(Node n) {
        return neighbours.get(n);
    }
    public int getDistance(Node neighbour) {
        return neighbours.get(neighbour);
    }

    public void paintConnection(Graphics g) {
        int posx, posy;
        int width, height;
        for (Node n : neighbours.keySet()) {
            if (getDescription().compareTo(n.getDescription()) < 0) {
                String value = neighbours.get(n)+"";
                g.drawLine(getX(), getY(), n.getX(), n.getY());
                posx = getX() + (n.getX()-getX())/2;
                posy = getY() + (n.getY()-getY())/2;
                width = g.getFontMetrics().stringWidth(value);
                height = g.getFontMetrics().getAscent()/2;
                g.setColor(BACKCOLOR);
                g.fillOval(posx-SIZEWEIGHT, posy-SIZEWEIGHT, SIZEWEIGHT*2, SIZEWEIGHT*2);
                g.setColor(Color.BLACK);
                g.drawString(value, posx-width/2, posy+(int)(height/1.5));
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(BACKCOLOR);
        g.fillOval(getX()-SIZE, getY()-SIZE, SIZE*2, SIZE*2);
        if (isSelected)
            g.setColor(SELECTEDCOLOR);
        else
            g.setColor(Color.BLACK);
        g.drawOval(getX()-SIZE, getY()-SIZE, SIZE*2, SIZE*2);
        int width = g.getFontMetrics().stringWidth(getDescription());
        int height = g.getFontMetrics().getAscent()/2;
        g.drawString(getDescription(), getX()-width/2, getY()+(int)(height/1.5));
    }

    public boolean isInNode(int x, int y) {
        return getDistance(x, y) < SIZE;
    }

    public boolean isNearNode(int x, int y) {
        return getDistance(x, y) < 2 * SIZE;
    }

    public Node isInWeight(int x, int y) {
        int posx;
        int posy;

        for (Node n : neighbours.keySet()) {
            posx = getX() + (n.getX()-getX()) / 2;
            posy = getY() + (n.getY()-getY()) / 2;

            if (getDistance(posx, posy, x,y) < SIZEWEIGHT)
                return n;
        }
        return null;
    }

    public void incWeight(Node neigh) {
        neighbours.put(neigh, neighbours.get(neigh) + 1);
    }

    public void decWeight(Node neigh) {
        if (neighbours.get(neigh) > 1)
            neighbours.put(neigh, neighbours.get(neigh) - 1);
    }

    private int getDistance(int x, int y) {
        return getDistance(getX(), getY(), x, y);
    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        return (int)Math.round(Math.sqrt(dx*dx+dy*dy));
    }


}
