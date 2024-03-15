package ui.util;

import model.Entry;

/**
 * Interface for GUIs with viewing capabilities.
 */
public interface Viewer {
    void displayAllEntries();

    void displayEntry(Entry entry);
}
