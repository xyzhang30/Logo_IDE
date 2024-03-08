package slogo.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

/**
 * Animations Class. Creates the lines drawn in the view
 */
public class Animations implements Graphics {

  private final Canvas canvas;

  private final GraphicsContext gc;

  private final PenGraphics pen;

  private final Pane pane;

  private final int width;

  private final int height;

  /**
   * Constructor. Sets canvas, graphicsContext, and other variables.
   * @param height = height of canvas
   * @param width = width of canvas
   * @param language = language in ase this became necessary
   * @param pen = pen for storing values related to the lines being drawn
   */
  public Animations(int height, int width, String language, PenGraphics pen) {
    this.width = width;
    this.height = height;
    pane = new Pane();
    canvas = new Canvas(width, height);
    canvas.setLayoutX(0);
    canvas.setLayoutY(0);
    canvas.setWidth(width);
    canvas.setHeight(height);
    gc = canvas.getGraphicsContext2D();
    this.pen = pen;
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
    pane.getChildren().add(canvas);
  }


  /**
   * clears all lines
   */
  @Override
  public void clearCanvas() {
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
  }

  /**
   * Important getter so that class can access the pane and thus display the lines
   * @return the root that the canvas is on
   */
  @Override
  public Pane getRoot() {
    return pane;
  }


  /**
   * Draws line from starting coordinates from ending coordinates
   * @param startX = starting x coordinate of line
   * @param startY = starting y coordinate of line
   * @param endX = ending x coordinate of line
   * @param endY = ending y coordinate of line
   */
  @Override
  public void drawLine(double startX, double startY, double endX, double endY) {
    gc.setStroke(pen.getPenColor());
    gc.setLineWidth(pen.getSize());
    gc.strokeLine( (width/2) + startX, (height/2) + startY, (width/2) + endX,(height/2) +  endY);
  }
}
