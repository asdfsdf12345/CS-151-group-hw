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

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public void setUnsavedChanges(boolean b) {
        boolean oldBool = unsavedChanges;
        unsavedChanges = b;
        firePropertyChange("unsavedChanges", oldBool, b);
    }/**/
}
