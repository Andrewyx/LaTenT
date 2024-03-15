package ui.swing;

import javax.swing.*;

/**
 * Abstract class containing the general details of an abstract GUI window
 */
public abstract class Window {
    protected JPanel panel;

    /**
     * EFFECTS: initializes new window panel
     */
    public Window() {
        this.panel = new JPanel();
    }

}
