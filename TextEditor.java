package texteditor;

import javax.swing.*;

/**
 * @author Adam Awiżeń
 * Notepad style application that can open, edit, and save text documents. Provide syntax highlighting and other features.
 */

public class TextEditor {

    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;

    public static void main(String[] args) {
        new TextEditor();
    }

    public TextEditor() {
        //there all the magic happens
        createWindow();
        createTextArea();
        frame.add(textArea);
    }

    public void createWindow() {
        frame = new JFrame("Notepad");
        frame.setSize(800, 600);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
