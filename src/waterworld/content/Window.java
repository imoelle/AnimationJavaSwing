package waterworld.content;

import waterworld.utilities.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Window.java <br><br>
 *
 * @author Ingo Moeller
 * @version 01.00 - 2001004
 */
public class Window extends JFrame {

    private BufferedImage icon = new ImageLoader("../content/assets/starfishIcon.png").getImage();

    public Window(JPanel content, Dimension size) {

        setTitle("Java Swing Water World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(icon);
//        setJMenuBar(jb);
        getContentPane().add(content);
        getContentPane().setPreferredSize(size);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
