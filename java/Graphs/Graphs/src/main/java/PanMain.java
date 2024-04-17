import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PanMain extends JPanel {
    private NodeManagement nodes;
    private Node actNode;
    private boolean moving = false;
    private boolean creatingConnection = false;
    private int oldX, oldY;
    private char act = 'A';
    private Node startNode, endNode;

    public PanMain() {
        nodes = new NodeManagement();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                oldX = e.getX();
                oldY = e.getY();
                if (e.isControlDown()) {
                    actNode = nodes.isInNode(e.getX(), e.getY());
                    if (actNode != null) {
                        moving = true;
                        resetMarks();
                    }
                }
                else {
                    Node[] inWeight = nodes.isInWeight(e.getX(), e.getY());
                    if (inWeight != null) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            nodes.decWeight(inWeight[0], inWeight[1]);
                            resetMarks();
                        }
                        else if (e.getButton() == MouseEvent.BUTTON3) {
                            nodes.incWeight(inWeight[0], inWeight[1]);
                            resetMarks();
                        }
                    }
                    else if (nodes.isNearNode(e.getX(), e.getY()) == null && e.getButton() == MouseEvent.BUTTON1) {
                        resetMarks();
                        nodes.addNode(act+"", e.getX(), e.getY());
                        act++;
                    }
                    else if (((actNode = nodes.isInNode(e.getX(), e.getY())) != null) && e.getButton() == MouseEvent.BUTTON1) {
                        resetMarks();
                        creatingConnection = true;
                    }
                    else if (((actNode = nodes.isInNode(e.getX(), e.getY())) != null) && (e.getButton() == MouseEvent.BUTTON3)) {
                        if (startNode == null) {
                            startNode = actNode;
                            startNode.setIsSelected(true);
                        }
                        else if (endNode == null) {
                            endNode = actNode;
                            endNode.setIsSelected(true);
                            SearchDijkstra search = new SearchDijkstra(nodes);
                            ArrayList<Node> result = search.search(startNode.getDescription(), endNode.getDescription());
                            nodes.resetMarks(startNode, endNode);
                            nodes.markPath(result);
                        }
                        else {
                            resetMarks();
                            startNode = actNode;
                            startNode.setIsSelected(true);
                            endNode = null;
                        }
                    }
                }
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (creatingConnection) {
                    Node dest = nodes.isInNode(e.getX(), e.getY());
                    if (dest != null) {
                        nodes.addNeighbour(actNode.getDescription(), dest.getDescription(),1);
                    }
                }
                moving = false;
                creatingConnection = false;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (moving) {
                    actNode.setX(actNode.getX() + e.getX()-oldX);
                    actNode.setY(actNode.getY() + e.getY()-oldY);
                }
                oldX = e.getX();
                oldY = e.getY();
                repaint();
            }
        });
    }

    public void resetMarks() {
        if (startNode != null)
            startNode.setIsSelected(false);
        if (endNode != null)
            endNode.setIsSelected(false);

        nodes.resetMarks(startNode, endNode);
        startNode = null;
        endNode = null;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (creatingConnection) {
            g.drawLine(actNode.getX(), actNode.getY(), oldX, oldY);
        }
        nodes.paint(g);
    }

    public void miNew() {
        nodes = new NodeManagement();
        repaint();
    }

    public void miOpen(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            nodes = (NodeManagement)ois.readObject();
            ois.close();
            repaint();
        }
        catch (Exception e) {

        }
    }

    public void miSave(String fileName) {
        if (!fileName.endsWith(".bin"))
            fileName = fileName + ".bin";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(nodes);
            oos.close();
        }
        catch (Exception e) {

        }
    }

}
