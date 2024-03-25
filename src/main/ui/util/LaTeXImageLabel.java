package ui.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * LaTeX image class for Java swing. Meant for rendering images via JLabels.
 */
public class LaTeXImageLabel extends JLabel {

    /**
     * EFFECTS: constructs generic JLabel with no images rendered
     */
    public LaTeXImageLabel() {
        super();
    }

    /**
     * MODIFIES: this
     * EFFECTS: refreshes the image icon on the current label
     */
    public void refreshLabelLatexIcon() {
        try {
            BufferedImage img = ImageIO.read(new File("data/latex.png"));
            double scaleFactor = (double) this.getWidth() / img.getWidth();
            Image scaledImg = img.getScaledInstance(
                    this.getWidth(),
                    (int) Math.round(img.getHeight() * scaleFactor),
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImg);
            this.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
