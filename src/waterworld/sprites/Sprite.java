package waterworld.sprites;


import waterworld.utilities.ImageLoader;
import waterworld.utilities.PVector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.PublicKey;

/*
 * Was ist ein Sprite in diesem Project:
 *
 * Das Sprite bewegt sich frei innerhalb vorgegebener Grenzen (Größe des Hintergrundbildes)
 * Kollidieren zwei Sprites miteinander, stoßen sich diese ab (Aufprallwinkel = -Aufprallwinkel)
 * Kollidieren zwei Sprites mit unterschiedlicher Geschwindigkeit, ändert sich die Geschwindigkeit beider Sprites.
 * Kollidiert ein Sprite mit den Grenzen (Hintergrundbild) wird es Abgestoßen (Einfallswinkel = Ausfallswinkel)
 *
 * Ein Sprite wird Beschrieben durch:
 *
 * Ein Sprite ist ein Kreis mit einem Radius bzw. Durchmesser - benötigt double oder int
 * Ein Sprite hat eine Textur, definiert durch ein Bild (GIF-Bild) - benötigt ImageLoader
 * Das Sprite hat eine Position (x, y) - benötigt Vector (PVector2D) eigene Vector klasse
 * Das Sprite hat eine Geschwindigkeit (x, y) - benötigt Vector (PVector2D) eigene Vector klasse
 * Das Sprite hat eine Beschleunigung (x, y) - benötigt Vector (PVector2D) eigene Vector klasse
 * Das Sprite bewegt sich nur im vorgegebenen Raum (Rechteck) bestimmt durch
 * die Größe des Hintergrundbildes - Global Bounds
 *
 * Methode Klasse:
 *
 * Konstruktor: initialisiert Array List mit variabler Anzahl Sprites
 *
 * Positionierung: Den ELementen der Arraylist wird eine Zufallsposition zugewiesen, wobei keine Objekte auf der
 * gleichen Position platziert werden dürfen (mehrere Positionierungsversuche).
 *
 * Kollisionserkennung: Die Kollisionserkennung erfolgt in zwei Varianten. Bei der Initialisierung, dem Verteilen der
 * Sprites auf dem Bildschirm wird geprüft, ob kein Sprite ein anderes verdeckt. Während des Ablaufs der Animation
 * Wird dasPrellverhalten unterschieden:
 * 1.) Sprite -> Global Bounds: Eintrittswinkel = Austrittswinkel - kein Einfluss auf die Geschwindigkeit
 * 2.) Sprite -> Spreit: Aufprallwinkel = -Aufprallwinkel - (Impulsverhalten zweier Kugel (e))
 *      Impuls: p = m*v (m = masse, v = geschwindigkeit (m/s))
 * Für das Prallverhalten der Kugeln, wird ein elastischer Stoß zu grunde gelegt.
 * a) Das Verhältnis: m1*v1 + m2*v2 = m1*v3 + m2*v4
 * b) m1 = masse Körper1, m2 = masse Körper2
 * c) v1 = Geschwindogkeit vor Stoß Kugel1, v2 = Geschwindogkeit vor Stoß Kugel2
 *    v3 = Geschwindogkeit nach Stoß Kugel1, 42 = Geschwindogkeit nach Stoß Kugel2
 * d) Geschwindigkeiten nach recht (+) geschwindigkeiten nach links (-)
 * Relevant ist das ermitteln von v1, v2, v3, v4, denn die Sprites kolidieren mit sich selbst oder der
 * Wand.
 *
 * Abstraktion:
 *
 * Ein Sprite mus nicht zwangsläufig rund sein, daher muss weiter abstrahiert werden.
 *
 * 1.) Sprite hat Koordinaten
 * 2.) Sprite kann kollidieren
 * 3.) Sprite kann sich bewegen
 * 4.) sprite kann farbe haben
 * 5.) sprite kann textur haben
 *
 * Spezialsierung:
 *
 * 1.) hat eine geometrie (beispiel kreis)
 * 2.) hat einen durchmesser
 * 3.) hat eine Textur
 * 4.) hat eigenes bewegungsprofil (physikalisch)
 */
public abstract class Sprite {
    private PVector2D location;
    private PVector2D velocity;
    private BufferedImage image;

    public Sprite(PVector2D location, PVector2D velocity, String fileAndFileLocation) {
        this.location = location;
        this.velocity = velocity;
        this.image = new ImageLoader(fileAndFileLocation).getImage();
    }

    public Sprite(PVector2D location, String fileAndFileLocation) {
        this(location, new PVector2D(), fileAndFileLocation);
    }

    public Sprite(String fileAndFIleLocation) {
        this(new PVector2D(), new PVector2D(), fileAndFIleLocation);
    }

    public PVector2D getLocation() {
        return location;
    }

    public PVector2D getVelocity() {
        return velocity;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setLocation(PVector2D location) {
        this.location = location;
    }

    public void setVelocity(PVector2D velocity) {
        this.velocity = velocity;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
