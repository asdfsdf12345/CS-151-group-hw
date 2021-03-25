package MineField;
import mvc.*;

public class MoveCommand extends Command {

    private String dir;

    public MoveCommand(Model model, String direction) {
        super(model);
        this.dir = direction;
    }

    public void execute() {
        MineField Field = (MineField)model;
        switch(dir) {
            case "N": {
                Field.N();
                break;
            }
            case "NW": {
                Field.NW();
                break;
            }
            case "NE": {
                Field.NE();
                break;
            }
            case "E": {
                Field.E();
                break;
            }
            case "W": {
                Field.W();
                break;
            }
            case "S": {
                Field.S();
                break;
            }
            case "SW": {
                Field.SW();
                break;
            }
            case "SE": {
                Field.SE();
                break;
            }
        }


    }



}
