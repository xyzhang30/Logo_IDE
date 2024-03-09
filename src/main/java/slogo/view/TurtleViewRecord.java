package slogo.view;

/**
 * Record representing the information about a turtle view, including its dimensions,
 * initial position, and starting direction.
 */
public record TurtleViewRecord(int width, int height, double startX,
                               double startY, double startDirection, int turtleSize) {
}

