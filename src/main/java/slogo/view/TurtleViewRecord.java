package slogo.view;

/**
 * Record representing the information about a turtle view, including its dimensions,
 * initial position, starting direction, and turtle size.
 *
 * @param width          the width of the turtle view.
 * @param height         the height of the turtle view.
 * @param startX         the initial x-coordinate of the turtle.
 * @param startY         the initial y-coordinate of the turtle.
 * @param startDirection the starting direction of the turtle.
 * @param turtleSize     the size of the turtle.
 */
public record TurtleViewRecord(int width, int height, double startX,
                               double startY, double startDirection, int turtleSize) {
}

