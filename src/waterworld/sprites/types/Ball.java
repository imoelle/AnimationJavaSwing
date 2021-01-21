package waterworld.sprites.types;

import waterworld.sprites.Sprite;
import waterworld.utilities.ImageLoader;
import waterworld.utilities.PVector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ball extends Sprite {

    private PVector2D acceleration;

    public Ball(PVector2D location, PVector2D velocity, String fileAndFIleLocation) {
        super(location, velocity, fileAndFIleLocation);
    }

    public Ball(PVector2D location, String fileAndFileLocation) {
        super(location, new PVector2D(), fileAndFileLocation);
    }

    public Ball(String fileAndFielLocation) {
        super(new PVector2D(), new PVector2D(), fileAndFielLocation);
    }
}
