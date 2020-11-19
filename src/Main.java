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
        PVector2D c = new PVector2D(4.5, 2);

        PVector2D lerpA = new PVector2D(-2, 2);
        PVector2D lerpB = new PVector2D(5.5, 4);

        PVector2D richtung = new PVector2D(-3, 5);
        PVector2D wind = new PVector2D(-2, -1);
        System.out.println("HeadingAngle: " + richtung.hasHeadingAngle(wind));
        System.out.println("HeadingVector: " + richtung.headingVector(wind));

        System.out.println("Scalarprodukt (a, b): " + a.dotProduct(b));
        System.out.println("a length: " + a.hasMagnitude());
        System.out.println("b length: " + b.hasMagnitude());
        System.out.println("Winkel (a, b): " + a.angleInDegreesTo(b));
        System.out.println("Division by Scalar(2): " + b.divideAndCreate(2).toString());

        System.out.println("Hier wird die rotation berechnet (90°): " + a.rotateByAngle(90).toString());
        System.out.println("Hier wird die rotation berechnet (270°): " + a.rotateByAngle(270).toString());


    }
}
