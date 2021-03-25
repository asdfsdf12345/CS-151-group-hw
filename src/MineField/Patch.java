package MineField;

public class Patch {

    private boolean mined;
    private int adjmines;
    private boolean end;

    public Patch(boolean mined){
        this.mined=mined;
    }

    public boolean getMined(){
        return this.mined;
    }

    public void setMined(boolean mined){
        this.mined=mined;
    }

    public boolean getEnd(){
        return this.end;
    }

    public void setEnd(boolean end){
        this.end=end;
    }

    public int getAdjmines(){
        return adjmines;
    }

    public void setAdjmines(int x){
        adjmines=x;
    }

}