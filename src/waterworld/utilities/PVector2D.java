package waterworld.utilities;


import java.awt.*;

/**
 * todo:    method checkForNotEqualZero has to be refactored. Unsightly solution has to be changed, but run first.
 */
public class PVector2D {
    private double x;
    private double y;

    //=========================================================================
    // Constructors
    //=========================================================================

    public PVector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public PVector2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    //=========================================================================
    // Basic arithmetic operations
    //=========================================================================

    public void add(PVector2D addend) {
        this.x += addend.x;
        this.y += addend.y;
    }

    public final PVector2D addAndCreate(PVector2D addend) {
        return new PVector2D(this.x + addend.x,
                this.y + addend.y);
    }

    public void subtractBy(PVector2D subtrahend) {
        this.x -= subtrahend.x;
        this.y -= subtrahend.y;
    }

    public final PVector2D subtractAndCreate(PVector2D subtrahend) {
        return new PVector2D(this.x - subtrahend.x,
                this.y - subtrahend.y);
    }

    public void multipliedWith(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public final PVector2D multiplyAndCreate(double scalar) {
        return new PVector2D(this.x * scalar,
                this.y * scalar);
    }

    public void dividedBy(double scalar) {
        checkForNotEqualZero(scalar);
        this.x /= scalar;
        this.y /= scalar;
    }

    public final PVector2D divideAndCreate(double scalar) {
        checkForNotEqualZero(scalar);
        return new PVector2D(this.x / scalar,
                this.y / scalar);
    }

    //=========================================================================
    // public PVector2D specific operations
    //=========================================================================

    public final double dotProduct(PVector2D theOther) {
        return this.x * theOther.x +
                this.y * theOther.y;
    }

    public final double hasMagnitude() {
        return Math.sqrt(vectorSquareFrom(this));
    }

    public final double angleInDegreesTo(PVector2D theOther) {
        return Math.toDegrees(this.angleInRadiansTo(theOther));
    }

    public final PVector2D normalize() {
        double magnitude = this.hasMagnitude();
        return new PVector2D(this.x * (1 / magnitude),
                this.y * (1 / magnitude));
    }

    public final double angleInRadiansTo(PVector2D theOther) {
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

    public PVector2D linearInterpolateTo(PVector2D target, double byFactor) {
        return getNewVectorBy(this, 1 - byFactor).
                addAndCreate(getNewVectorBy(target, byFactor));
    }

    public double euclideanDistanceTo(PVector2D theOther) {
        return Math.sqrt(squareOf(theOther.x - this.x) +
                squareOf(theOther.y - this.y));
    }

    //=========================================================================
    // private PVector2D specific operations
    //=========================================================================

    private PVector2D getNewVectorBy(PVector2D source, double andFactor) {
        return new PVector2D(source.x * andFactor,
                source.y * andFactor);
    }

    private double xTurnedBy(double angleInRadians) {
        return this.x * Math.cos(angleInRadians) -
                this.y * Math.sin(angleInRadians);
    }

    private double yTurnedBy(double angleInRadians) {
        return this.x * Math.sin(angleInRadians) +
                this.y * Math.cos(angleInRadians);
    }

    private double vectorSquareFrom(PVector2D vector) {
        return vector.x * vector.x +
                vector.y * vector.y;
    }

    private double dotProductSquareFrom(PVector2D theOther) {
        return this.hasMagnitude() * theOther.hasMagnitude();
    }

    private double squareOf(double value) {
        return value * value;
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
        return this.x;
    }

    public void setPositionX(double xPosition) {
        this.x = xPosition;
    }

    public final double getPositionY() {
        return this.y;
    }

    public void setPositionY(double yPosition) {
        this.y = yPosition;
    }

    //=========================================================================
    // Overwritten methods
    //=========================================================================

    @Override
    public boolean equals(Object thatObject) {
        if (thatObject instanceof PVector2D) {
            PVector2D that = (PVector2D) thatObject;
            return (this.x == that.x) &&
                    (this.y == that.y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " +
                this.y + ")";
    }
}
