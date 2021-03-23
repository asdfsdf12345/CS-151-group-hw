package mineField;

import mvc.*;
import tools.Utilities;

public class MineField extends Model{


    private Patch[][] mines = new Patch[20][20];;
    private int posX;
    private int posY;
    private double percentMined = .05;
    private int totalMines = 0;
    private boolean gameOver=false;

    public MineField() {

        placeMines();
    }

    public void placeMines(){
        for(int i =0; i< 20; i++){
            for(int j =0; j<20; j++){
                if(totalMines< 20 && Math.random()<.05){
                        mines[i][j]=new Patch(true);
                        totalMines++;
                    }
                mines[i][j]=new Patch(false);
                }
            }
        mines[19][19].setEnd(true);
    }

    public void move(String cmmd) {
        System.out.println(posX);
        System.out.println(posY);

        if(!gameOver){

        if (posX+1 > 0 && posX -1 < 20 && posY+1 >=0 && posY -1< 20) {
            if (cmmd == "NW") {
                posX = posX - 1;
                posY = posY - 1;
            }
            else if (cmmd == "NE") {
                posX = posX + 1;
                posY = posY - 1;
            }
            else if (cmmd == "N")
                posY = posY - 1;

            else if (cmmd == "E")
                posX = posX + 1;

            else if (cmmd == "S")
                posY = posY + 1;

            else if (cmmd == "W")
                posX = posX - 1;

            else if (cmmd == "SE") {
                posX = posX + 1;
                posY = posY + 1;
            }

            else if (cmmd == "SW") {
                posX = posX - 1;
                posY = posY + 1;
            }


        }

        if(posX ==19 && posY==19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
        }

        if(mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
        }
        else
            Utilities.error("You cannot move out of bounds");
    }
        else
            Utilities.error("The game is over");
    }



    public int getPosX() {
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void numAdjacentMines(){
        for(int i = 0; i<20; i++){
            for(int j=0; j<20; j++){
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

