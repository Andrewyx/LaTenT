package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main startup home window greeting the user
 */
public class HomeWindow extends Window {

    /**
     * EFFECTS: creates new home window and initializes it
     */
    public HomeWindow() {
        super();
    }

    /**
     * MODIFIES: LaTenTWindow
     * EFFECTS: creates window with content
     */
    @Override
    protected void initWindow() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        JButton startButton = new JButton("START");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setBackground(Color.ORANGE);

        addWindowSwitchAction(startButton, "VIEW");

        JLabel title = new JLabel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setText("LaTenT");
        title.setBackground(Color.black);
        title.setFont(new Font("Arial", Font.BOLD, 60));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(startButton);
        this.add(Box.createVerticalGlue());

        this.addPanelToMain(this, "HOME");
    }
}
