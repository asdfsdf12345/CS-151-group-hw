package mineField;

import mvc.Command;
import mvc.Model;

public class MoveCommand extends Command {

    private String type;

    public MoveCommand(Model model, String type){
        super(model);
        this.type=type;

    }

    public void execute(){

    }


}
