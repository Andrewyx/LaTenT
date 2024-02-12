package ui;

import model.Entry;

/**
 * Entry Creator widget to construct new Entries
 */
public class EntryCreator extends Widget {
    public EntryCreator() {
        super();
    }

    /**
     * MODIFIES: Catalogue in LaTenTApp
     * EFFECTS: Runs Entry creation widget
     */
    @Override
    public void runWidget() {
        Entry newEntry = this.runCreateEntry();
        if (newEntry != null) {
            LaTenTApp.getCatalogue().addEntry(newEntry);
        }
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
            if (super.confirmChoice()) {
                return new Entry(title, description, command);
            }
        }
        return null;
    }
}
