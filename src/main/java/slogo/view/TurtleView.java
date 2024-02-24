package slogo.view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TurtleView implements TurtleBase {

  private Image tImage;

  private Pen pen;

  public TurtleView() {
    tImage = new Image();

  }

  @Override
  public void setImage(Image tImage) {
    this.tImage = tImage;
  }

  @Override
  public void setPenColor(Color color) {

  }

  @Override
  public void setPenDown(boolean penDown) {

  }

  @Override
  public Pen getPen() {
    return null;
  }

  @Override
  public void setAngle(double angle) {

  }

  @Override
  public void setxPosition(int xPosition) {

  }

  @Override
  public void setyPosition(int yPosition) {

  }

  @Override
  public void setPenSize(int width) {

  }

  @Override
  public void setIsVisible() {

  }

  @Override
  public int getxPosition() {
    return 0;
  }

  @Override
  public int getyPosition() {
    return 0;
  }

  @Override
  public double getAngle() {
    return 0;
  }
}
