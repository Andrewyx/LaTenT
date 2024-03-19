package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Viewing panel containing application action interactive options.
 */
public class EntryViewerWindow extends Window {

    /**
     * EFFECTS: creates main viewing window and initializes it
     */
    public EntryViewerWindow() {
        super();
    }

    /**
     * MODIFIES: LaTenTWindow
     * EFFECTS: creates window with content
     */
    @Override
    protected void initWindow() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        JButton startButton = new JButton("HOME");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(Color.PINK);

        addWindowSwitchAction(startButton, "HOME");

        JLabel title = new JLabel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setText("VIEWER PAGE");
        title.setBackground(Color.black);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(startButton);
        this.add(title);

        addPanelToMain(this, "VIEW");
    }
    /**
     * EFFECTS: Renders the catalogue dropdown
     */
    private void displayCatalogueDropdown() {
        EntryViewerPanel dropdown = new EntryViewerPanel();
        this.add(dropdown.getPanel());
    }
}
