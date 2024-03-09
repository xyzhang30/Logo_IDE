package slogo.view;

import javafx.scene.Node;

/**
 * Graphics interface defines methods for performing graphical operations on a canvas.
 */
public interface Graphics {


  /**
   * Method to be overridden to clear all lines on canvas.
   */
  void clearCanvas();

  /**
   * @return the graphics context being used
   */
  Node getRoot();

  /**
   * Will create line from starting coordinates to ending coordinates
   *
   * @param x1 = starting x
   * @param y1 = starting y
   * @param x2 = ending x
   * @param y2 = ending y
   */
  void drawLine(double x1, double y1, double x2, double y2);


}
