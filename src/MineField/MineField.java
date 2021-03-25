package MineField;

import mvc.*;

import java.util.ArrayList;

public class MineField extends Model{


    private Patch[][] mines = new Patch[20][20];;
    private int posX;
    private int posY;
    private int totalMines = 0;
    private boolean gameOver = false;
    public ArrayList<int[]> visited = new ArrayList<int[]>();

    public MineField() {
        placeMines();
        visited.add(new int[] {0,0});
        this.changed();
    }

    public void placeMines(){
        for(int i =0; i< 20; i++){
            for(int j =0; j<20; j++){
                if(Math.random()<0.05){
                    mines[i][j]=new Patch(true);
                    totalMines++;
                }
                else
                    mines[i][j]=new Patch(false);
            }
        }
        mines[19][19].setEnd(true);
    }

    public void N() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (this.posY >0) {
                this.posY = this.posY - 1;
                visited.add(new int[] {posX, posY});
            }
            else
                Utilities.inform("you cannot go out of bounds");

            if(mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if(posX ==19 && posY==19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void NW() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posY > 0 && posX > 0) {
                posX = posX - 1;
                posY = posY - 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void NE() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posY > 0 && posX < 19) {
                posX = posX + 1;
                posY = posY - 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void E() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posX < 19) {
                posX = posX + 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void W() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posX > 0) {
                posX = posX - 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void S() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posY < 19) {
                posY = posY + 1;
                visited.add(new int[] {posX, posY});
                System.out.println(visited.get(visited.size()-1)[0]);
                System.out.println(visited.get(visited.size()-1)[1]);
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void SW() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posY < 19 && posX > 0) {
                posX = posX - 1;
                posY = posY + 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }
    public void SE() {
        if(gameOver) {
            Utilities.error("The game is over");
        }
        else if (!(posX + 1 > 0 && posX - 1 < 20 && posY + 1 >= 0 && posY - 1 < 20)) {
            Utilities.error("You cannot move out of bounds");
        }
        else {
            if (posY < 19 && posX < 19) {
                posX = posX + 1;
                posY = posY + 1;
                visited.add(new int[] {posX, posY});
            } else
                Utilities.inform("you cannot go out of bounds");

            if (mines[posX][posY].getMined()) {
                Utilities.inform("GAME OVER!");
                gameOver = true;
            }
            if (posX == 19 && posY == 19) {
                Utilities.inform("YOU WON!");
                gameOver = true;
            }
            this.changed();
        }
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public ArrayList<int[]> getVisited() {
        return this.visited;
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
