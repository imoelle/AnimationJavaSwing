package waterworld.sprites.types;

import waterworld.sprites.Sprite;
import waterworld.utilities.PVector2D;

public class Ball extends Sprite {

    private int radius;
    private int texture;

    public Ball(PVector2D location, PVector2D velocity, PVector2D acceleration) {
        super(location, velocity, acceleration);
    }
}
