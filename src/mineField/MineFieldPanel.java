package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldPanel extends AppPanel {
    protected JLabel[][] grid;
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
        MineField minefield = (MineField) model;
        minefield.addPropertyChangeListener(this);
        controlPanel.setLayout(new GridLayout(4, 1));

        JPanel p = new JPanel();
        N = new JButton("N");
        N.addActionListener(this);
        p.add(N);
        controlPanel.add(p);

        p = new JPanel();
        NW = new JButton("NW");
        NW.addActionListener(this);
        p.add(NW);
        controlPanel.add(p);

        p = new JPanel();
        NE = new JButton("NE");
        NE.addActionListener(this);
        p.add(NE);
        controlPanel.add(p);

        p = new JPanel();
        W = new JButton("W");
        W.addActionListener(this);
        p.add(W);
        controlPanel.add(p);

        p = new JPanel();
        E = new JButton("E");
        E.addActionListener(this);
        p.add(E);
        controlPanel.add(p);

        p = new JPanel();
        SE = new JButton("SE");
        SE.addActionListener(this);
        p.add(SE);
        controlPanel.add(p);

        p = new JPanel();
        SW = new JButton("SW");
        SW.addActionListener(this);
        p.add(SW);
        controlPanel.add(p);

        p = new JPanel();
        S = new JButton("S");
        S.addActionListener(this);
        p.add(S);
        controlPanel.add(p);


    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }


}
