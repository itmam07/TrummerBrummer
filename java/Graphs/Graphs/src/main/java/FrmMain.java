import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class FrmMain extends JFrame {
    PanMain panMain;

    public FrmMain() {
        panMain = new PanMain();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        JMenuBar mb = new JMenuBar();
        JMenu menFile = new JMenu("File");
        JMenuItem miNew = new JMenuItem("New");
        miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        miNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panMain.miNew();
            }
        });
        menFile.add(miNew);
        menFile.addSeparator();
        JMenuItem miOpen = new JMenuItem("Open");
        miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return (f.isDirectory() || f.getName().endsWith(".bin"));
                    }

                    @Override
                    public String getDescription() {
                        return "Binary Files";
                    }
                });
                if (fc.showOpenDialog(panMain) == JFileChooser.APPROVE_OPTION) {
                    panMain.miOpen(fc.getSelectedFile().getAbsolutePath());
                }

            }
        });
        menFile.add(miOpen);
        JMenuItem miSave = new JMenuItem("Save");
        miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menFile.add(miSave);
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return (f.isDirectory() || f.getName().endsWith(".bin"));
                    }

                    @Override
                    public String getDescription() {
                        return "Binary Files";
                    }
                });
                if (fc.showSaveDialog(panMain) == JFileChooser.APPROVE_OPTION) {
                    panMain.miSave(fc.getSelectedFile().getAbsolutePath());
                }

            }
        });

        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menFile.addSeparator();
        menFile.add(miExit);
        mb.add(menFile);
        setJMenuBar(mb);
        setContentPane(panMain);
        setVisible(true);

    }
    public static void main(String[] args) {
        new FrmMain();
    }
}
