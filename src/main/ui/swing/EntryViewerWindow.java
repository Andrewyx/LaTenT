package ui.swing;

/**
 * Viewing panel containing application action interactive options.
 */
public class EntryViewerWindow extends Window {

    /**
     * EFFECTS: creates main viewing window
     */
    public EntryViewerWindow() {
        super();
    }

    /**
     * EFFECTS: Renders the catalogue dropdown
     */
    public void displayCatalogueDropdown() {
        EntryViewerPanel dropdown = new EntryViewerPanel();
        panel.add(dropdown.getPanel());

    }
}
