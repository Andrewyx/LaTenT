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

    @Override
    void initWindow() {

    }

    @Override
    public void editEntryCommand() {

    }

    @Override
    public void editEntryTitle() {

    }

    @Override
    public void editEntryDescription() {

    }

    @Override
    public void updateEntry(Entry newEntry, Entry oldEntry) {

    }

    @Override
    public void deleteEntry() {

    }

    @Override
    public void copyEntry(Entry entry) {

    }

    @Override
    public Entry runCreateEntry() {
        return null;
    }

}
