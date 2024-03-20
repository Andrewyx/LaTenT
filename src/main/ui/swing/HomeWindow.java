package ui.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Main startup home window greeting the user
 */
public class HomeWindow extends Window {
    private BufferedImage image;

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
        addBackgroundImage();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        JButton startButton = new JButton("START");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (981 - mainPanel.getWidth()) / -2, (981 - mainPanel.getHeight()) / -2, this);
    }

    /**
     * MODIFIES: this
     * EFFECTS: adds background image to the home screen
     */
    private void addBackgroundImage() {
        try {
            image = ImageIO.read(new File("data/home.jpg"));
        } catch (IOException e) {
            System.out.println("ERROR: Background image not found");
        }

    }
}
