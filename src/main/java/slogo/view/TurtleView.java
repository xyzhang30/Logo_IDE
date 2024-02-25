package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TurtleView implements TurtleBase {

  private Image tImage;

  private Pen pen;

  public TurtleView() throws FileNotFoundException {
    tImage = new Image(new File("src/main/resources/view/turtle1.png").toURI().toString());

  }

  @Override
  public void setImage(Image tImage) {
    this.tImage = tImage;
  }

  @Override
  public Image getImage() {
    return tImage;
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
