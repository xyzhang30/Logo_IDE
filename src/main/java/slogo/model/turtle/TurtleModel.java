package slogo.model.turtle;

import slogo.model.api.TurtleModelApi;
import slogo.model.api.TurtleRecord;

public class TurtleModel implements TurtleModelApi {

  private double posX;
  private double posY;
  private double speed;
  private double direction; //0 = right; 90 = top; 180 = left; 270 = bottom;
  private boolean penDown;
  private boolean visible;

  public TurtleModel() {
    initialize();
  }

  public double getPosX() {
    return posX;
  }

  public void setPosX(double newPosX) {
    this.posX = newPosX;
  }

  public double getPoxY() {
    return posY;
  }

  public void setPosY(double newPosY) {
    this.posY = newPosY;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(int newSpeed) {
    this.speed = newSpeed;
  }

  public double getDirection() {
    return direction;
  }

  /**
   * gets a direction input in degrees and cast it to radians, and set it as the new direction of
   * the turtle
   *
   * @param newDirection direction input in degrees
   */
  public void setDirection(int newDirection) {
    this.direction = Math.toRadians(newDirection);
  }

  public boolean isPenDown() {
    return penDown;
  }

  public void setPenDown(boolean penDown) {
    this.penDown = penDown;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void reset() {
    initialize();
  }

  private void initialize() {
    this.posX = 0;
    this.posY = 0;
    this.speed = 1; //default values (might change later)
    this.direction = 0;
    this.penDown = false; //default to false, might change
    this.visible = true; //default to visible
  }

  /**
   * Packs the Turtle attributes into a record to be sent to View.
   * Records are immutable, so View will not be able to modify model attributes.
   * @return TurtleRecord  record storing all TurtleModel attributes
   */
  @Override
  public TurtleRecord getAttributes() {
    return new TurtleRecord(posX,posY,speed,direction,penDown,visible);
  }
}
