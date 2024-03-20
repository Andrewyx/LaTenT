package ui.swing;

import model.Entry;
import ui.LaTenTApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Viewing panel containing application action interactive options.
 */
public class EntryViewerWindow extends Window {
    private static Entry selectedEntry;
    private EntryViewerPanel viewerPanel;

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
        viewerPanel = new EntryViewerPanel();
        this.setLayout(boxLayout);

        addButtonTray();
        addContentPanels();
//        JLabel title = new JLabel();
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        title.setText("VIEWER PAGE");
//        title.setBackground(Color.black);
//        title.setFont(new Font("Arial", Font.BOLD, 20));
//        this.add(title);
        addPanelToMain(this, "VIEW");
    }

    /**
     * MODIFIES: this, LaTentWindow
     * EFFECTS: Creates and adds a button tray to the viewer panel
     */
    private void addButtonTray() {
        JButton startButton = new JButton("HOME");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(Color.PINK);
        this.addWindowSwitchAction(startButton, "HOME");
        this.add(startButton);

        JLayeredPane tray = new JLayeredPane();
        tray.setLayout(new BoxLayout(tray, BoxLayout.X_AXIS));
        tray.setBackground(Color.ORANGE);
        tray.add(newEntryButton());
        tray.add(loadButton());
        tray.add(saveButton());
        tray.add(deleteButton());
        tray.add(editButton());

        this.add(tray);
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to make new entry
     */
    private JButton newEntryButton() {
        JButton newEntryButton = new JButton("New Entry");
        newEntryButton.addActionListener(e -> {
            EntryEditorWindow.setActiveEntry(null);
            mainLayout.show(mainPanel, "EDITOR");
        });
        return newEntryButton;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to load disk data
     */
    private JButton loadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> LaTenTApp.loadCatalogue());
        return  loadButton;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to save catalogue data to disk
     */
    private JButton saveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> LaTenTApp.saveCatalogue());
        return saveButton;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to delete current entry
     */
    private JButton deleteButton() {
        JButton deleteEntry = new JButton("Delete");
        deleteEntry.addActionListener(e -> {
            try {
                LaTenTApp.getCatalogue().removeEntry(selectedEntry);
            } catch (NullPointerException exception) {
                System.out.println("No entry selected");
            }
        });
        return deleteEntry;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to edit selected entry
     */
    private JButton editButton() {
        JButton editEntry = new JButton("Edit");
        editEntry.addActionListener(e -> {
            EntryEditorWindow.setActiveEntry(selectedEntry);
            mainLayout.show(mainPanel, "EDITOR");
        });
        return editEntry;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates and adds catalogue viewing panels to the viewer panel
     */
    private void addContentPanels() {
        this.add(viewerPanel);
    }

    /**
     * MODIFIES: this
     * EFFECTS: setter for the current active entry
     */
    public static void setSelectedEntry(Entry entry) {
        selectedEntry = entry;
    }
}
