package texteditor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private final Gui gui;

    public KeyHandler(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getKeyCode() == KeyEvent.VK_S) {
            gui.functionFile.save();
        }
        if (keyEvent.isControlDown() && keyEvent.getKeyCode() == KeyEvent.VK_Z) {
            gui.functionEdit.undo();
        }
        if (keyEvent.isControlDown() && keyEvent.getKeyCode() == KeyEvent.VK_Y) {
            gui.functionEdit.redo();
        }
        if (keyEvent.isAltDown() && keyEvent.getKeyCode() == KeyEvent.VK_F) {
            gui.menuFile.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
