package slogo.view;

import javafx.scene.paint.Color;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import slogo.model.api.TurtleModelApi;

/**
 * The TurtlePane class represents a graphical view of a turtle, including its position,
 * direction, and drawing capabilities. It extends the CreatePane class to manage its layout and
 * appearance.
 */
public class TurtlePane extends CreatePane implements TurtleBase {

  private static final int defaultLineLength = 1000;
  private final TurtleModelApi model;
  private final Animations a1;
  private int speed;
  private double currentX;
  private double currentY;
  private double currentDirection;
  private final TurtleV turtle;
  private Timeline timeline;
  private final PenGraphics pen;
  private boolean paused;

  private double id;
  private Controller controller;

  /**
   * Constructs a TurtlePane with the specified dimensions, TurtleModelApi, language setting,
   * speed, controller, and unique ID.
   *
   * @param height     the height of the TurtlePane.
   * @param width      the width of the TurtlePane.
   * @param model      the TurtleModelApi associated with the TurtlePane.
   * @param language   the language setting for the TurtlePane.
   * @param speed      the speed of turtle animations.
   * @param controller the Controller instance managing the application.
   * @param id         the unique ID of the turtle.
   */
  public TurtlePane(int height, int width, TurtleModelApi model, String language,
      int speed, Controller controller, double id) {
    super(height, width, language);
    this.controller = controller;
    this.id = id;
    paused = false;
    getRoot().setPrefHeight(height);
    getRoot().setPrefWidth(width);
    this.model = model;
    setRoot(new StackPane());
    this.speed = speed;
    turtle = new TurtleView(width, height,
        model.getAttributes().xpos(), model.getAttributes().ypos(), model.getAttributes().direction());
    pen = new PenDraw();
    a1 = new Animations(height, width, language, pen);
    currentX = model.getAttributes().xpos();
    currentY = model.getAttributes().ypos();
    currentDirection = model.getAttributes().direction();
    timeline = new Timeline();
    timeline.stop();
    create();
  }

  /**
   * Creates the layout of the TurtlePane by adding turtle and animation components to the root
   * StackPane.
   */
  @Override
  public void create() {
    StackPane.setAlignment(turtle.getRoot(), Pos.CENTER);
    StackPane.setAlignment(a1.getCanvas(), Pos.CENTER);
    getRoot().getChildren().add(turtle.getRoot());
    getRoot().getChildren().add(a1.getRoot());
  }

  /**
   * Updates the TurtlePane based on the current state of the associated TurtleModelApi.
   */
  public void update() {
    Timeline timeline = createTimeline(currentX, currentY, currentDirection, model.getAttributes().xpos(),
        model.getAttributes().ypos(), model.getAttributes().direction(), model.getAttributes().visible());
    timeline.play();
    currentX = model.getAttributes().xpos();
    currentY = model.getAttributes().ypos();
    currentDirection = model.getAttributes().direction();
  }

  /**
   * Sets the speed of turtle animations.
   *
   * @param speed the new speed value.
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Clears the canvas of the TurtlePane.
   */
  public void clear() {
    a1.clearCanvas();
  }

  private Timeline createTimeline(double startX, double startY, double startDirection, double endX, double endY,
      double endDirection, boolean visible) {
    timeline = new Timeline();
    timeline.setCycleCount(1);
    for (int i = 0; i < (defaultLineLength / speed); i++) {
      double x = startX + i * (endX - startX) / ((double) defaultLineLength / speed);
      double y = startY + i * (endY - startY) / ((double) defaultLineLength / speed);
      double direction = startDirection + i * (endDirection - startDirection) / (
          (double) defaultLineLength / speed);

      KeyFrame keyFrame = new KeyFrame(Duration.millis(i * 10), e -> {
        if (model.getAttributes().pen()) {
          a1.drawLine(startX, startY, x, y);
        }
        turtle.turtleUpdate(x, y, direction, visible);
      });

      timeline.getKeyFrames().add(keyFrame);
    }

    // Set an event handler for when the timeline finishes
    timeline.setOnFinished(e -> {
      timeline.stop(); // Stop the timeline after drawing once
      controller.runNext();
    });

    return timeline;
  }

  /**
   * Starts the timeline animation.
   */
  public void startTimeline() {
    if (timeline != null && !timeline.getStatus().equals(Timeline.Status.RUNNING)) {
      paused = false;
      timeline.play();
    }
  }

  /**
   * Pauses the timeline animation.
   */
  public void stopTimeline() {
    if (timeline != null && timeline.getStatus().equals(Timeline.Status.RUNNING)) {
      timeline.pause();
      paused = true;
    }
  }

  /**
   * Updates the pen color of the turtle.
   *
   * @param c1 the new color value.
   */
  public void updateColor(Color c1) {
    pen.setPenColor(c1);
  }

  /**
   * Updates the background color of the TurtlePane.
   *
   * @param c1 the new background color value.
   */
  public void updateBackground(Color c1) {
    getRoot().setStyle("-fx-background-color: " + toHexCode(c1) + ";");
  }

  private String toHexCode(Color color) {
    int r = (int) (color.getRed() * 255);
    int g = (int) (color.getGreen() * 255);
    int b = (int) (color.getBlue() * 255);

    return String.format("#%02X%02X%02X", r, g, b);
  }

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFile the file containing the image for the turtle.
   */
  public void updateImage(File selectedFile) {
    turtle.updateImage(selectedFile);
    turtle.turtleUpdate(model.getAttributes().xpos(),
        model.getAttributes().ypos(), model.getAttributes().direction(),
        model.getAttributes().visible());
  }

  /**
   * Retrieves the paused state of the timeline animation.
   *
   * @return true if the timeline animation is paused, false otherwise.
   */
  public boolean getPaused() {
    return paused;
  }
}