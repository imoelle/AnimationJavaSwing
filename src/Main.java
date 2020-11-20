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

        PVector2D lerpA = new PVector2D(4, 2);
        PVector2D lerpB = new PVector2D(5, 3);

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

        double d1 = 2.3457345323013;
        double d2 = 2.3457345323016;
        System.out.println("Value after compare: " + Double.compare(d1, d2));

//        if(retval > 0) {
//            System.out.println("d1 is greater than d2: " + retval);
//        } else if(retval < 0) {
//            System.out.println("d1 is less than d2: " + retval);
//        } else {
//            System.out.println("d1 is equal to d2: " + retval);
//        }

//        System.out.println("gerundeter double wert (2.345345634434): " + Math.rint(d1*1000)/1000);

        int i = 1;
        double obereGrenzeX = lerpB.getPositionX();
        double untereGrenzeX = lerpB.getPositionX()-0.002;
        double epsilonX = (obereGrenzeX+untereGrenzeX)/2;
        double obereGrenzeY = lerpB.getPositionY();
        double untereGranzeY = lerpB.getPositionY()-0.002;
        double epsilonY = (obereGrenzeY+untereGranzeY)/2;


        while(lerpA.getPositionX() < epsilonX || lerpA.getPositionY() < epsilonY) {
            lerpA = lerpA.linearInterpolateTo(lerpB, 0.50);

            System.out.println(i + " LerpA-Vector: " + lerpA.toString());


            i++;
            //if(i > 20) break;

        }
    }
}
