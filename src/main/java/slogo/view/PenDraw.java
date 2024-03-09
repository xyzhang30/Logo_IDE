package slogo.view;

import javafx.scene.paint.Color;

/**
 * The PenDraw class implements the PenGraphics interface and represents the pen's drawing state,
 * including whether it is down or up, its color, and its size.
 */
public class PenDraw implements PenGraphics {

  private static final int defaultSize = 2;
  private static final Color defaultColor = Color.BLUE;
  private static final boolean defaultPenDown = true;
  private boolean penDown;
  private Color penColor;
  private int penSize;

  /**
   * Constructs a PenDraw object with default values: pen down, blue color, and size 2.
   */
  public PenDraw() {
    penDown = defaultPenDown;
    penColor = defaultColor;
    penSize = defaultSize;
  }

  /**
   * Constructs a PenDraw object with the specified pen state, color, and size.
   *
   * @param penDown  true if the pen is down, false otherwise.
   * @param penColor the color of the pen.
   * @param penSize  the size of the pen.
   */
  public PenDraw(boolean penDown, Color penColor, int penSize) {
    this.penDown = penDown;
    this.penColor = penColor;
    this.penSize = penSize;
  }

  /**
   * Gets the color of the pen.
   *
   * @return the color of the pen.
   */
  @Override
  public Color getPenColor() {
    return penColor;
  }

  /**
   * Sets the color of the pen.
   *
   * @param color the color to set for the pen.
   */
  @Override
  public void setPenColor(Color color) {
    this.penColor = color;
  }

  /**
   * Gets the size of the pen.
   *
   * @return the size of the pen.
   */
  @Override
  public int getSize() {
    return penSize;
  }

  /**
   * Sets the pen state (down or up).
   *
   * @param penDown true if the pen is down, false otherwise.
   */
  @Override
  public void setPenDown(boolean penDown) {
    this.penDown = penDown;
  }

  /**
   * Sets the size of the pen.
   *
   * @param size the size to set for the pen.
   */
  @Override
  public void setPenSize(int size) {
    this.penSize = size;
  }
}
