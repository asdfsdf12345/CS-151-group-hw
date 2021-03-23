package mineField;
import mvc.*;
import tools.*;


public class MoveCommand extends Command {

    private String s;

    public MoveCommand(Model model, String type) {
        super(model);
        s=type;
    }

    public void execute() {
        MineField Field = (MineField)model;
        Field.move(s);

    }



}
