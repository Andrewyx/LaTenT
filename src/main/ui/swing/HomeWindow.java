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
        JButton startButton = new JButton("VIEW");
        this.setBackground(Color.gray);
        this.setSize(new Dimension(500, 500));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainLayout.show(mainPanel, "VIEW");
            }
        });
        startButton.setBounds(0, 0, 40, 20);
        JLabel title = new JLabel();
        title.setText("<html><h1>header1 text</h1></html>");
        title.setBounds(50, 50, 50, 50);
        this.add(startButton);
        this.add(title);

        this.addPanelToMain(this, "HOME");
    }
}
