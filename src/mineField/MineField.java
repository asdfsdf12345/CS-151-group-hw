package mineField;

import mvc.*;

public class MineField extends Model{
<<<<<<< Updated upstream
    
    public MineField(){
        
    }
    
    
=======

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
        }
    }





>>>>>>> Stashed changes
}
