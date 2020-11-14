package waterworld;

import waterworld.actions.Update;
import waterworld.content.Content;
import waterworld.content.Window;

import javax.swing.*;


/**
 * WaterWorld.java <br><br>
 * <p>
 * This animation was refactored as Java Swing Application. The original version was written
 * in Java AWT by Prof. Dr. rer. nat. Rheinald Schoeneberg.<br>
 * This program shows some animated spheres in a fish tank. The spheres generally move
 * the same way until it collides with another sphere or the screen limit.<br>
 *
 * @author Ingo Moeller
 * @version 01.00 - 2001004
 */
public class WaterWorld {

    private final Content content = new Content();
    private final Window window = new Window(content, content.getBgImageSize());
    private final Update gameUpdate = new Update(content);

    public WaterWorld() {
        new Timer(25, gameUpdate).start();
    }
}
