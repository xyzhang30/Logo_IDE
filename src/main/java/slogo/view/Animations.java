package slogo.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Animations implements Graphics {

  private final Canvas canvas;

  private final GraphicsContext gc;

  private final PenGraphics pen;


  public Animations(int height, int width, String language) {
    canvas = new Canvas(width, height);
    canvas.setLayoutX(0);
    canvas.setLayoutY(0);
    canvas.setWidth(width);
    canvas.setHeight(height);
    gc = canvas.getGraphicsContext2D();
    pen = new PenDraw();
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
  }

  @Override
  public void clearCanvas() {
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
  }

  public Canvas getCanvas() {
    return canvas;
  }

  @Override
  public GraphicsContext getGraphicsContext() {
    return gc;
  }

  @Override
  public void drawImage(double x, double y, double width, double height, String imagePath) {
    // gc.drawImage(turtle.getTurtleImage(), x, y);
  }

  @Override
  public void drawLine(double startX, double startY, double endX, double endY) {
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
    gc.strokeLine(startX, startY, endX, endY);
  }
}
