package slogo.view;

import javafx.scene.paint.Color;

public interface Pen {

  boolean getPenDown();

  Color getPenColor();

  int getSize();

  void setPenDown(boolean penDown);

  void setPenColor(Color color);

  void setPenSize(int size);

}
