package texteditor;

import java.awt.*;

public class FunctionColor {
    private final Gui gui;

    public FunctionColor(Gui gui) {
        this.gui = gui;
    }

    public void setColor(String newColor) {
        if ("White".equals(newColor)) {
            gui.frame.getContentPane().setBackground(Color.WHITE);
            gui.textArea.setBackground(Color.WHITE);
            gui.textArea.setForeground(Color.BLACK);
        } else if ("Black".equals(newColor)) {
            gui.frame.getContentPane().setBackground(Color.BLACK);
            gui.textArea.setBackground(Color.BLACK);
            gui.textArea.setForeground(Color.WHITE);
        } else if ("Blue".equals(newColor)) {
            gui.frame.getContentPane().setBackground(Color.BLUE);
            gui.textArea.setBackground(Color.BLUE);
            gui.textArea.setForeground(Color.WHITE);
        }
    }
}
