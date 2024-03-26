package ui.swing;

import model.Entry;
import ui.LaTenTApp;
import ui.util.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

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
        viewerPanel = new EntryViewerPanel();
        this.setLayout(new BorderLayout());
        this.add(makeButtonTray(), BorderLayout.NORTH);
        addContentPanels();
        addPanelToMain(this, "VIEW");
    }

    /**
     * MODIFIES: this, LaTentWindow
     * EFFECTS: Creates and adds a button tray to the viewer panel
     */
    private JPanel makeButtonTray() {
        JButton startButton = new JButton("HOME");
        this.addWindowSwitchAction(startButton, "HOME");

        JPanel tray = new JPanel();
        tray.setLayout(new FlowLayout(FlowLayout.CENTER));
        tray.setBackground(Color.ORANGE);
        tray.add(newEntryButton());
        tray.add(loadButton());
        tray.add(saveButton());
        tray.add(deleteButton());
        tray.add(editButton());
        tray.add(startButton);
        tray.setBorder(new LineBorder(Constants.COPPER));
        return tray;
    }

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: Creates button to make new entry
     */
    private JButton newEntryButton() {
        JButton newEntryButton = new JButton("New Entry");
        newEntryButton.addActionListener(e -> {
            LaTenTWindow.getEntryEditorWindow().setActiveEntry(null);
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
        loadButton.addActionListener(e -> {
            LaTenTApp.loadCatalogue();
            viewerPanel.updateDisplayAllEntries();
        });
        return loadButton;
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
                viewerPanel.updateDisplayAllEntries();
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
            LaTenTWindow.getEntryEditorWindow().setActiveEntry(selectedEntry);
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
    public void setSelectedEntry(Entry entry) {
        selectedEntry = entry;
    }

    /**
     * EFFECTS: getter for viewer panel
     */
    public EntryViewerPanel getViewerPanel() {
        return viewerPanel;
    }
}
