package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class containing the general details of an abstract GUI window
 */
public abstract class Window extends JPanel {
    public static final Dimension screenSize = LaTenTWindow.getFrame().getSize();
    protected JPanel mainPanel;
    protected CardLayout mainLayout;

    /**
     * EFFECTS: initializes new window panel with default settings
     */
    public Window() {
        super();
        this.setupSettings();
        this.initWindow();
    }

    /**
     * EFFECTS: initializes new window panel with provided layout settings
     */
    public Window(LayoutManager layoutManager) {
        super(layoutManager);
        this.setupSettings();
        this.initWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: Sets defaults for the class
     */
    private void setupSettings() {
        this.mainLayout = LaTenTWindow.getCardLayout();
        this.mainPanel = LaTenTWindow.getMainPanel();
        this.setPreferredSize(screenSize);
        LaTenTWindow.getFrame().pack();
    }

    /**
     * MODIFIES: LaTenTWindow
     * EFFECTS: creates window with content
     */
    abstract void initWindow();

    /**
     * MODIFIES: this, LaTenTWindow
     * EFFECTS: adds the given panel to the main window a label
     */
    protected void addPanelToMain(JPanel panel, String label) {
        mainPanel.add(panel, label);
    }

    /**
     * MODIFIES: this
     * EFFECTS: Adds switch menu action listener to the given button to the given destination
     */
    protected void addWindowSwitchAction(JButton button, String destination) {
        button.addActionListener(e -> mainLayout.show(mainPanel, destination));
    }
}
