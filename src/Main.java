import waterworld.WaterWorld;
import waterworld.utilities.PVector2D;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Main.java <br><br>
 *
 * @author Ingo Moeller
 * @version 01.00 - 2001004
 */
public class Main {
    public static void main(String[] args) {
        new WaterWorld();

        for (int i = 0; i < 50; i++) {
            double test = ThreadLocalRandom.current().nextDouble();
            double test2 = ThreadLocalRandom.current().nextDouble(0, 3);
            System.out.println(i + 1 + ". (" + (test*100 % 3) + ", " + test2 + ")");
        }

    }




}
