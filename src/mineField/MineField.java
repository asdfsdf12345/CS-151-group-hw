package mineField;

import mvc.*;

public class MineField extends Model{

    private int N= 20;
    private Patch[][] mines = new Patch[N][N];
    private int [][] pos;
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

