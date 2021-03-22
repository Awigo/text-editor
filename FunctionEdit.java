package texteditor;

public class FunctionEdit {

    Gui gui;

    public FunctionEdit(Gui gui) {
        this.gui = gui;
    }

    public void undo() {

        try {
            gui.undoManager.undo();
        } catch (Exception e) {
            System.err.println("Cannot undo!");
        }
    }

    public void redo() {
        try {
            gui.undoManager.redo();
        } catch (Exception e) {
            System.err.println("Cannot redo!");
        }
    }
}
