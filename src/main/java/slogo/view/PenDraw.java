package slogo.view;

import javafx.scene.paint.Color;

public class PenDraw implements PenGraphics {

  private boolean penDown;

  private Color penColor;

  private int penSize;

  private static final int defaultSize = 2;

  private static final Color defaultColor = Color.RED;

  private static final boolean defaultPenDown = true;

  public PenDraw() {
    penDown = defaultPenDown;
    penColor = defaultColor;
    penSize = defaultSize;
  }

  public PenDraw(boolean penDown, Color penColor, int penSize) {
    this.penDown = penDown;
    this.penColor = penColor;
    this.penSize = penSize;
  }

  @Override
  public Color getPenColor() {
    return penColor;
  }

  @Override
  public int getSize() {
    return penSize;
  }

  @Override
  public void setPenDown(boolean penDown) {
    this.penDown = penDown;
  }

  @Override
  public void setPenColor(Color color) {
    this.penColor = color;
  }

  @Override
  public void setPenSize(int size) {
    this.penSize = size;
  }
}
