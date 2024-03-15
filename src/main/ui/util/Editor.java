package ui.util;

import model.Entry;

/**
 * Interface for Editor GUI interfaces
 */
public interface Editor {
    void editEntryCommand();

    void editEntryTitle();

    void editEntryDescription();

    void updateEntry(Entry newEntry, Entry oldEntry);

    void deleteEntry();

    void copyEntry(Entry entry);
}
