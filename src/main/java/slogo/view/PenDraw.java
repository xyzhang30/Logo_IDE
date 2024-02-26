package slogo.view;

import javafx.scene.paint.Color;

public class PenDraw implements Pen {

  private boolean penDown;

  private Color penColor;

  private int penSize;
  @Override
  public boolean getPenDown() {
    return penDown;
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
