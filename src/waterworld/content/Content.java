package waterworld.content;

import waterworld.sprites.types.Ball;
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

    // Declaration for tests
    private Ball testBall = new Ball(new PVector2D(50, 50), new PVector2D(.8, .8), "../sprites/assets/orangeball.gif");


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
        g.drawImage(testBall.getImage(), (int)testBall.getLocation().getPositionX(), (int)testBall.getLocation().getPositionY(), this);
        testBall.getLocation().add(testBall.getVelocity());
//        g.drawImage(testBall.getTexture(), (int)testBall.getLocation().getPositionX(), (int)testBall.getLocation().getPositionY(), this);
        // create a ball set to location(0, 0)
//        new TexturePaint(new ImageLoader("../sprites/assets/orangeball.gif").getImage(),
//        g.fillOval((int)location.getPositionX(), (int)location.getPositionY(), 10, 10););

        // add a velocity to ball, so a bouncing ball is created
//        location.add(velocity);
//        testBall.getLocation().add(testBall.getVelocity());

        // check if the ball touched the global bounds (width, height)
//        if((testBall.getLocation().getPositionX() > (backGroundSize.getWidth()-10)) || (testBall.getLocation().getPositionX() < 0))
//            testBall.getVelocity().setPositionX(testBall.getVelocity().getPositionX()*(-1));

//        if((testBall.getLocation().getPositionY() > (backGroundSize.getHeight()-10)) || (testBall.getLocation().getPositionY() < 0))
//            testBall.getVelocity().setPositionY(testBall.getVelocity().getPositionY()*(-1));
    }
}
