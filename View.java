package mvc;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {

    private Model model;
    private int row, col; // x & y coordinates of upper-left corner of bounding box

    public View(Model model) {
        this.model = model;
        //model.subscribe(this);
        model.addPropertyChangeListener(this);
        row = 100;
        col = 100;
    }

    public void setModel(Model model){
        this.model.removePropertyChangeListener(this);
        this.model = model;
        this.model.initSupport();
        this.model.addPropertyChangeListener(this);
        repaint();
    }

    public void setBackground(Color color) {
        super.setBackground(color);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
