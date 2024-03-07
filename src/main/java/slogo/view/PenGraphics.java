package slogo.view;

import javafx.scene.paint.Color;

/**
 * The PenGraphics interface defines methods for managing the state of a pen used for graphics
 * drawing. Implementing classes are responsible for handling pen color, size, and whether the pen
 * is currently down or up.
 */
public interface PenGraphics {

  /**
   * Gets the color of the pen.
   *
   * @return the color of the pen.
   */
  Color getPenColor();

  /**
   * Gets the size of the pen.
   *
   * @return the size of the pen.
   */
  int getSize();

  /**
   * Sets the pen state (down or up).
   *
   * @param penDown true if the pen is down, false otherwise.
   */
  void setPenDown(boolean penDown);

  /**
   * Sets the color of the pen.
   *
   * @param color the color to set for the pen.
   */
  void setPenColor(Color color);

  /**
   * Sets the size of the pen.
   *
   * @param size the size to set for the pen.
   */
  void setPenSize(int size);
}

