package waterworld.sprites.types;

import waterworld.sprites.Sprite;
import waterworld.utilities.ImageLoader;
import waterworld.utilities.PVector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends Sprite {

    private BufferedImage texture;
    private PVector2D acceleration;
    private int radius;

    private Graphics test;

    public Ball() {
        super(new PVector2D(20, 20), new PVector2D(2.5, 2.5));
        texture = new ImageLoader("../sprites/assets/blueball.gif").getImage();
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
