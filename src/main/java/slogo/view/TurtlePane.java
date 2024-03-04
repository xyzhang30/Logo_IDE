package slogo.view;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import slogo.model.api.TurtleModelApi;

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

  public TurtlePane(int height, int width, TurtleModelApi model, String language, int speed) {
    super(height, width, language);
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

  @Override
  public void create() {
    StackPane.setAlignment(turtle.getRoot(), Pos.CENTER);
    StackPane.setAlignment(a1.getCanvas(), Pos.CENTER);
    getRoot().getChildren().add(turtle.getRoot());
    getRoot().getChildren().add(a1.getRoot());
  }
  public void update() {
    Timeline timeline = createTimeline(currentX, currentY, currentDirection, model.getAttributes().xpos(),
        model.getAttributes().ypos(), model.getAttributes().direction(), model.getAttributes().visible());
    timeline.play();
    currentX = model.getAttributes().xpos();
    currentY = model.getAttributes().ypos();
    currentDirection = model.getAttributes().direction();
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }
  public void clear() {
    a1.clearCanvas();
  }

  private Timeline createTimeline(double startX, double startY, double startDirection, double endX, double endY,
      double endDirection, boolean visible) {
    timeline = new Timeline();
    timeline.setCycleCount(1);
    for (int i = 0; i < (defaultLineLength/speed); i++) {
      double x = startX + i * (endX - startX) / ((double) defaultLineLength /speed);
      double y = startY + i * (endY - startY) / ((double) defaultLineLength /speed);
      double direction = startDirection + i * (endDirection - startDirection) / (
          (double) defaultLineLength /speed);

      KeyFrame keyFrame = new KeyFrame(Duration.millis(i * 10), e -> {
        a1.drawLine(startX, startY, x, y);
        turtle.turtleUpdate(x,y,direction, visible);

      });

      timeline.getKeyFrames().add(keyFrame);
    }

    // Set an event handler for when the timeline finishes
    timeline.setOnFinished(e -> {
      timeline.stop(); // Stop the timeline after drawing once
    });

    return timeline;
  }

  public void startTimeline() {
    if (timeline != null && !timeline.getStatus().equals(Timeline.Status.RUNNING)) {
      paused = false;
      timeline.play();
    }
  }

  public void stopTimeline() {
    if (timeline != null && timeline.getStatus().equals(Timeline.Status.RUNNING)) {
      timeline.pause();
      paused = true;
    }
  }

  public void updateColor(Color c1) {
    pen.setPenColor(c1);
  }

  public void updateBackground(Color c1) {
    getRoot().setStyle("-fx-background-color: " + toHexCode(c1) + ";");
  }

  private String toHexCode(Color color) {
    int r = (int) (color.getRed() * 255);
    int g = (int) (color.getGreen() * 255);
    int b = (int) (color.getBlue() * 255);

    return String.format("#%02X%02X%02X", r, g, b);
  }

  public void updateImage(File selectedFile) {
    turtle.updateImage(selectedFile);
    turtle.turtleUpdate(model.getAttributes().xpos(),
        model.getAttributes().ypos(), model.getAttributes().direction(),
        model.getAttributes().visible());
  }

  public boolean complete() {
    if (timeline.getStatus().equals(Status.STOPPED)) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean getPaused() {
    return paused;
  }
}
