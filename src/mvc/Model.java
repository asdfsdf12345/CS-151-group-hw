package mvc;

import tools.*;

public class Model extends Bean{

    private boolean unsavedChanges;
    private String fileName;

    public Model(){
        unsavedChanges = false;
        fileName = null;
    }

    public void changed(){
        unsavedChanges = true;
        firePropertyChange("unsavedChanges", false , true);

    }


}
