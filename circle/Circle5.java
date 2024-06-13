/**
 * @author Moaz Aamir
 * @date 03/20/2024
 * Final version of the circle program, allowing for full manipulation of coordinates, methods to calculate area and perimeter, and more.
 */

package circle;

/**
 * The Circle5 class represents a circle with a specific origin (x, y) and radius.
 * It provides methods to perform operations such as calculating area and perimeter,
 * moving the circle, resizing it, and combining it with another circle.
 */
public class Circle5 {
    private int x, y, radius;

    /**
     * Default constructor. Initializes the circle with the origin at (0, 0) and a radius of 1.
     */
    public Circle5() {
        this(0, 0, 1); // using another constructor to avoid redundant code
    }

    /**
     * Overloaded constructor. Initializes the circle with the origin at (0, 0) and the specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle5(int radius) {
        this(); // calling the default constructor
        this.radius = radius; // setting the radius
    }

    /**
     * Overloaded constructor. Initializes the circle with the specified origin and radius.
     *
     * @param x the x-coordinate of the origin
     * @param y the y-coordinate of the origin
     * @param radius the radius of the circle
     */
    public Circle5(int x, int y, int radius) {
        this.x = Math.max(-100, Math.min(100, x)); // ensuring x is within [-100, 100]
        this.y = Math.max(-100, Math.min(100, y)); // ensuring y is within [-100, 100]
        this.radius = Math.max(1, Math.min(100, radius)); // ensuring radius is within [1, 100]
    }

    /**
     * Returns a string representation of the circle in the form of an equation.
     *
     * @return a string representing the circle
     */
    @Override
    public String toString() {
        return "(x-" + this.x + ")^2" + " + " + "(y-" + this.y + ")^2" + " = " + this.radius + "^2";
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return the area of the circle
     */
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Calculates and returns the perimeter (circumference) of the circle.
     *
     * @return the perimeter of the circle
     */
    public double perimeter() {
        return diameter() * Math.PI; // using diameter() method
    }

    /**
     * Private method to calculate the diameter of the circle.
     *
     * @return the diameter of the circle
     */
    private int diameter() {
        return 2 * this.radius;
    }

    /**
     * Updates the origin of the circle to the new coordinates.
     *
     * @param x the new x-coordinate of the origin
     * @param y the new y-coordinate of the origin
     */
    public void move(int x, int y) {
        this.x = Math.max(-100, Math.min(100, x)); // ensuring x is within [-100, 100]
        this.y = Math.max(-100, Math.min(100, y)); // ensuring y is within [-100, 100]
    }

    /**
     * Updates the size of the circle's radius.
     *
     * @param radius the new radius of the circle
     */
    public void resize(int radius) {
        this.radius = Math.max(1, Math.min(100, radius)); // ensuring radius is within [1, 100]
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Returns an array containing the x and y coordinates of the origin.
     *
     * @return an array containing the x and y coordinates
     */
    public int[] getOrigin() {
        return new int[] { this.x, this.y };
    }

    /**
     * Combines the circle with another circle by adding their radii and updating the origin
     * to the midpoint of the line segment between the two circle's origins.
     *
     * @param circle5 the circle to be combined with
     */
    public void combineCircle(Circle5 circle5) {
        this.radius += circle5.getRadius(); // adding the incoming circle's radius to this circle's radius
        // Calculating the midpoint of the line segment between the two circle's origins
        this.x = (this.x + circle5.x) / 2;
        this.y = (this.y + circle5.y) / 2;
    }

    /**
     * Doubles the size of the circle by combining it with itself.
     */
    public void doubleCircle() {
        combineCircle(this); // calling combineCircle with the current circle as the parameter
    }
}
