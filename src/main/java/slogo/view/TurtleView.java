package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;

public class TurtleView implements TurtleV {

  private boolean imageHere;

  private ImageView turtleImage;

  public static final int TURTLE_SIZE = 50;

  private int width;

  private double startDirection;

  private int height;

  private Pane pane;

  public TurtleView(int width, int height, double startX, double startY, double startDirection) {
    this.width = width;
    this.height = height;
    imageHere = true;
    this.startDirection = startDirection;
    pane = new Pane();
    pane.setId("TurtleImagePane");
    turtleImage = new ImageView(new Image(new File("src/main/resources/view/images/turtle1.png").toURI().toString()));
    pane.setTranslateX(width / 2);
    pane.setTranslateY(height / 2);
    pane.setPrefWidth(width);
    pane.setPrefHeight(height);
    initialize();

  }

  public ImageView getTurtleImage() {
    return turtleImage;
  }

  public void turtleUpdate(double x, double y, double direction, boolean visible) {
    updateDirection(direction);
    updateXCoordinate(x);
    updateYCoordinate(y);
    isVisible(visible);
  }

  private void updateDirection(double direction) {
    turtleImage.setRotate(direction);
  }

  private void updateXCoordinate(double x){
    turtleImage.setTranslateX(x);
  }

  private void updateYCoordinate(double y){
    turtleImage.setTranslateY(y);
  }

  public Pane getRoot() {
    return pane;
  }

  public boolean getImageHere() {
    return imageHere;
  }

  @Override
  public void updateImage(File selectedFile) {
    if (!pane.getChildren().isEmpty()) {
      pane.getChildren().remove(0);
    }
    turtleImage = new ImageView(new Image(selectedFile.toURI().toString()));
    initialize();
  }

  private void initialize() {
    turtleImage.setFitWidth(TURTLE_SIZE);
    turtleImage.setFitHeight(TURTLE_SIZE);
    turtleImage.setX(-((TURTLE_SIZE)/2));
    turtleImage.setY(-((TURTLE_SIZE)/2));
    turtleImage.setRotate(startDirection);
    if (imageHere) {
      pane.getChildren().add(turtleImage);
    }
  }

  private void isVisible(boolean visible) {
    if (visible && !imageHere) {
      pane.getChildren().add(turtleImage);
      imageHere = true;
    }
    else if (!visible && imageHere) {
      pane.getChildren().remove(turtleImage);
      imageHere = false;
    }
  }
}
