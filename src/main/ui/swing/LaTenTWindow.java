package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Instance represents the main LaTenT App GUI instance using java swing.
 */
public class LaTenTWindow {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;

    /**
     * EFFECTS: Creates new skeleton instance of the LaTenT app GUI instance without loading data
     */
    public LaTenTWindow() {
        frame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        this.initAppWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: Starts new LaTenT window on the start screen
     */
    private void initAppWindow() {
        frame.setLayout(cardLayout);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setMaximumSize(new Dimension(981, 981));
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.initHomeScreen();
        this.initViewScreen();
        this.initEditorScreen();
        frame.pack();
        frame.add(mainPanel);
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the menu/home screen and adds it to the window
     */
    private void initHomeScreen() {
        HomeWindow homeWindow = new HomeWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the viewing screen and adds it to the window
     */
    private void initViewScreen() {
        EntryViewerWindow entryViewerWindow = new EntryViewerWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the editing screen and adds it to the window
     */
    private void initEditorScreen() {
        EntryEditorWindow entryEditorWindow = new EntryEditorWindow();
    }

    /**
     * EFFECTS: getter for main panel
     */
    public static JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * EFFECTS: getter for main card layouts
     */
    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * EFFECTS: getter for frame
     */
    public static JFrame getFrame() {
        return frame;
    }
}
