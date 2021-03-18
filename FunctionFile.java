package texteditor;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FunctionFile {
    private final Gui gui;
    private String fileName;
    private String filePath;

    public FunctionFile(Gui gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.frame.setTitle("New");
        fileName = null;
        filePath = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.frame, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            filePath = fd.getDirectory();
            gui.frame.setTitle(fileName);
        } else {
            System.out.println("No functionFile is select");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileName))) {
            gui.textArea.setText("");
            String line;
            while ((line = br.readLine()) != null) gui.textArea.append(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try (FileWriter fw = new FileWriter(filePath + fileName)) {
                fw.write(gui.textArea.getText());
                gui.frame.setTitle(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.frame, "Save as", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            filePath = fd.getDirectory();
            gui.frame.setTitle(fileName);
        }

        try (FileWriter fw = new FileWriter(filePath + fileName)) {
            fw.write(gui.textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        if (fileName == null) {
            saveAs();
        }

        System.exit(0);
    }
}
