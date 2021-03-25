package MineField;


import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldView extends View {
    protected MineField mineField;
    protected JLabel[][] grid = new JLabel[20][20];
    boolean hasVisited;

    public MineFieldView (MineField m) {
        super(m);

        this.setLayout(new GridLayout(20,20));

        grid = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                grid[j][i] = new JLabel("?", SwingConstants.LEFT);
                grid[j][i].setBackground(Color.GRAY);
                grid[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(grid[j][i]);
            }
        }
        grid[0][0].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        grid[19][19].setBorder(BorderFactory.createLineBorder((Color.GREEN)));
    }

    //put ^ this v down there?

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        super.propertyChange(arg0);
        MineField mineField = (MineField) model;


        //grid = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                //grid[j][i] = new JLabel("?", SwingConstants.LEFT);
                grid[i][j].setText("?");
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grid[0][0].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                grid[19][19].setBorder(BorderFactory.createLineBorder((Color.GREEN)));
                //this.add(grid[j][i]);
            }
        }
        for(int i = 0; i < mineField.visited.size(); i++){
            int adjMines = mineField.countMines(mineField.visited.get(i)[0], mineField.visited.get(i)[1]);
            grid[mineField.visited.get(i)[0]][mineField.visited.get(i)[1]].setText(String.valueOf(adjMines));
            grid[mineField.visited.get(i)[0]][mineField.visited.get(i)[1]].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }
        if(mineField.hasMine(mineField.getPosX(), mineField.getPosY())) {
            grid[mineField.getPosX()][mineField.getPosY()].setText("M");
            grid[mineField.getPosX()][mineField.getPosY()].setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }
}
