package mineField;

import mvc.*;
import tools.Utilities;

public class MineField extends Model{

    private int N= 20;
    private Patch[][] mines = new Patch[N][N];
    private int posX=0;
    private int posY=0;
    private double percentMined = .05;
    private int totalMines = 0;

    public MineField() {

    }

    public void placeMines(){
        for(int i =0; i< 20; i++){
            for(int j =0; j<20; j++){
                if(totalMines< N*N*percentMined && Math.random()<.05){
                        mines[i][j]=new Patch(true);
                        totalMines++;
                    }
                mines[i][j]=new Patch(false);
                }
            }
        mines[19][19].setEnd(true);
    }

    public void move(String cmmd){
        switch(cmmd){
            case "NW":
                if(posY > 0 && posX > 0) {
                    posY -= 1;
                    posX -= 1;
                }
                else
                    Utilities.inform("You cannot move off of the minefield.");


            case "N":
                if(posY > 0)
                    posY -= 1;
                else
                    Utilities.inform("You cannot move off of the minefield.");

            case "NE":
                if(posY > 0 && posX < 19) {
                    posY -= 1;
                    posX += 1;
                }
                else
                    Utilities.inform("You cannot move off of the minefield.");


            case "W":
                if(posX > 0)
                    posX -= 1;
                else
                    Utilities.inform("You cannot move off of the minefield.");

            case "E":
                if(posX < 19)
                    posX += 1;
                else
                    Utilities.inform("You cannot move off of the minefield.");

            case "SW":
                if(posY < 19 && posX > 0) {
                    posY += 1;
                    posX -= 1;
                }
                else
                    Utilities.inform("You cannot move off of the minefield.");

            case "SE":
                if(posY < 19 && posX < 19) {
                    posY += 1;
                    posX += 1;
                }
                else
                    Utilities.inform("You cannot move off of the minefield.");

            case "S":
                if(posY < 19)
                    posY += 1;
                else
                    Utilities.inform("You cannot move off of the minefield.");

        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void numAdjacentMines(){
        for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                mines[i][j].setAdjmines(this.countMines(i,j));
            }
        }
    }

    public boolean hasMine(int row, int col) {

            return mines[row][col].getMined();
    }

    public int countMines(int row, int col) {

        int adjacentMines = 0;

        if(hasMine(row-1,col-1))
        {
            adjacentMines++;
        }
        if(hasMine(row,col-1) )
        {
            adjacentMines++;
        }
        if(hasMine(row+1,col-1) )
        {
            adjacentMines++;
        }
        if(hasMine(row-1,col))
        {
            adjacentMines++;
        }
        if(hasMine(row+1,col))
        {
            adjacentMines++;
        }
        if(hasMine(row-1,col+1))
        {
            adjacentMines++;
        }
        if(hasMine(row,col+1))
        {
            adjacentMines++;
        }
        if(hasMine(row+1,col+1))
        {
            adjacentMines++;
        }

        return adjacentMines;
       }
    }

