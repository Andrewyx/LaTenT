package ui;

import model.Entry;

/**
 * Opens Editor interface for creating or modifying entries
 */
public class EntryEditor {
    private boolean editorState;
    private Entry activeEntry;

    /**
     * EFFECTS: Creates new editor interface and runs it
     */
    public EntryEditor() {
        this.editorState = true;
    }

    /**
     * EFFECTS: Runs editor processes and processes user input
     */
    private void runEditor() {
        while (this.editorState) {

        }
    }

    /**
     * EFFECTS: Deletes the current active entry
     */
    private void deleteEntry() {
        //stub
    }
}
