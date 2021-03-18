package texteditor;

import java.awt.*;

public class FunctionFormat {
    private final Gui gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public FunctionFormat(Gui gui) {
        this.gui = gui;
    }

    void wrap() {
        gui.textArea.setLineWrap(!gui.textArea.getLineWrap());
        if (gui.textArea.getLineWrap()) {
            gui.iWrap.setText("Word wrap: On");
            gui.textArea.setWrapStyleWord(true);
        } else {
            gui.iWrap.setText("Word wrap: Off");
            gui.textArea.setWrapStyleWord(false);
        }
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String fontName) {
        selectedFont = fontName;

        if ("Arial".equals(selectedFont)) gui.textArea.setFont(arial);
        else if ("Comic Sans MS".equals(selectedFont)) gui.textArea.setFont(comicSansMS);
        else if ("Times New Roman".equals(selectedFont)) gui.textArea.setFont(timesNewRoman);
    }
}
