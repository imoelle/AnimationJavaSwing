package waterworld.utilities;


/**
 * Operations to be implemented:
 * erledigt: add() — add vectors
 * erledigt: add() - Vector als Rückgabe
 * erledigt: sub() — subtract vectors
 * erledigt: sub() - Vector als rückgabe
 * erledigt: mult() — scale the vector with multiplication
 * erledigt: mult() - rückgabe scaled vector
 * erledigt: div() — scale the vector with division
 * erledigt: mag() — calculate the magnitude of a vector
 * erledigt: normalize() — normalize the vector to a unit length of 1
 * erledigt: heading() — the 2D heading of a vector expressed as an angle (PVector.X = cos(phi), PVector.y = sin(phi))
 * Heading (Peilung) is the angle in degree (clockwise) and the destination
 * relative Bearing (relative Peilung) is the angle in degree between the heading and the destination
 * bearing is the angle between north (orientation) to destination.
 * rotate() — rotate a 2D vector by an angle (x' = x*cos(phi) - y*sin(phi), y' = y*sin(phi) +  y*cos(phi))
 * lerp() — linear interpolate to another vector (1-% -> x*(1-%) & y*(1-%))
 * dist() — the Euclidean distance between two vectors (considered as points) d(p,q) = sqrt((q1-p1)²+(q2-p2)²)
 */
public class PVector2D {
    private double xPosition;
    private double yPosition;

    //=========================================================================
    // Constructors
    //=========================================================================

    public PVector2D(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public PVector2D() {
        this.xPosition = 0.0;
        this.yPosition = 0.0;
    }

    //=========================================================================
    // Basic arithmetic operations
    //=========================================================================

    public void add(PVector2D addend) {
        this.xPosition += addend.xPosition;
        this.yPosition += addend.yPosition;
    }

    public final PVector2D addAndCreate(PVector2D addend) {
        return new PVector2D(this.xPosition + addend.xPosition,
                this.yPosition + addend.yPosition);
    }

    public void subtractBy(PVector2D subtrahend) {
        this.xPosition -= subtrahend.xPosition;
        this.yPosition -= subtrahend.yPosition;
    }

    public final PVector2D subtractAndCreate(PVector2D subtrahend) {
        return new PVector2D(this.xPosition - subtrahend.xPosition,
                this.yPosition - subtrahend.yPosition);
    }

    public void multipliedWith(double scalar) {
        this.xPosition *= scalar;
        this.yPosition *= scalar;
    }

    public final PVector2D multiplyAndCreate(double scalar) {
        return new PVector2D(this.xPosition * scalar,
                this.yPosition * scalar);
    }

    public void dividedBy(double scalar) {
        checkForNotEqualZero(scalar);
        this.xPosition /= scalar;
        this.yPosition /= scalar;
    }

    public final PVector2D divideAndCreate(double scalar) {
        checkForNotEqualZero(scalar);
        return new PVector2D(this.xPosition / scalar,
                this.yPosition / scalar);
    }

    //=========================================================================
    // public PVector2D specific operations
    //=========================================================================

    public final double dotProduct(PVector2D theOther) {
        return this.xPosition * theOther.xPosition +
                this.yPosition * theOther.yPosition;
    }

    public final double hasMagnitude() {
        return Math.sqrt(vectorSquareFrom(this));
    }

    public final double hasAngleToInDegrees(PVector2D theOther) {
        return Math.toDegrees(this.angleInRadianTo(theOther));
    }

    public final PVector2D normalize() {
        double magnitude = this.hasMagnitude();
        return new PVector2D(this.xPosition * (1 / magnitude),
                this.yPosition * (1 / magnitude));
    }

    public final double angleInRadianTo(PVector2D theOther) {
        checkForNotEqualZero(this.dotProductMagnitude(theOther));
        return Math.acos(this.dotProduct(theOther) /
                this.dotProductMagnitude(theOther));
    }

    public PVector2D headingVector(PVector2D influence) {
        return this.addAndCreate(influence);
    }

    public double headingAngel(PVector2D influence) {

        double angleAsValue = 0.0;
        angleAsValue = influence.hasMagnitude() / this.hasMagnitude();


        return Math.toDegrees(angleAsValue);
    }

    //=========================================================================
    // private PVector2D specific operations
    //=========================================================================

    private double vectorSquareFrom(PVector2D vector) {
        return vector.xPosition * vector.xPosition +
                vector.yPosition * vector.yPosition;
    }

    private double dotProductSquareFrom(PVector2D theOther) {
        return this.hasMagnitude() * theOther.hasMagnitude();
    }

    private double dotProductMagnitude(PVector2D vector) {
        return this.hasMagnitude() * vector.hasMagnitude();
    }

    private void checkForNotEqualZero(double value) {
        if (value != 0) return;
        else throw new IllegalArgumentException("PVector2D: Division by zero");
    }

    //=========================================================================
    // getter and setter
    //=========================================================================

    public final double getPositionX() {
        return this.xPosition;
    }

    public void setPositionX(double xPosition) {
        this.xPosition = xPosition;
    }

    public final double getPositionY() {
        return this.yPosition;
    }

    public void setPositionY(double yPosition) {
        this.yPosition = yPosition;
    }

    //=========================================================================
    // Overwritten methods
    //=========================================================================

    @Override
    public boolean equals(Object thatObject) {
        if (thatObject instanceof PVector2D) {
            PVector2D that = (PVector2D) thatObject;
            return (this.xPosition == that.xPosition) &&
                    (this.yPosition == that.yPosition);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.xPosition + ", " +
                this.yPosition + ")";
    }
}
