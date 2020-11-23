package waterworld.utilities;


/**
 * todo:    method checkForNotEqualZero has to be refactored. Unsightly solution has to be changed, but run first.
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
        return Math.toDegrees(this.angleInRadiansTo(theOther));
    }

    public final PVector2D normalize() {
        double magnitude = this.hasMagnitude();
        return new PVector2D(this.xPosition * (1 / magnitude),
                this.yPosition * (1 / magnitude));
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
        return Math.sqrt(squareOf(theOther.xPosition - this.xPosition) +
                squareOf(theOther.yPosition - this.yPosition));
    }

    //=========================================================================
    // private PVector2D specific operations
    //=========================================================================

    private PVector2D getNewVectorBy(PVector2D source, double andFactor) {
        return new PVector2D(source.xPosition * andFactor,
                source.yPosition * andFactor);
    }

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
