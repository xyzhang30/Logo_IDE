package slogo.view;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.paint.Color;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
  private static final int timeIncrement = 10;
  private static final double activeOpacity = 1.0;
  private static final double inactiveOpacity = 0.7;
  private final Map<Double, TurtleModelApi> model;
  private final Graphics animations;
  private int speed;
  private final Map<Double, TurtleV> turtles;
  private Timeline timeline;
  private final PenGraphics pen;
  private boolean paused;

  private int timeLinePoint;

  private Controller controller;


  /**
   * Constructor
   * @param recordTurtle = takes in record of important attributes to be stored in TurtlePane
   */
  public TurtlePane(TurtlePaneRecord recordTurtle) {
    super(recordTurtle.height(), recordTurtle.width(), recordTurtle.language());
    controller = recordTurtle.controller();
    paused = false;
    getRoot().setPrefHeight(getHeight());
    getRoot().setPrefWidth(getWidth());
    model = recordTurtle.model();
    setRoot(new StackPane());
    speed = recordTurtle.speed();
    turtles = new HashMap<>();
    createTurtleViews();
    pen = new PenDraw();
    animations = new Animations(getHeight(), getWidth(), getLanguage(), pen);
    timeline = new Timeline();
    timeline.stop();
    timeLinePoint = 0;
    create();
  }

  private void createTurtleViews() {
    for (Map.Entry<Double, TurtleModelApi> entry : model.entrySet()) {
      Double key = entry.getKey();
      TurtleModelApi value = entry.getValue();
      if (!turtles.containsKey(key)) {
        TurtleV turtle = new TurtleView(getWidth(), getHeight(),
            value.getAttributes().xpos(), value.getAttributes().ypos(),
            value.getAttributes().direction());
        turtles.put(key, turtle);
        getRoot().getChildren().add(turtle.getRoot());
      }
    }
  }

  /**
   * Creates the layout of the TurtlePane by adding turtle and animation components to the root
   * StackPane.
   */
  @Override
  public void create() {
    getRoot().getChildren().add(animations.getRoot());
  }

  /**
   * Updates the TurtlePane based on the current state of the associated TurtleModelApi.
   */
  public void update() {
    createTurtleViews();
    Timeline timeline = createTimeline();
    timeline.play();
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
    animations.clearCanvas();
  }

  private Timeline createTimeline() {
    timeline = new Timeline();
    timeline.setCycleCount(1);

    for (timeLinePoint = 0; timeLinePoint < (defaultLineLength / speed); timeLinePoint++) {
      final int frameIndex = timeLinePoint;
      KeyFrame keyFrame = new KeyFrame(Duration.millis(frameIndex * timeIncrement), e -> {
        createMovements(frameIndex);
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

  private void createMovements(int i) {
    for (Map.Entry<Double, TurtleModelApi> entry : model.entrySet()) {
      Double key = entry.getKey();
      TurtleModelApi value = entry.getValue();
      TurtleV usingTurtle = turtles.get(key);

      double startX = usingTurtle.getX();
      double startY = usingTurtle.getY();
      double startDirection = usingTurtle.getDirection();
      boolean visible = value.getAttributes().visible();

      double x = startX + i * (value.getAttributes().xpos() - startX) / ((double) defaultLineLength / speed);
      double y = startY + i * (value.getAttributes().ypos() - startY) / ((double) defaultLineLength / speed);
      double direction = startDirection + i * (value.getAttributes().direction() -
          startDirection) / ((double) defaultLineLength / speed);

      if (value.getAttributes().pen()) {
        animations.drawLine(startX, startY, x, y);
      }
      if (value.getAttributes().active()) {
        usingTurtle.getTurtleImage().setOpacity(activeOpacity);
        usingTurtle.turtleUpdate(x, y, direction, visible);
      }
      else {
        usingTurtle.getTurtleImage().setOpacity(inactiveOpacity);
      }
    }
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
    for (Map.Entry<Double, TurtleV> entry : turtles.entrySet()) {
      Double key = entry.getKey();
      TurtleV value = entry.getValue();
      value.updateImage(selectedFile);
      value.turtleUpdate(model.get(key).getAttributes().xpos(),
          model.get(key).getAttributes().ypos(),
          model.get(key).getAttributes().direction(),
          model.get(key).getAttributes().visible());
    }
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