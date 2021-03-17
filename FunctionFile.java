package texteditor;

import java.awt.*;
import java.io.File;

public class FunctionFile {
    private final Gui gui;

    public FunctionFile(Gui gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.frame.setTitle("New");
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.frame, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            System.out.println(":)");
        } else {
            System.out.println(":(");
        }
    }
}
