package slogo.model.turtle;

import slogo.model.api.TurtleModelApi;
import slogo.model.api.TurtleRecord;

/**
 * Represents the model of a turtle in the system.
 */
public class TurtleModel implements TurtleModelApi {

  private boolean active;
  private double posX;
  private double posY;
  private double speed;
  private double direction; //0 = right; 90 = top; 180 = left; 270 = bottom;
  private boolean penDown;
  private boolean visible;
  private boolean eraseTrace;

  /**
   * Constructs a new turtle model
   */
  public TurtleModel() {
    initialize();
  }

  /**
   * Checks if the turtle is currently active.
   *
   * @return true if the turtle is active, false otherwise
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the activation status of the turtle.
   *
   * @param activation true to activate the turtle, false to deactivate it
   */
  public void setActive(boolean activation) {
    active = activation;
  }

  /**
   * Checks if the turtle's trace should be erased.
   *
   * @return true if the trace should be erased, false otherwise
   */
  public boolean isEraseTrace() {
    return eraseTrace;
  }

  /**
   * Sets whether the turtle's trace should be erased.
   *
   * @param erase true to erase the trace, false otherwise
   */
  public void setEraseTrace(boolean erase) {
    this.eraseTrace = erase;
  }

  /**
   * Gets the X coordinate of the turtle's position.
   *
   * @return the X coordinate of the turtle's position
   */
  public double getPosX() {
    return posX;
  }

  /**
   * Sets the X coordinate of the turtle's position.
   *
   * @param newPosX the new X coordinate
   */
  public void setPosX(double newPosX) {
    this.posX = newPosX;
  }

  /**
   * Gets the Y coordinate of the turtle's position.
   *
   * @return the Y coordinate of the turtle's position
   */
  public double getPosY() {
    return posY;
  }

  /**
   * Sets the Y coordinate of the turtle's position.
   *
   * @param newPosY the new Y coordinate
   */
  public void setPosY(double newPosY) {
    this.posY = newPosY;
  }

  /**
   * Gets the speed of the turtle.
   *
   * @return the speed of the turtle
   */
  public double getSpeed() {
    return speed;
  }


  /**
   * Sets the speed of the turtle.
   *
   * @param newSpeed the new speed of the turtle
   */
  public void setSpeed(int newSpeed) {
    this.speed = newSpeed;
  }

  /**
   * Gets the direction of the turtle in radians.
   *
   * @return the direction of the turtle in radians
   */
  public double getRadianDirection() {
    return Math.toRadians(direction);
  }

  /**
   * Gets the direction of the turtle in degrees.
   *
   * @return the direction of the turtle in degrees
   */
  public double getDegreesDirection() {
    return direction;
  }

  /**
   * gets a direction input in degrees and cast it to radians, and set it as the new direction of
   * the turtle
   *
   * @param newDirection direction input in degrees
   */
  public void setDirection(double newDirection) {
    this.direction = newDirection; // in degrees
  }

  /**
   * Checks if the pen of the turtle is down.
   *
   * @return true if the pen is down, false otherwise
   */
  public boolean isPenDown() {
    return penDown;
  }

  /**
   * Sets whether the pen of the turtle is down.
   *
   * @param penDown true to put the pen down, false to lift it up
   */
  public void setPenDown(boolean penDown) {
    this.penDown = penDown;
  }

  /**
   * Checks if the turtle is visible.
   *
   * @return true if the turtle is visible, false otherwise
   */
  public boolean isVisible() {
    return visible;
  }

  /**
   * Sets whether the turtle is visible.
   *
   * @param visible true to make the turtle visible, false to make it invisible
   */
  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  /**
   * Resets the turtle to its initial state.
   */
  public void reset() {
    initialize();
  }

  private void initialize() {
    this.active = true;
    this.posX = 0;
    this.posY = 0;
    this.speed = 1; //default values (might change later)
    this.direction = 0;
    this.penDown = false; //default to false, might change
    this.visible = true; //default to visible
    this.eraseTrace = false;
  }

  /**
   * Packs the Turtle attributes into a record to be sent to View. Records are immutable, so View
   * will not be able to modify model attributes.
   *
   * @return TurtleRecord  record storing all TurtleModel attributes
   */
  @Override
  public TurtleRecord getAttributes() {
    return new TurtleRecord(active, posX, posY, speed, direction, penDown, visible, eraseTrace);
  }
}
