package mineField;

<<<<<<< Updated upstream
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tools.*;

public class MineFieldPanel extends JPanel implements ActionListener {

    private Turtle turtle;

    public MineFieldPanel() {
        MineField mineField = new MineField();
        MineFieldView view = new MineFieldView(mineField);
        //view.setBackground((Color.WHITE));
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground((Color.cyan));

        JButton north, south, east, west, clear, pen, color;

        JPanel p = new JPanel();
        north = new JButton("North");
        north.addActionListener(this);
        p.add(north);
        controlPanel.add(p);

        p = new JPanel();
        east = new JButton("East");
        east.addActionListener(this);
        p.add(east);
        controlPanel.add(p);

        p = new JPanel();
        west = new JButton("West");
        west.addActionListener(this);
        p.add(west);
        controlPanel.add(p);

        p = new JPanel();
        south = new JButton("South");
        south.addActionListener(this);
        p.add(south);
        controlPanel.add(p);

        p = new JPanel();
        clear = new JButton("Clear");
        clear.addActionListener(this);
        p.add(clear);
        controlPanel.add(p);

        p = new JPanel();
        pen = new JButton("Pen");
        pen.addActionListener(this);
        p.add(pen);
        controlPanel.add(p);

        p = new JPanel();
        color = new JButton("Color");
        color.addActionListener(this);
        p.add(color);
        controlPanel.add(p);

        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        this.frame.setJMenuBar(this.createMenuBar());
        this.frame.setDefaultCloseOperation(3);
        this.frame.setTitle("Turtle Graphics");
        this.frame.setSize(500, 300);

        this.setLayout((new GridLayout(1, 2)));
        this.add(controlPanel);
        this.add(this.view);

        this.frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"North", "South", "East", "West", "Clear", "Pen", "Color"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if (cmmd == "North") {

        } else if (cmmd == "East") {

        } else if (cmmd == "West") {

        } else if(cmmd == "South") {

        } else if(cmmd == "Clear") {

        } else if(cmmd == "Pen") {

        } else if (cmmd == "Color") {

        } else if (cmmd == "Save") {
            try {
                String fName = Utilities.getFileName((String)null, false);
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                os.writeObject(this.mineField);
                os.close();
            } catch (Exception var6) {
                Utilities.error(var6);
            }
        } else if (cmmd != "SaveAs") {
            if (cmmd == "Open") {
                try {
                    String fName = Utilities.getFileName((String)null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    this.mineField = (MineField)is.readObject();
                    this.view.setTurtle(this.mineField);
                    is.close();
                } catch (Exception var5) {
                    Utilities.error(var5.getMessage());
                }
            } else if (cmmd == "New") {
                MineField newmineField = new MineField();
                this.view.setMineField(newmineField);
            } else if (cmmd == "Quit") {
                System.exit(1);
            } else if (cmmd == "About") {
                Utilities.inform("Cyberdellic Designs Turtle Graphics, 2021. All rights reserved.");
            } else if (cmmd == "Help") {
                Utilities.inform("Move the turtle with the buttons");
            } else {
                Utilities.error("Unrecognized command: " + cmmd);
            }
        }


    }

    public static void main(String[] args) { MineFieldPanel app = new MineFieldPanel(); }
=======
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldPanel extends AppPanel {

    private JButton NW;
    private JButton N;
    private JButton NE;
    private JButton W;
    private JButton E;
    private JButton SW;
    private JButton S;
    private JButton SE;

    public MineFieldPanel (AppFactory factory) {

        super(factory);
        NW = new JButton("NW");
        NW.addActionListener(this);
        N = new JButton("N");
        N.addActionListener(this);
        NE = new JButton("NE");
        NE.addActionListener(this);
        W = new JButton("W");
        W.addActionListener(this);
        E = new JButton("E");
        E.addActionListener(this);
        SW = new JButton("SW");
        SW.addActionListener(this);
        S = new JButton("S");
        S.addActionListener(this);
        SE = new JButton("SE");
        SE.addActionListener(this);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);

    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }


>>>>>>> Stashed changes
}
