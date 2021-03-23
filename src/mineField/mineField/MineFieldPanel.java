package mineField;

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


}
