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
    }

    /**
     * MODIFIES: this
     * EFFECTS: reads the next line from the user and saves it
     */
    protected void readNextLine() {
        this.userText = this.userInput.nextLine().toLowerCase();
    }

    /**
     * MODIFIES: this
     * EFFECTS: reads the next input from the user and saves it
     */
    protected void readNext() {
        this.userText = this.userInput.next().toLowerCase();
    }

    /**
     * EFFECTS: Runs the main widget processes
     */
    protected abstract void runWidget();

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
