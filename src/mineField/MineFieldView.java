package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldView extends View {
    protected MineField mineField;
    protected JLabel[][] grid = new JLabel[20][20];


    public MineFieldView (MineField m) {
        super(m);

        this.setLayout(new GridLayout(20,20));

        grid = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                grid[i][j] = new JLabel("?", SwingConstants.LEFT);
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(grid[i][j]);

            }
        }
        grid[0][0].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        grid[19][19].setBorder(BorderFactory.createLineBorder((Color.GREEN)));

    }


    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        super.propertyChange(arg0);
        MineField mineField = (MineField) model;
        int adjMines = mineField.countMines(mineField.getPosX(), mineField.getPosY());
        grid[mineField.getPosX()][mineField.getPosY()].setText(String.valueOf(adjMines));
        grid[mineField.getPosX()][mineField.getPosY()].setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
}

