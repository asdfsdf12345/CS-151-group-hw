package mvc;

import tools.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
//import javax.swing.text.Utilities;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    protected Model         model;
    protected View          view;
    protected JPanel        controlPanel;
    protected AppFactory    factory;

    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel(AppFactory factory) {
        this.factory = factory;
        model = factory.makeModel();
        JPanel controlPanel = new JPanel();
        view = factory.makeView(model);

        setLayout((new GridLayout(1, 2)));
        add(controlPanel);
        add(view);

        controlPanel.setBackground(Color.PINK);
        view.setBackground(Color.GRAY);


        frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New",  "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", new String[] {"Change"}, this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public void display() { frame.setVisible(true); }

    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();
            if (cmmd.equals("Save")) {
                try {
                    //String fName = Utilities.ask("File Name?");
                    String fName = Utilities.getFileName(null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(model);
                    os.close();
                } catch (Exception err) {
                    Utilities.error(err);
                }
            } else if (cmmd.equals("SaveAs")) {
                Utilities.save(model, true);
            } else if (cmmd.equals("Open")) {
                try {
                    String fName = Utilities.getFileName(null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    model.removePropertyChangeListener(this); //
                    model = (Model) is.readObject();
                    this.model.initSupport(); //
                    model.addPropertyChangeListener(this); //
                    view.setModel(model);
                    is.close();
                } catch (Exception err) {
                    Utilities.error(err.getMessage());
                }
            } else if (cmmd.equals("New")) {
                model = factory.makeModel();
                view.setModel(model);
            } else if (cmmd.equals("Quit")) {
                //Utilities.saveChanges(model);
                System.exit(1);
            } else if (cmmd.equals("About")) {
                Utilities.inform(factory.about());
            } else if (cmmd.equals("Help")) {
                Utilities.inform(factory.getHelp());
            } else if (cmmd.equals("Change")) {
                model.change();
            } else {
                //Utilities.error("Unrecognized command: " + cmmd);
                // from the edit menu
                Command command = factory.makeEditCommand(model, cmmd);
                command.execute();
            }
        } catch(Exception e) {
            handleException(e);
        }
    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}