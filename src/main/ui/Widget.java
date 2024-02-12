package ui;

import java.util.Scanner;

/**
 * Abstract class for widgets
 */
public abstract class Widget {
    protected boolean editorState;
    protected Scanner userInput;
    protected String userText = "";

    /**
     * EFFECTS: Creates new widget without active entry
     */
    public Widget() {
        this.editorState = true;
        this.userInput = new Scanner(System.in);
        this.runWidget();
    }

    /**
     * EFFECTS: Runs the main widget processes
     */
    public abstract void runWidget();

    /**
     * EFFECTS: produces true if the user enters confirm
     */
    protected boolean confirmChoice() {
        while (true) {
            System.out.println("Type <YES> to confirm choice, or <q> to exit");
            this.userText = this.userInput.next().toLowerCase();
            if (userText.equals("yes")) {
                return true;
            } else if (userText.equals("q")) {
                return false;
            }
        }
    }
}
