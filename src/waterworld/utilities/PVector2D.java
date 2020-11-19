package waterworld.utilities;


/**
 * Operations to be implemented:
 * lerp() — linear interpolate to another vector (1-% -> x*(1-%) & y*(1-%))
 *
 * // Präzise Methode, die v = v1 garantiert, wenn t = 1. Diese Methode ist nur dann monoton, wenn v0 * v1 <0. Das Lerping zwischen denselben Werten führt möglicherweise nicht zu demselben Wert
 * float  lerp ( float  vectorStart ,  float  vectorTarget ,  float  alpha in % )  {
 *   return  ( 1  -  alpha )  *  vectorStart  +  alpha  *  vectorTarget ;
 * }}
 *
 * dist() — the Euclidean distance between two vectors (considered as points) d(p,q) = sqrt((q1-p1)²+(q2-p2)²)
 * <p>
 * todo:    method checkForNotEqualZero has to be refactored. Unsightly solution has to be changed.
 * runs first...
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

    public final double angleInDegreesTo(PVector2D theOther) {
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

    public double hasHeadingAngle(PVector2D influence) {
        return Math.toDegrees(influence.hasMagnitude() /
                this.hasMagnitude());
    }

    public PVector2D rotateByAngle(double angleInDegrees) {
        double angle = Math.toRadians(angleInDegrees);
        return new PVector2D(this.xTurnedBy(angle),
                this.yTurnedBy(angle));
    }

    public PVector2D lerp(PVector2D origin, PVector2D target, double alpha) {
        // (1-alpha)*origin + alpha* target
        // PVector hat x und y
        PVector2D a = new PVector2D(origin.xPosition * (1-alpha), origin.yPosition*(1-alpha));
        PVector2D b = new PVector2D(target.xPosition*alpha, target.yPosition*alpha);
        return a.addAndCreate(b);
    }
    //=========================================================================
    // private PVector2D specific operations
    //=========================================================================

    private double xTurnedBy(double angleInRadians) {
        return this.xPosition * Math.cos(angleInRadians) -
                this.yPosition * Math.sin(angleInRadians);
    }

    private double yTurnedBy(double angleInRadians) {
        return this.xPosition * Math.sin(angleInRadians) +
                this.yPosition * Math.cos(angleInRadians);
    }

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

    // unsightly solution, has to be changed!
    // runs first
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
