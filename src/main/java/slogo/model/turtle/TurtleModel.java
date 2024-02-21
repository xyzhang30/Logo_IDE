package slogo.model.turtle;

public class TurtleModel {

  private double posX;
  private double posY;
  private int speed;
  private double direction; //0 = right; 90 = top; 180 = left; 270 = bottom;
  private boolean penDown;
  private boolean visible;

  public TurtleModel() {
    this.posX = 0;
    this.posY = 0;
    this.speed = 1; //default values (might change later)
    this.direction = 0;
    this.penDown = false; //default to false, might change
    this.visible = true; //default to visible
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

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int newSpeed) {
    this.speed = newSpeed;
  }

  public double getDirection() {
    return direction;
  }

  public void setDirection(int newDirection) {
    double angleDegrees = newDirection;
    this.direction = Math.toRadians(angleDegrees);
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
}
