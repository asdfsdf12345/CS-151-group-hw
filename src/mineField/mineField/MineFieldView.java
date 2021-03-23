package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldView extends View {
    protected MineField mineField;
    protected JLabel[][] grid;
    private int N = 20;

    public MineFieldView (MineField m) {
        super(m);
        mineField = m;
        grid = new JLabel[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new JLabel("?", SwingConstants.LEFT);
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
        repaint();
    }


    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        super.propertyChange(arg0);
        grid[mineField.getPosX()][mineField.getPosY()].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int adjMines = mineField.countMines(mineField.getPosX(), mineField.getPosY());
        grid[mineField.getPosX()][mineField.getPosY()].setText(String.valueOf(adjMines));
    }
}
