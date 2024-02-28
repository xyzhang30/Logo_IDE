package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TurtleView {

  private boolean imageHere;

  private ImageView turtleImage;

  private Pane pane;

  public TurtleView(int width, int height, double startX, double startY, double startDirection) {
    pane = new Pane();
    pane.setPrefWidth(width);
    pane.setPrefHeight(height);
    turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));
    turtleImage.setFitWidth(50);
    turtleImage.setFitHeight(50);
    turtleImage.setX(startX);
    turtleImage.setY(startY);
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
    turtleImage.setTranslateY(x);
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
