package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        //stub
        JButton startButton = new JButton("HOME");
        this.setBackground(Color.blue);
        this.setSize(new Dimension(500, 500));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainLayout.show(mainPanel, "HOME");
            }
        });
        startButton.setBounds(0, 0, 40, 20);
        JLabel title = new JLabel();
        title.setText("<html><h1>Other text</h1></html>");
        title.setBounds(50, 50, 50, 50);
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
