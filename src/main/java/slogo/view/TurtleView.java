package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TurtleView implements TurtleV {

  private boolean imageHere;

  private ImageView turtleImage;

  public static final int TURTLE_SIZE = 50;

  private Pane pane;

  public TurtleView(int width, int height, double startX, double startY, double startDirection) {
    pane = new Pane();
    pane.setId("TurtleImagePane");
    turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));
    turtleImage.setFitWidth(TURTLE_SIZE);
    turtleImage.setFitHeight(TURTLE_SIZE);
    pane.setLayoutX(100000);
    pane.setLayoutY(0);
    pane.setPrefWidth(1000000000);
    pane.setPrefHeight(height);
    turtleImage.setX(0);
    turtleImage.setY(0);
    turtleImage.setRotate(startDirection);
    pane.getChildren().add(turtleImage);
    imageHere = true;
  }

  public ImageView getTurtleImage() {
    return turtleImage;
  }

  public void turtleUpdate(double x, double y, double direction, boolean visible) {
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

  @Override
  public void setTurtleImage(Image t1) {

  }

  private void isVisible(boolean visible) {
    if (visible && !imageHere) {
      turtleImage = new ImageView(new Image(new File("src/main/resources/view/turtle1.png").toURI().toString()));
      imageHere = true;
    }
    else if (!visible && imageHere) {
      pane.getChildren().removeAll();
    }
  }
}
