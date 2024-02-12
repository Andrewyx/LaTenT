package ui;

import model.Entry;

/**
 * Opens Editor interface for modifying or deleting entries
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
     * MODIFIES: this
     * EFFECTS: Runs editor widget
     */
    @Override
    public void runWidget() {
        this.runEditor(this.activeEntry);
    }

    /**
     * MODIFIES: this
     * EFFECTS: Runs editor processes and processes user input
     */
    public void runEditor(Entry entry) {
        while (this.editorState) {
            System.out.println("Editing: " + entry.getCommand());
            System.out.println("Change Title -> " + Constants.EDIT_ENTRY_TITLE);
            System.out.println("Change Command -> " + Constants.EDIT_ENTRY_COMMAND);
            System.out.println("Change Description -> " + Constants.EDIT_ENTRY_DESCRIPTION);
            this.userText =  this.userInput.nextLine().toLowerCase();
        }
    }

    /**
     * REQUIRES: input can not be null
     * MODIFIES: this
     * EFFECTS: reads and processes user input
     */
    private void handleInput(String input) {
        switch (input) {
            case Constants.EDIT_ENTRY_COMMAND:
                System.out.println("Enter new Command");
                this.newEntry();
                break;
            case Constants.EDIT_ENTRY_TITLE:
                System.out.println("Enter new Title");
                this.findEntry();
                break;
            case Constants.EDIT_ENTRY_DESCRIPTION:
                System.out.println("Enter new Description");
                this.openEntry();
                break;
            case Constants.DELETE_ENTRY:
                System.out.println("DELETING ENTRY");
                this.deleteEntry();
                break;
        }
    }

    /**
     * MODIFIES: Catalogue in LaTenTApp
     * EFFECTS: Deletes the current active entry from the catalogue
     */
    private void deleteEntry() {
        if (super.confirmChoice()) {
            LaTenTApp.getCatalogue().removeEntry(activeEntry);
        } else {
            System.out.println("Cancelling Deletion");
        }
    }
}
