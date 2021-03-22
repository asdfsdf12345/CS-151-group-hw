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

    };

    public Command makeEditCommand(Model model, String type){

    };

    public String getTitle(){
        return ("Mine Field");
    };

    public String[] getHelp(){
        return new String[] {"Click buttons to move. Do not hit mines. Each tile will show the amount of mines adjacent to it."};
    };

    public String about(){

    };
}
