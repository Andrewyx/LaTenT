package ui.swing;

import model.Entry;
import ui.util.Creator;
import ui.util.Editor;

/**
 * Class containing the editor window of the application
 */
public class EntryEditorWindow extends Window implements Editor, Creator {
    private static Entry activeEntry;

    /**
     * EFFECTS: creates and initializes the editor window
     */
    public EntryEditorWindow() {
        super();
    }

    /**
     * MODIFIES: LaTenTWindow
     * EFFECTS: creates window with content
     */
    @Override
    void initWindow() {

        addPanelToMain(this, "EDITOR");
    }

    @Override
    public void editEntryCommand() {
        //TODO
    }

    @Override
    public void editEntryTitle() {
        //TODO
    }

    @Override
    public void editEntryDescription() {
        //TODO
    }

    @Override
    public void updateEntry(Entry newEntry, Entry oldEntry) {
        //TODO
    }

    @Override
    public void deleteEntry() {
        //TODO
    }

    @Override
    public void copyEntry(Entry entry) {
        //TODO
    }

    @Override
    public Entry runCreateEntry() {
        return null;
    }

    /**
     * MODIFIES: this
     * EFFECTS: Sets the current active entry to the given
     */
    public static void setActiveEntry(Entry entry) {
        activeEntry = entry;
    }
}
