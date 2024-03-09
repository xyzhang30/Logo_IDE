package slogo.model.api;

/**
 * The data from TurtleModel to be passed into TurtleView
 */
public record TurtleRecord(boolean active, double xpos, double ypos, double speed, double direction,
                           boolean pen, boolean visible, boolean eraseTrace) {

}
