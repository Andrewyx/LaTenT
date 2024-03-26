package ui.swing;

import model.Entry;
import org.scilab.forge.jlatexmath.ParseException;
import ui.LaTeXRenderer;
import ui.LaTenTApp;
import ui.util.Constants;
import ui.util.Creator;
import ui.util.LaTeXImageLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * Class containing the editor window of the application
 */
public class EntryEditorWindow extends Window implements Creator {
    private static Entry activeEntry;
    private static JTextField enteredTitle;
    private static JTextArea enteredDescription;
    private static JTextField enteredCommand;
    private JPanel entryEditorPanel;
    private JPanel buttonPanel;
    private static JButton submissionButton;

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
        this.setLayout(new BorderLayout());
        initButtonTray();
        initEditorPanel();
        updateMode();
        addPanelToMain(this, "EDITOR");
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the panel containing button tray for user commands
     */
    private void initButtonTray() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.ORANGE);

        JButton cancelButton = new JButton("Cancel");
        addWindowSwitchAction(cancelButton, "VIEW");
        buttonPanel.add(cancelButton);

        submissionButton = new JButton("NULL");
        buttonPanel.add(submissionButton, "SWAP");
        buttonPanel.setBorder(new LineBorder(Constants.COPPER));
        this.add(buttonPanel, BorderLayout.NORTH);
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes editor panel region
     */
    private void initEditorPanel() {
        entryEditorPanel = new JPanel();
        entryEditorPanel.setLayout(new GridLayout(1, 2));
        entryEditorPanel.setBackground(Color.gray);
        entryEditorPanel.add(initUserInputPanel());
        entryEditorPanel.add(initValidationPanel());
        this.add(entryEditorPanel);
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets the submission button to add new entry
     */
    private void setSubmissionButtonToNew() {
        JButton confirmButton = new JButton("Confirm and Add");
        confirmButton.addActionListener(e -> {
            LaTenTApp.getCatalogue().addEntry(fetchEntryFromText());
            LaTenTWindow.getEntryViewerWindow().getViewerPanel().updateDisplayAllEntries();
            refreshPane();
            mainLayout.show(mainPanel, "VIEW");
        });

        buttonPanel.remove(submissionButton);
        submissionButton = confirmButton;
        buttonPanel.add(submissionButton);
        this.revalidate();
        this.repaint();
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets the submission button to edit pre-existing entry
     */
    private void setSubmissionButtonToEdit() {
        JButton editButton = new JButton("Confirm and Change");
        editButton.addActionListener(e -> {
            updateEntry(fetchEntryFromText(), activeEntry);
            LaTenTWindow.getEntryViewerWindow().getViewerPanel().updateDisplayAllEntries();
            refreshPane();
            mainLayout.show(mainPanel, "VIEW");
        });

        buttonPanel.remove(submissionButton);
        submissionButton = editButton;
        buttonPanel.add(submissionButton);
        this.revalidate();
        this.repaint();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the editor panel's sub-panel for rendering commands
     */
    private JPanel initValidationPanel() {
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Constants.PLATINUM);
        imagePanel.setLayout(new GridLayout(2, 1));
        LaTeXImageLabel label = new LaTeXImageLabel();
        JButton renderButton = new JButton("Render");
        renderButton.setFont(Constants.HEADER_ONE_BOLD);
        JPanel renderPanel = new JPanel();
        renderPanel.setLayout(new BorderLayout());
        renderButton.setBackground(Constants.PLATINUM);
        renderPanel.add(renderButton, BorderLayout.CENTER);
        renderPanel.setBorder(new EmptyBorder(100, 40, 100, 40));
        renderButton.addActionListener(e -> {
            try {
                new LaTeXRenderer(enteredCommand.getText());
            } catch (ParseException exception) {
                label.setIcon(null);
                label.setText("INVALID COMMAND");
            }
            label.refreshLabelLatexIcon("data/latex.png");
        });
        imagePanel.add(label);
        imagePanel.add(renderPanel);

        return imagePanel;
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the text fields for the editor
     */
    private void makeTextInputs() {
        enteredCommand = new JTextField(16);
        enteredCommand.setMaximumSize(new Dimension(10000, enteredCommand.getPreferredSize().height));
        enteredTitle = new JTextField(16);
        enteredTitle.setMaximumSize(new Dimension(10000, enteredTitle.getPreferredSize().height));
        enteredDescription = new JTextArea(20, 16);
        enteredDescription.setLineWrap(true);
        enteredDescription.setWrapStyleWord(true);
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the sub-panel containing user inputs text fields for editing entries
     */
    private JPanel initUserInputPanel() {
        this.makeTextInputs();

        JPanel userInputPanel = new JPanel();

        userInputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
        userInputPanel.setBackground(Constants.SILVER);

        userInputPanel.add(makeLabelLeftWithText(
                "Title",
                enteredTitle,
                Constants.SILVER));
        userInputPanel.add(makeLabelLeftWithText(
                "Command",
                enteredCommand,
                Constants.SILVER));
        userInputPanel.add(makeLabelLeftWithText(
                "Description",
                enteredDescription,
                Constants.SILVER));
        return userInputPanel;
    }

    /**
     * EFFECTS: makes label with given text and left alignment
     */
    private JPanel makeLabelLeftWithText(String text, JTextComponent textBox, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(text);
        label.setFont(Constants.DEFAULT_FONT_PLAIN);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(new EmptyBorder(0, 0, 5, 0));
        panel.add(label);
        panel.add(textBox);
        return panel;
    }

    /**
     * MODIFIES: this, catalogue, LaTenTWindow
     * EFFECTS: opens the editor with empty entry to create
     */
    @Override
    public Entry runCreateEntry() {
        enteredTitle.setText("");
        enteredCommand.setText("");
        enteredDescription.setText("");
        return null;
    }

    /**
     * EFFECTS: returns an entry with the users entered data on the panel
     */
    private Entry fetchEntryFromText() {
        Entry entry = new Entry(
                enteredTitle.getText(),
                enteredDescription.getText(),
                enteredCommand.getText()
        );
        return entry;
    }

    /**
     * MODIFIES: this, catalogue, LaTenTWindow
     * EFFECTS: opens the editor with the active entry to edit
     */
    private void loadEditEntry() {
        enteredTitle.setText(activeEntry.getTitle());
        enteredDescription.setText(activeEntry.getDescription());
        enteredCommand.setText(activeEntry.getCommand());
    }

    /**
     * REQUIRES: oldEntry must exist in catalogue
     * MODIFIES: this, Catalogue in LaTenTApp
     * EFFECTS: Updates the entry in the catalogue with new values
     */
    public void updateEntry(Entry newEntry, Entry oldEntry) {
        LaTenTApp.getCatalogue().removeEntry(oldEntry);
        LaTenTApp.getCatalogue().addEntry(newEntry);
    }

    /**
     * MODIFIES: Catalogue in LaTenTApp
     * EFFECTS: Deletes the current active entry from the catalogue
     */
    public void deleteEntry() {
        LaTenTApp.getCatalogue().removeEntry(activeEntry);
        activeEntry = null;
    }

    /**
     * MODIFIES: this
     * EFFECTS: Sets the current active entry to the given
     */
    public void setActiveEntry(Entry entry) {
        activeEntry = entry;
        updateMode();
    }

    /**
     * MODIFIES: this
     * EFFECTS: updates the editor's mode to either creation or editing
     */
    public void updateMode() {
        if (activeEntry == null) {
            this.setSubmissionButtonToNew();
            this.runCreateEntry();
        } else {
            this.setSubmissionButtonToEdit();
            this.loadEditEntry();
        }
    }
}
