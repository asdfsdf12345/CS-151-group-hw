package mvc;

import javax.swing.*;


public class View extends JPanel {

    protected Model model=new Model();

    public View(Model model){
        this.model=model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
