package ui.swing;

import ui.util.LaTeXImageLabel;

import javax.swing.*;
import java.awt.*;

public class SplashScreenOnBoot extends JWindow {
    public SplashScreenOnBoot() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                     | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
            showSplash();
        });
    }

    private void showSplash() {
        JPanel content = (JPanel) getContentPane();
        LaTeXImageLabel imageLabel = new LaTeXImageLabel();
        int width = 300;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        this.setPreferredSize(new Dimension(width, height));
        this.setBounds(x, y, width, height);

        imageLabel.setSize(new Dimension(width, height));
        imageLabel.refreshLabelLatexIcon("data/home.jpg");
        content.add(imageLabel);

        this.pack();
        this.setVisible(true);
        this.toFront();
        new ResourceLoader().execute();
    }

    public class ResourceLoader extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                //pass
            }
            return null;

        }

        @Override
        protected void done() {
            setVisible(false);
        }
    }
}
