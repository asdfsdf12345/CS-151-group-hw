package mvc;

<<<<<<< HEAD
import javax.swing.*;
import java.beans.*;


public class View extends JPanel implements PropertyChangeListener {
    public Model model;

    public View(Model model) {
        this.model = model;
        //model.subscribe(this);
        model.addPropertyChangeListener(this);
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public void propertyChange(PropertyChangeEvent arg0) {
    }

=======
public class View {
    
>>>>>>> parent of 3f64434 (most of mvc and some parts of minefield)
}
