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
        this.initWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the window
     */
    @Override
    protected void initWindow() {

    }

    /**
     * EFFECTS: Renders the catalogue dropdown
     */
    private void displayCatalogueDropdown() {
        EntryViewerPanel dropdown = new EntryViewerPanel();
        panel.add(dropdown.getPanel());

    }
}
