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
        
    };

    public String[] getHelp(){

    };

    public String about(){

    };
}