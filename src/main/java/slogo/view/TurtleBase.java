package slogo.view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public interface TurtleBase {

  void setImage(Image tImage);

  Image getImage();

  void setPenColor(Color color);

  void setPenDown(boolean penDown);

  Pen getPen();

  void setAngle(double angle);

  void setxPosition(int xPosition);

  void setyPosition(int yPosition);

  void setPenSize(int width);

  void setIsVisible();

}
