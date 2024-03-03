package slogo.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class Animations implements Graphics {

  private final Canvas canvas;

  private final GraphicsContext gc;

  private final PenGraphics pen;

  private final Pane pane;

  private final int width;

  private final int height;


  public Animations(int height, int width, String language, PenGraphics pen) {
    this.width = width;
    this.height = height;
    pane = new Pane();
    canvas = new Canvas(width, height);
    canvas.setLayoutX(0);
    canvas.setLayoutY(0);
    canvas.setWidth(width);
    canvas.setHeight(height);
    //canvas.setTranslateX(width/2);
    //canvas.setTranslateY(height/2);
    gc = canvas.getGraphicsContext2D();
    this.pen = pen;
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
    pane.getChildren().add(canvas);
  }

  @Override
  public void clearCanvas() {
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public Pane getRoot() {
    return pane;
  }

  @Override
  public GraphicsContext getGraphicsContext() {
    return gc;
  }

  @Override
  public void drawLine(double startX, double startY, double endX, double endY) {
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
    gc.strokeLine( (width/2) + startX, (height/2) + startY, (width/2) + endX,(height/2) +  endY);
  }
}
