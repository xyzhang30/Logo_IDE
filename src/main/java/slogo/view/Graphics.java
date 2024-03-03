package slogo.view;

import javafx.scene.canvas.GraphicsContext;

public interface Graphics {
  /**
   * Graphics interface defines methods for performing graphical operations on a canvas.
   */

  void clearCanvas();

  GraphicsContext getGraphicsContext();

  void drawLine(double x1, double y1, double x2, double y2);


}
