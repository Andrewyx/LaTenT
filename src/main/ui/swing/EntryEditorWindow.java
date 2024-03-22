package ui.swing;

import model.Entry;
import ui.LaTenTApp;
import ui.util.Creator;
import ui.util.Editor;

import javax.swing.*;
import java.awt.*;

/**
 * Class containing the editor window of the application
 */
public class EntryEditorWindow extends Window implements Editor, Creator {
    private static Entry activeEntry;
    private JTextField enteredTitle;
    private JTextArea enteredDescription;
    private JTextField enteredCommand;
    private JPanel entryPanel;
    private JPanel buttonPanel;

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
        enteredCommand = new JTextField(16);
        enteredTitle = new JTextField(16);
        enteredDescription = new JTextArea(20, 16);
        entryPanel = new JPanel();
        entryPanel.setBackground(Color.gray);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.ORANGE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonPanel);
        this.add(entryPanel);

        if (activeEntry == null) {
            this.runCreateEntry();
        } else {
            this.editEntry();
        }
        JButton cancelButton = new JButton("Cancel");
        addWindowSwitchAction(cancelButton, "VIEW");
        buttonPanel.add(cancelButton);

        JButton confirmButton = new JButton("Confirm and Add");
        confirmButton.addActionListener(e -> {
            LaTenTApp.getCatalogue().addEntry(fetchEntryFromText());
        });
        buttonPanel.add(confirmButton);
        addPanelToMain(this, "EDITOR");
    }

    /**
     * MODIFIES: this, catalogue, LaTenTWindow
     * EFFECTS: opens the editor with empty entry to create
     */
    @Override
    public Entry runCreateEntry() {
        entryPanel.setLayout(new BoxLayout(entryPanel, BoxLayout.Y_AXIS));
        entryPanel.add(new JLabel("Title"));
        entryPanel.add(enteredTitle);
        entryPanel.add(new JLabel("Command"));
        entryPanel.add(enteredCommand);
        entryPanel.add(new JLabel("Description"));
        entryPanel.add(enteredDescription);
        entryPanel.add(Box.createVerticalGlue());
        entryPanel.add(Box.createHorizontalGlue());
        return null;
    }

    /**
     * EFFECTS: returns an entry with the users entered data on the panel
     */
    private Entry fetchEntryFromText() {
        return null;
    }


    /**
     * MODIFIES: this, catalogue, LaTenTWindow
     * EFFECTS: opens the editor with the active entry to edit
     */
    private void editEntry() {
        //TODO
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


    /**
     * MODIFIES: this
     * EFFECTS: Sets the current active entry to the given
     */
    public static void setActiveEntry(Entry entry) {
        activeEntry = entry;
    }
}
