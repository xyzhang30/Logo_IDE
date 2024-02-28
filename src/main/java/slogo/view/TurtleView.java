package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TurtleView {

  private boolean imageHere;

  private ImageView turtleImage;

  public static final int TURTLE_SIZE = 50;

  private Pane pane;

  public TurtleView(int width, int height, double startX, double startY, double startDirection) {
    pane = new Pane();
    turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));
    turtleImage.setFitWidth(TURTLE_SIZE);
    turtleImage.setFitHeight(TURTLE_SIZE);
    pane.setLayoutX(0);
    pane.setLayoutY(0);
    pane.setPrefWidth(width);
    pane.setPrefHeight(height);
    turtleImage.setX(-(TURTLE_SIZE/2));
    turtleImage.setY(-(TURTLE_SIZE/2));
    turtleImage.setRotate(startDirection);
    pane.getChildren().add(turtleImage);
    imageHere = true;
  }

  public ImageView getTurtleImage() {
    return turtleImage;
  }

  public void turtleUpdate(double x, double y, double direction) {
    updateDirection(direction);
    updateXCoordinate(x);
    updateYCoordinate(y);
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

  private void isVisible(boolean visible) {
    if (visible && !imageHere) {
      turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));
      imageHere = true;
    }
  }
}
