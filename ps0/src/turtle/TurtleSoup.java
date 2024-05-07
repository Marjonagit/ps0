/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
    }


    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static int calculateRegularPolygonSides(double angle) {
    if (angle <= 0 || angle >= 180) {
        throw new IllegalArgumentException("Angle must be greater than 0 and less than 180 degrees.");
    }
    double sides = 360 / angle;
    return (int) Math.round(sides);
}



    public static int calculatePolygonSidesFromAngle(double angle) {
        throw new RuntimeException("implement me!");
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
    if (sides < 3) {
        throw new IllegalArgumentException("A polygon must have at least 3 sides.");
    }
    for (int i = 0; i < sides; i++) {
        turtle.forward(sideLength);
        turtle.turn(360.0 / sides);
    }
}


    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                              int targetX, int targetY) {
    int deltaX = targetX - currentX;
    int deltaY = targetY - currentY;
    double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
    double adjustedAngle = angle - currentHeading;
    if (adjustedAngle < 0) {
        adjustedAngle += 360;
    }
    return adjustedAngle;
}



    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
    List<Double> headings = new ArrayList<>();
    if (xCoords.size() != yCoords.size()) {
        throw new IllegalArgumentException("xCoords and yCoords must be of the same size.");
    }
    if (xCoords.size() < 2) {
        return headings;
    }
    double currentHeading = 0; // Assuming turtle starts facing up
    for (int i = 0; i < xCoords.size() - 1; i++) {
        double heading = calculateHeadingToPoint(currentHeading, xCoords.get(i), yCoords.get(i),
                                                 xCoords.get(i + 1), yCoords.get(i + 1));
        headings.add(heading);
        currentHeading += heading; // Update current heading
    }
    return headings;
}


    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */



    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawSquare(turtle, 40);

        double angle = 60; // Example angle
        int sides = calculateRegularPolygonSides(angle);
        System.out.println("Number of sides in a regular polygon with angle " + angle + " degrees: " + sides);

        int numSides = 5; // Example number of sides
        drawRegularPolygon(turtle, numSides, 50);

        double currentHeading = 0; // Example current heading
        int currentX = 0, currentY = 0; // Example current position
        int targetX = 50, targetY = 50; // Example target position
        double headingToPoint = calculateHeadingToPoint(currentHeading, currentX, currentY, targetX, targetY);
        System.out.println("Heading adjustment to point to (" + targetX + ", " + targetY + "): " + headingToPoint + " degrees");

        Arrays Arrays = null;
        List<Integer> xCoords = Arrays.asList(0, 50, 100); // Example x-coordinates
        List<Integer> yCoords = Arrays.asList(0, 50, 0);    // Example y-coordinates
        List<Double> headings = calculateHeadings(xCoords, yCoords);
        System.out.println("Heading adjustments between points: " + headings);



        // draw the window
        turtle.draw();
    }

    public static double calculateRegularPolygonAngle(int i) {
        return 0;
    }
}
