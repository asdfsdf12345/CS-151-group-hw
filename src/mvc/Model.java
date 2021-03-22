package mvc;

import tools.*;

public class Model extends Bean{

    private boolean unsavedChanges;
    private String fileName;

    public Model(){
        this.unsavedChanges = false;
        this.fileName = null;
    }

    public void changed(){
        this.unsavedChanges = true;
        firePropertyChange("unsavedChanges", false , true);

    }


}
