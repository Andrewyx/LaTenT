package ui;

import model.Entry;

import java.util.Scanner;

/**
 * Abstract class for widgets
 */
public abstract class Widget {
    protected boolean editorState;
    protected Scanner userInput;

    /**
     * EFFECTS: Creates new widget without active entry
     */
    public Widget() {
        this.editorState = true;
        this.userInput = new Scanner(System.in);
    }

    /**
     * EFFECTS: Runs the main widget processes
     */
    public abstract void runWidget();
}
