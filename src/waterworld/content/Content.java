package waterworld.content;

import waterworld.utilities.ImageLoader;
import waterworld.utilities.PVector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Content.java <br><br>
 *
 * @author Ingo Moeller
 * @version 01.00 - 2001004
 */
public class Content extends JPanel {

    private final BufferedImage backGround;
    private Dimension backGroundSize;
    private PVector2D location = new PVector2D(0,0);
    private PVector2D velocity = new PVector2D(1,1);
    private PVector2D acceleration = new PVector2D(0.001, 0.001);


    public Content() {
        backGround = new ImageLoader("../content/assets/background02.gif").getImage();
        backGroundSize = new Dimension(backGround.getWidth(), backGround.getHeight());

    }

    public Dimension getBgImageSize() {
        return backGroundSize;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGround, 0, 0, this);
        g.fillOval((int)location.getPositionX(), (int)location.getPositionY(), 10, 10);

        location.add(velocity);
        if((location.getPositionX() > (backGroundSize.getWidth()-10)) || (location.getPositionX() < 0))
            velocity.setPositionX(velocity.getPositionX()*-1);

        if((location.getPositionY() > (backGroundSize.getHeight()-10)) || (location.getPositionY() < 0))
            velocity.setPositionY(velocity.getPositionY()*-1);
    }
}
