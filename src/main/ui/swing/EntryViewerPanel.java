package ui.swing;

import model.Entry;
import ui.LaTenTApp;
import ui.util.Viewer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for the view panel containing observable catalogue
 */
public class EntryViewerPanel extends JPanel implements Viewer {
    private final JPanel dropdownPanel;
    private final JPanel infoRenderPanel;
    private List<String> entryList;
    private JLabel title;
    private JLabel description;
    private JLabel command;
    private DefaultListModel<String> entryListModel;

    /**
     * EFFECTS: Creates new dual viewing panel for the viewing window
     */
    public EntryViewerPanel() {
        super();
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.YELLOW);
        title = new JLabel();
        description = new JLabel();
        command = new JLabel();
        dropdownPanel = new JPanel();
        infoRenderPanel = new JPanel();
        entryList = new ArrayList<>();
        entryListModel = new DefaultListModel<>();
        LaTenTApp.loadCatalogue();
        for (Entry entry: LaTenTApp.getCatalogue().getCatalogue().values()) {
            entryList.add(entry.getCommand());
            entryListModel.addElement(entry.getCommand());
        }

        initPanes();
    }

    /**
     * MODIFIES: dropdownPanel
     * EFFECTS: initializes dropdown panel presets
     */
    private void initDropdownPanel() {
        dropdownPanel.setBackground(Color.ORANGE);
    }

    /**
     * MODIFIES: infoRenderPanel
     * EFFECTS: initializes info render panel presets
     */
    private void initInfoRenderPanel() {
        infoRenderPanel.setLayout(new BoxLayout(infoRenderPanel, BoxLayout.Y_AXIS));
        infoRenderPanel.add(title);
        infoRenderPanel.add(command);
        infoRenderPanel.add(description);
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
     * EFFECTS: presents the dropdown panel with entries
     */
    @Override
    public void displayAllEntries() {
        JList listEntry = new JList(entryListModel);
        listEntry.setVisibleRowCount(4);
        JScrollPane jcp = new JScrollPane(listEntry);
        dropdownPanel.add(jcp);
        listEntry.addListSelectionListener(e -> {
            String selectedFruit = (String) listEntry.getSelectedValue();
            Entry entry = LaTenTApp.getCatalogue().getCatalogueEntry(selectedFruit);
            displayEntry(entry);
            EntryEditorWindow.setActiveEntry(entry);
        });
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
