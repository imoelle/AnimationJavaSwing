package waterworld.sprites.types;

import waterworld.sprites.Sprite;
import waterworld.utilities.ImageLoader;
import waterworld.utilities.PVector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ball extends Sprite {

    private BufferedImage texture;
    private PVector2D acceleration;
    private PVector2D velocity;
    private int radius;

    public Ball() {
        super(new PVector2D());
        this.velocity = new PVector2D(2.5, 2.5);
        this.acceleration = new PVector2D();
        texture = new ImageLoader("../sprites/assets/blueball.gif").getImage();
    }

    public BufferedImage getTexture() {
        return texture;
    }


}
