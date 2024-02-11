package ui;

import model.Entry;

import java.util.Scanner;

/**
 * Opens Editor interface for creating or modifying entries
 */
public class EntryEditor extends Widget {
    private Entry activeEntry;

    /**
     * EFFECTS: Creates new widget interface for the editor
     */
    public EntryEditor(Entry entry) {
        super();
        this.activeEntry = entry;
    }

    /**
     * EFFECTS: Runs editor widget
     */
    @Override
    public void runWidget() {

    }

    /**
     * MODIFIES: this
     * EFFECTS: Runs editor processes and processes user input
     */
    public void runEditor(Entry entry) {
        while (this.editorState) {

        }
    }

    /**
     * EFFECTS: Deletes the provided entry from the catalogue
     */
    private void deleteEntry(Entry entry) {
        //stub
    }


    /**
     *  MODIFIES: this
     *  EFFECTS: Runs the create new entry process and processes user input
     */
    public Entry runCreateEntry() {
        String title;
        String command;
        String description;
        while (this.editorState) {
            System.out.println("Enter new Entry Title: ");
            title = this.userInput.nextLine();

            System.out.println("Enter new Entry Command: ");
            command = this.userInput.nextLine();

            System.out.println("Enter new Entry Description: ");
            description = this.userInput.nextLine();
            if (confirmChoice()) {
                return new Entry(title, description, command);
            }
        }
        return null;
    }

    /**
     * EFFECTS: produces true if the user enters confirm
     */
    private boolean confirmChoice() {
        while (true) {
            System.out.println("Type <YES> to confirm choice, or <q> to exit");
            String userText = this.userInput.next().toLowerCase();
            if (userText.equals("yes")) {
                return true;
            } else if (userText.equals("q")) {
                return false;
            }
        }
    }
}
