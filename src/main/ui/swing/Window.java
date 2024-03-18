package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class containing the general details of an abstract GUI window
 */
public abstract class Window {
    protected JPanel panel;
    protected JPanel mainPanel;
    protected CardLayout mainLayout;

    /**
     * EFFECTS: initializes new window panel
     */
    public Window() {
        this.mainLayout = LaTenTWindow.getCardLayout();
        this.mainPanel = LaTenTWindow.getMainPanel();
        this.panel = new JPanel();
    }

    protected abstract void initWindow();

}
