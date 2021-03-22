package mvc;

public class Command {

    protected Model model=new Model();

    public Command(Model model){
        this.model=model;
    }

    public void execute(){

    }

}
