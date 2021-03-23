package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldView extends View {
    protected MineField mineField;
    protected JLabel[][] grid;


    public MineFieldView (MineField m) {
        super(m);

    }


    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        super.propertyChange(arg0);
        grid[mineField.getPosX()][mineField.getPosY()].setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
}

