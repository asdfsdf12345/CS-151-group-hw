package mineField;

import mvc.*;
import tools.Utilities;

public class MineField extends Model{


    private Patch[][] mines = new Patch[20][20];;
    private int posX;
    private int posY;
    private int totalMines = 0;
    private boolean gameOver=false;

    public MineField() {

        placeMines();
    }

    public void placeMines(){
        for(int i =0; i< 20; i++){
            for(int j =0; j<20; j++){
                if(Math.random()<.5){
                        mines[i][j]=new Patch(true);
                        totalMines++;
                    }
                mines[i][j]=new Patch(false);
                }
            }
        mines[19][19].setEnd(true);
    }

    public void move(String cmmd) {

        if(!gameOver){


        if (posX+1 > 0 && posX -1 < 20 && posY+1 >=0 && posY -1< 20) {
            if (cmmd == "NW") {
                if (posY >0 && posX>0) {
                    posX = posX - 1;
                    posY = posY - 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");
            }
            else if (cmmd == "NE") {
                if (posY >0 && posX<19) {
                    posX = posX + 1;
                    posY = posY - 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");
            }
            else if (cmmd == "N")
                if (posY >0)
                posY = posY - 1;
                else
                    Utilities.inform("you cannot go out of bounds");

            else if (cmmd == "E") {
                if (posX < 19) {
                    posX = posX + 1;
                    this.changed();

                }
                else
                    Utilities.inform("you cannot go out of bounds");
            }

            else if (cmmd == "S")
                if (posY <19) {
                    posY = posY + 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");

            else if (cmmd == "W")
                if (posX >0) {
                    posX = posX - 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");

            else if (cmmd == "SE") {
                if (posY <19 && posX<19) {
                    posX = posX + 1;
                    posY = posY + 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");
            }

            else if (cmmd == "SW") {
                if (posY <19 && posX> 0) {
                    posX = posX - 1;
                    posY = posY + 1;
                    this.changed();
                }
                else
                    Utilities.inform("you cannot go out of bounds");
            }

            if(mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }

            if(posX ==19 && posY==19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }


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
            if(row>0&& row<20 && col>0 &&col<20)
            return mines[row][col].getMined();
            else
                return false;
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

