package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class containing the general details of an abstract GUI window
 */
public abstract class Window extends JPanel {

    protected JPanel mainPanel;
    protected CardLayout mainLayout;

    /**
     * EFFECTS: initializes new window panel
     */
    public Window() {
        super();
        this.mainLayout = LaTenTWindow.getCardLayout();
        this.mainPanel = LaTenTWindow.getMainPanel();
        this.initWindow();
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
}
