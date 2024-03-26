package ui.swing;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import model.Entry;
import org.scilab.forge.jlatexmath.ParseException;
import ui.LaTeXRenderer;
import ui.LaTenTApp;
import ui.util.Constants;
import ui.util.LaTeXImageLabel;
import ui.util.Viewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class for the view panel containing observable catalogue
 */
public class EntryViewerPanel extends JPanel implements Viewer {
    private final JPanel dropdownPanel;
    private final JPanel infoRenderPanel;
    private JLabel title;
    private JLabel description;
    private JLabel command;
    private DefaultListModel<String> entryListModel;
    private JList listEntry;
    private JScrollPane listEntryPanel;
    private LaTeXImageLabel label;

    /**
     * EFFECTS: Creates new dual viewing panel for the viewing window
     */
    public EntryViewerPanel() {
        super();
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Constants.GOLDENROD);
        title = new JLabel();
        description = new JLabel();
        command = new JLabel();
        dropdownPanel = new JPanel();
        infoRenderPanel = new JPanel();
        this.updateDisplayAllEntries();
        this.initPanes();
    }

    /**
     * MODIFIES: dropdownPanel
     * EFFECTS: initializes dropdown panel presets
     */
    private void initDropdownPanel() {
        dropdownPanel.setLayout(new BoxLayout(dropdownPanel, BoxLayout.Y_AXIS));
        dropdownPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    /**
     * MODIFIES: infoRenderPanel
     * EFFECTS: initializes info render panel presets
     */
    private void initInfoRenderPanel() {
        infoRenderPanel.setLayout(new GridLayout(2, 1));
        JPanel captionPanel = new JPanel();
        captionPanel.setLayout(new BoxLayout(captionPanel, BoxLayout.Y_AXIS));
        captionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        title.setFont(Constants.HEADER_ONE_BOLD);
        command.setFont(Constants.HEADER_TWO_PLAIN);
        description.setFont(Constants.HEADER_TWO_PLAIN);
        captionPanel.add(title);
        captionPanel.add(command);
        captionPanel.add(description);

        label = new LaTeXImageLabel();
        infoRenderPanel.add(label);

        infoRenderPanel.add(captionPanel);
        infoRenderPanel.setBackground(Color.gray);
    }

    /**
     * MODIFIES: this
     * EFFECTS: populates the view pane with entries
     */
    private void initPanes() {
        initDropdownPanel();
        initInfoRenderPanel();
        displayAllEntries();
        this.add(dropdownPanel);
        this.add(infoRenderPanel);
    }

    /**
     * MODIFIES: this
     * EFFECTS: makes new listEntry with event actions
     */
    private void makeNewListEntryPanel() {
        listEntry = new JList(entryListModel);
        listEntry.setVisibleRowCount(4);
        listEntryPanel = new JScrollPane(listEntry);
        listEntry.addListSelectionListener(e -> {
            String selectedEntry = (String) listEntry.getSelectedValue();
            Entry entry = LaTenTApp.getCatalogue().getCatalogueEntry(selectedEntry);
            displayEntry(entry);
            LaTenTWindow.getEntryViewerWindow().setSelectedEntry(entry);
            try {
                new LaTeXRenderer(entry.getCommand());
            } catch (ParseException exception) {
                label.setIcon(null);
                label.setText("INVALID COMMAND");
            }
            label.refreshLabelLatexIcon("data/latex.png");
        });
    }


    /**
     * MODIFIES: this
     * EFFECTS: presents the dropdown panel with entries and search bar
     */
    @Override
    public void displayAllEntries() {
        JLabel searchLabel = new JLabel("Search");
        searchLabel.setFont(Constants.HEADER_TWO_PLAIN);
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropdownPanel.add(searchLabel);
        dropdownPanel.add(makeSearchbar());
        makeNewListEntryPanel();
        dropdownPanel.add(listEntryPanel);
    }

    /**
     * EFFECTS: returns search window for dropdown with sorting abilities
     */
    private JTextField makeSearchbar() {
        JTextField searchBar = new JTextField();
        searchBar.setMaximumSize(new Dimension(50000, 1000));
        searchBar.addActionListener(e -> {
            if (Objects.equals(searchBar.getText(), "")) {
                this.updateDisplayAllEntries();
            } else {
                this.updateDisplayAllEntries(this.sortEntryListByString(searchBar.getText()));
            }
        });
        return searchBar;
    }

    /**
     * MODIFIES: this
     * EFFECTS: reorders the entry list by keyword likeness
     */
    private  DefaultListModel<String> sortEntryListByString(String keyword) {
        ArrayList<String> entryListAsStrings = Collections.list(entryListModel.elements());
        List<ExtractedResult> rawMatches = FuzzySearch.extractSorted(keyword, entryListAsStrings);
        List<String> matches = rawMatches.stream().map(extractedResult ->
                extractedResult.getString()).collect(Collectors.toList());
        DefaultListModel<String> sortedEntryListModel = new DefaultListModel<>();
        for (String entryText: matches) {
            sortedEntryListModel.addElement(entryText);
        }
        return sortedEntryListModel;
    }

    /**
     * EFFECTS: Returns a default list containing the commands in the catalogue
     */
    private DefaultListModel<String> updateEntryListModel() {
        DefaultListModel<String> entryList = new DefaultListModel<>();
        for (Entry entry : LaTenTApp.getCatalogue().getCatalogue().values()) {
            entryList.addElement(entry.getCommand());
        }
        return entryList;
    }

    /**
     * MODIFIES: this
     * EFFECTS: updates the list of command renders
     */
    public void updateDisplayAllEntries() {
        entryListModel = updateEntryListModel();
        this.revalidateDropdown();
    }

    /**
     * MODIFIES: this
     * EFFECTS: updates the list of command renders to the given
     */
    public void updateDisplayAllEntries(DefaultListModel<String> newEntryListModel) {
        entryListModel = newEntryListModel;
        this.revalidateDropdown();
    }

    private void revalidateDropdown() {
        try {
            dropdownPanel.remove(listEntryPanel);
            makeNewListEntryPanel();
            dropdownPanel.add(listEntryPanel);
            this.revalidate();
            this.repaint();
        } catch (NullPointerException e) {
            // Do nothing
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: displays the given entry details on the infoRenderPanel
     */
    @Override
    public void displayEntry(Entry entry) {
        title.setText(entry.getTitle());
        description.setText(entry.getDescription());
        command.setText(entry.getCommand());
    }
}
