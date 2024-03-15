package ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Main startup home window greeting the user
 */
public class HomeWindow extends Window {
    private JPanel mainPanel;
    private CardLayout mainLayout;

    /**
     * EFFECTS: creates new home window
     */
    public HomeWindow() {
        super();
        this.mainLayout = LaTenTWindow.getCardLayout();
        this.mainPanel = LaTenTWindow.getMainPanel();
        this.initWindow();

    }

    /**
     * MODIFIES: LaTenTWindow
     * EFFECTS: populates main window
     */
    private void initWindow() {
        JButton startButton = new JButton("Start");
        panel.setBackground(Color.gray);
        panel.setBounds(0, 250, 400, 200);
        startButton.addActionListener(e -> mainLayout.next(mainPanel));
        startButton.setBounds(0, 0, 40, 20);
        JLabel title = new JLabel();
        title.setText("<html><h1>header1 text</h1></html>");
        title.setBounds(50, 50, 50, 50);
        panel.add(startButton);
        panel.add(title);
        System.out.println("success");
        mainPanel.add(panel);
    }
}
