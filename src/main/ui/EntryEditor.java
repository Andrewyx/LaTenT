package ui;

import model.Entry;

/**
 * Opens Editor interface for modifying or deleting entries
 */
public class EntryEditor extends Widget {
    private Entry activeEntry;
    private Entry initialEntry;

    /**
     * EFFECTS: Creates new widget interface for the editor
     */
    public EntryEditor(Entry entry) {
        super();
        this.activeEntry = entry;
        this.copyEntry(entry);
        this.runWidget();
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
            System.out.println("Finish & Quit -> " + Constants.QUIT);
            this.readNextLine();
            this.handleInput(this.userText);
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
                this.editEntryCommand();
                break;
            case Constants.EDIT_ENTRY_TITLE:
                System.out.println("Enter new Title");
                this.editEntryTitle();
                break;
            case Constants.EDIT_ENTRY_DESCRIPTION:
                System.out.println("Enter new Description");
                this.editEntryDescription();
                break;
            case Constants.DELETE_ENTRY:
                System.out.println("DELETING ENTRY");
                this.deleteEntry();
                break;
            case Constants.QUIT:
                this.editorState = false;
                break;
        }
        this.updateEntry(this.activeEntry, this.initialEntry);
    }

    /**
     * MODIFIES: Entry activeEntry
     * EFFECTS:  changes the command of the active entry
     */
    private void editEntryCommand() {
        while (this.editorState) {
            super.readNextLine();
            this.activeEntry.changeCommand(this.userText);
            if (super.confirmChoice()) {
                break;
            }
        }
    }

    /**
     * MODIFIES: Entry activeEntry
     * EFFECTS:  changes the title of the active entry
     */
    private void editEntryTitle() {
        while (this.editorState) {
            super.readNextLine();
            this.activeEntry.changeTitle(this.userText);
            if (super.confirmChoice()) {
                break;
            }
        }
    }

    /**
     * MODIFIES: Entry activeEntry
     * EFFECTS:  changes the description of the active entry
     */
    private void editEntryDescription() {
        while (this.editorState) {
            super.readNextLine();
            this.activeEntry.changeDescription(this.userText);
            if (super.confirmChoice()) {
                break;
            }
        }
    }

    /**
     *  REQUIRES: oldEntry must exist in catalogue
     *  MODIFIES: this, Catalogue in LaTenTApp
     *  EFFECTS: Updates the entry in the catalogue with new values
     */
    private void updateEntry(Entry newEntry, Entry oldEntry) {
        LaTenTApp.getCatalogue().removeEntry(oldEntry);
        LaTenTApp.getCatalogue().addEntry(newEntry);
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

    /**
     * MODIFIES: this
     * EFFECTS: Clones the given entry as the class' initial entry
     */
    private void copyEntry(Entry entry) {
        this.initialEntry = entry;
    }
}
