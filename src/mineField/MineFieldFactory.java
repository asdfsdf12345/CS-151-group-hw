package mineField;

import mvc.*;

public class MineFieldFactory implements AppFactory{

    public Model makeModel(){
        return new MineField();
    };

    public View makeView(Model m){

        return new MineFieldView((MineField)m);
    };

    public String[] getEditCommands(){
        return new String[] {"NW",  "N", "NE", "W", "E", "SW", "S", "SE"};
    };

    public Command makeEditCommand(Model model, String type){
        return new MoveCommand(model);
    };

    public String getTitle(){
        return ("Mine Field");
    };

    public String[] getHelp(){
        return new String[] {"Click buttons to move. Do not hit mines. Each tile will show the amount of mines adjacent to it."};
    };

    public String about(){
        return "Mine Field version 1.0. By Jalen Angeles, Rose  Sendayen, Noah Tolbert, ";
    };
}
