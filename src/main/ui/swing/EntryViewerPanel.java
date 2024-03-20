package ui.swing;

import model.Entry;
import ui.util.Viewer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Class for the view panel containing observable catalogue
 */
public class EntryViewerPanel extends JPanel implements Viewer {
    private JPanel dropdownPanel = new JPanel();
    private JPanel infoRenderPanel = new JPanel();

    /**
     * EFFECTS: Creates new dual viewing panel for the viewing window
     */
    public EntryViewerPanel() {
        String[] fruits = new String[8];
        fruits[0] = "Apple";
        fruits[1] = "Mango";
        fruits[2] = "Banana";
        fruits[3] = "Grapes";
        fruits[4] = "Cherry";
        fruits[5] = "Lemon";
        fruits[6] = "Orange";
        fruits[7] = "Strawberry";

        JList listFruits = new JList(fruits);
        listFruits.setVisibleRowCount(4);

        JLabel label = new JLabel();

        JScrollPane jcp = new JScrollPane(listFruits);
        dropdownPanel.add(jcp);
        dropdownPanel.add(label);
        listFruits.addListSelectionListener(e -> {
            String selectedFruit = (String) listFruits.getSelectedValue();
            label.setText(selectedFruit);
        });

        this.add(dropdownPanel);
    }

    @Override
    public void displayAllEntries() {
        //TODO
    }

    @Override
    public void displayEntry(Entry entry) {
        //TODO
    }
}
