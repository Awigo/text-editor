package texteditor;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Adam Awiżeń
 * Notepad style application that can open, edit, and save text documents. Provide syntax highlighting and other features.
 */

public class Gui implements ActionListener {

    //TEXT AREA
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    //FILE MENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //EDIT MENU
    JMenuItem iUndo, iRedo;
    //FORMAT MENU
    JMenu font, fontSize;
    JMenuItem iWrap, iFontArial, iFontComic, iFontTimes, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    //COLOR MENU
    JMenuItem iColor1, iColor2, iColor3;

    FunctionFile functionFile = new FunctionFile(this);
    FunctionEdit functionEdit = new FunctionEdit(this);
    FunctionFormat functionFormat = new FunctionFormat(this);
    FunctionColor functionColor = new FunctionColor(this);
    KeyHandler keyHandler = new KeyHandler(this);

    UndoManager undoManager = new UndoManager();

    public static void main(String[] args) {
        new Gui();
    }

    public Gui() {
        //there all the magic happens
        createWindow();
        createTextArea();

        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        functionFormat.setFont("Arial");
        functionFormat.createFont(16);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createWindow() {
        frame = new JFrame("Notepad");
        frame.setSize(800, 600);
    }

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(undoableEditEvent -> {
            undoManager.addEdit(undoableEditEvent.getEdit());
        });
        textArea.addKeyListener(keyHandler);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save as...");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word wrap: On");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Wrap");
        menuFormat.add(iWrap);

        font = new JMenu("Font");
        menuFormat.add(font);

        fontSize = new JMenu("Font size");
        menuFormat.add(fontSize);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        font.add(iFontArial);

        iFontComic = new JMenuItem("Comic Sans MS");
        iFontComic.addActionListener(this);
        iFontComic.setActionCommand("Comic Sans MS");
        font.add(iFontComic);

        iFontTimes = new JMenuItem("Times New Roman");
        iFontTimes.addActionListener(this);
        iFontTimes.setActionCommand("Times New Roman");
        font.add(iFontTimes);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Font Size 8");
        fontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Font Size 12");
        fontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Font Size 16");
        fontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Font Size 20");
        fontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Font Size 24");
        fontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Font Size 28");
        fontSize.add(iFontSize28);
    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        //Menu functionFile
        if ("New".equals(command)) functionFile.newFile();
        else if ("Open".equals(command)) functionFile.open();
        else if ("Save".equals(command)) functionFile.save();
        else if ("Save as".equals(command)) functionFile.saveAs();
        else if ("Exit".equals(command)) functionFile.exit();
            //Menu functionEdit
        else if ("Undo".equals(command)) functionEdit.undo();
        else if ("Redo".equals(command)) functionEdit.redo();
            //Menu functionFont
        else if ("Wrap".equals(command)) functionFormat.wrap();
        else if ("Arial".equals(command)) functionFormat.setFont(command);
        else if ("Comic Sans MS".equals(command)) functionFormat.setFont(command);
        else if ("Times New Roman".equals(command)) functionFormat.setFont(command);
        else if ("Font Size 8".equals(command)) functionFormat.createFont(8);
        else if ("Font Size 12".equals(command)) functionFormat.createFont(12);
        else if ("Font Size 16".equals(command)) functionFormat.createFont(16);
        else if ("Font Size 20".equals(command)) functionFormat.createFont(20);
        else if ("Font Size 24".equals(command)) functionFormat.createFont(24);
        else if ("Font Size 28".equals(command)) functionFormat.createFont(28);
            //Menu functionColor
        else if ("White".equals(command)) functionColor.setColor(command);
        else if ("Black".equals(command)) functionColor.setColor(command);
        else if ("Blue".equals(command)) functionColor.setColor(command);


    }
}
