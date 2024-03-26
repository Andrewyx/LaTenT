package ui.swing;

import ui.LaTeXRenderer;
import ui.util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Instance represents the main LaTenT App GUI instance using java swing.
 */
public class LaTenTWindow {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;
    private static EntryEditorWindow entryEditorWindow;
    private static HomeWindow homeWindow;
    private static EntryViewerWindow entryViewerWindow;

    /**
     * EFFECTS: Creates new skeleton instance of the LaTenT app GUI instance without loading data
     */
    public LaTenTWindow() {
        try {
            new SplashScreenOnBoot();
            Thread.sleep(2000);
        } catch (Exception e) {
            //pass
        }
        frame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        new LaTeXRenderer("null");
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        try {
            BufferedImage img = ImageIO.read(new File("data/home.jpg"));
            frame.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.initHomeScreen();
        this.initViewScreen();
        this.initEditorScreen();

        frame.add(mainPanel);

    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the menu/home screen and adds it to the window
     */
    private void initHomeScreen() {
        homeWindow = new HomeWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the viewing screen and adds it to the window
     */
    private void initViewScreen() {
        entryViewerWindow = new EntryViewerWindow();
    }

    /**
     * MODIFIES: this
     * EFFECTS: initializes the editing screen and adds it to the window
     */
    private void initEditorScreen() {
        entryEditorWindow = new EntryEditorWindow();
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
     * EFFECTS: getter for main frame
     */
    public static JFrame getFrame() {
        return frame;
    }

    /**
     * EFFECTS: getter for static editor window
     */
    public static EntryEditorWindow getEntryEditorWindow() {
        return entryEditorWindow;
    }

    /**
     * EFFECTS: getter for static viewer window
     */
    public static EntryViewerWindow getEntryViewerWindow() {
        return entryViewerWindow;
    }
}
