import waterworld.WaterWorld;
import waterworld.utilities.PVector2D;

/**
 * Main.java <br><br>
 *
 * @author Ingo Moeller
 * @version 01.00 - 2001004
 */
public class Main {
    public static void main(String[] args) {
        new WaterWorld();

        PVector2D a = new PVector2D(1, 1);
        PVector2D b = new PVector2D(3, 4);
        PVector2D c = new PVector2D(0, 0);

        System.out.println("Scalarprodukt (a, b): " + a.dotProduct(b));
        System.out.println("Winkel (a, c): " + a.hasAngleToInDegrees(c)); // throws aritmetic exception
        System.out.println("a length: " + a.hasMagnitude());
        System.out.println("b length: " + b.hasMagnitude());
        System.out.println("Winkel (a, b): " + a.hasAngleToInDegrees(b));
        System.out.println("normieren von b: " + b.normalize().toString());
    }
}
