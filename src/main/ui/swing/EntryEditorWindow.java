package ui.swing;

import model.Entry;
import ui.LaTenTApp;
import ui.util.Creator;
import ui.util.Editor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
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
        entryPanel.setLayout(new GridLayout(1, 2));
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
     * EFFECTS: makes label with given text and left alignment
     */
    private JPanel makeLabelLeftWithText(String text, JTextComponent textBox, Dimension maxSize) {
        JPanel panel = new JPanel();
        panel.setMaximumSize(maxSize);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        panel.add(textBox);
//        panel.add(Box.createHorizontalGlue());
        return panel;
    }

    /**
     * MODIFIES: this, catalogue, LaTenTWindow
     * EFFECTS: opens the editor with empty entry to create
     */
    @Override
    public Entry runCreateEntry() {
        JPanel userInputPanel = new JPanel();
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
        userInputPanel.add(makeLabelLeftWithText(
                "Title",
                enteredTitle,
                new Dimension(250, 40)
        ));
        userInputPanel.add(makeLabelLeftWithText(
                "Command",
                enteredCommand,
                new Dimension(250, 40)));
        userInputPanel.add(makeLabelLeftWithText(
                "Description",
                enteredDescription,
                new Dimension(250, 300)));
        enteredDescription.setLineWrap(true);
        enteredDescription.setWrapStyleWord(true);
        entryPanel.add(userInputPanel);

        entryPanel.add(new JPanel());
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
