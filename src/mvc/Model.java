package mvc;

import tools.*;

abstract public class Model extends Bean{

    private boolean unsavedChanges;
    private String fileName;

    public Model(){
        this.unsavedChanges = false;
        this.fileName = null;
    }

    public void changed(){
        unsavedChanges = true;
        firePropertyChange("unsavedChanges", false , true);

    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean s){
        this.unsavedChanges= s;
    }
    
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String newFile) {
        this.fileName = newFile;
    }


}
