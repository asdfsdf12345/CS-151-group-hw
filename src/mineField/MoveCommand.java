package MineField;
import mvc.*;
import tools.*;

interface Direction {
    void movePanel(Sargent s);
}

class N extends Utilities implements Direction {
    public void movePanel(Sargent s) {
        if(s.posY > 0)
            s.posY -= 1;
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class E implements Direction {
    public void movePanel(Sargent s) {
        if(s.posX < 19)
            s.posX += 1;
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class W implements Direction {
    public void movePanel(Sargent s) {
        if(s.posX > 0)
            s.posX -= 1;
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class S implements Direction {
    public void movePanel(Sargent s) {
        if(s.posY < 19)
            s.posY += 1;
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class NE implements Direction {
    public void movePanel(Sargent s) {
        if(s.posY > 0 && s.posX < 19) {
            s.posY -= 1;
            s.posX += 1;
        }
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class NW implements Direction {

    public void movePanel(Sargent s) {
        if(s.posY > 0 && s.posX > 0) {
            s.posY -= 1;
            s.posX -= 1;
        }
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class SE extends Utilities implements Direction {
    public void movePanel(Sargent s) {
        if(s.posY < 19 && s.posX < 19) {
            s.posY += 1;
            s.posX += 1;
        }
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}
class SW implements Direction {
    public void movePanel(Sargent s) {
        if(s.posY < 19 && s.posX > 0) {
            s.posY += 1;
            s.posX -= 1;
        }
        else
            Utilities.inform("You cannot move off of the minefield.");
    }
}

class Sargent {
    int posX = 0;
    int posY = 0;
    Direction direction;
    void move() {
        direction.movePanel(this);
    }
}

public class MoveCommand extends Command {

    public MoveCommand(Model model) {
        super(model);
    }

    public void execute() {
        Sargent rock = new Sargent();
        rock.direction = new NW();
        rock.move();
    }

    public int getPosX(Sargent s) {
        return s.posX;
    }
    public int getPosY(Sargent s) {
        return s.posY;
    }

}
