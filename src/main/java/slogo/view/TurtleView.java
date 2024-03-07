package slogo.view;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The TurtleView class represents the graphical view of a turtle, including its image, position,
 * and visibility. It implements the TurtleV interface to provide methods for managing the
 * turtle's graphical representation.
 */
public class TurtleView implements TurtleV {

  private boolean imageHere;

  private ImageView turtleImage;

  public static final int TURTLE_SIZE = 50;

  private int width;

  private double startDirection;

  private int height;

  private Pane pane;

  /**
   * Constructs a TurtleView with the specified dimensions, initial position, and starting
   * direction.
   *
   * @param width          the width of the turtle view.
   * @param height         the height of the turtle view.
   * @param startX         the initial x-coordinate of the turtle.
   * @param startY         the initial y-coordinate of the turtle.
   * @param startDirection the starting direction of the turtle.
   */
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

  /**
   * Gets the ImageView representing the turtle's image.
   *
   * @return the ImageView of the turtle's image.
   */
  public ImageView getTurtleImage() {
    return turtleImage;
  }

  /**
   * Updates the graphical representation of the turtle based on the specified position, direction,
   * and visibility.
   *
   * @param x       the x-coordinate of the turtle.
   * @param y       the y-coordinate of the turtle.
   * @param direction the direction of the turtle.
   * @param visible true if the turtle is visible, false otherwise.
   */
  public void turtleUpdate(double x, double y, double direction, boolean visible) {
    updateDirection(direction);
    updateXCoordinate(x);
    updateYCoordinate(y);
    isVisible(visible);
  }

  private void updateDirection(double direction) {
    turtleImage.setRotate(direction);
  }

  private void updateXCoordinate(double x) {
    turtleImage.setTranslateX(x);
  }

  private void updateYCoordinate(double y) {
    turtleImage.setTranslateY(y);
  }

  /**
   * Gets the root Pane containing the graphical elements of the turtle.
   *
   * @return the root Pane of the turtle.
   */
  public Pane getRoot() {
    return pane;
  }

  /**
   * Gets the flag indicating whether the turtle image is present.
   *
   * @return true if the turtle image is present, false otherwise.
   */
  public boolean getImageHere() {
    return imageHere;
  }

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFile the file containing the image for the turtle.
   */
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
    turtleImage.setX(-((TURTLE_SIZE) / 2));
    turtleImage.setY(-((TURTLE_SIZE) / 2));
    turtleImage.setRotate(startDirection);
    if (imageHere) {
      pane.getChildren().add(turtleImage);
    }
  }

  private void isVisible(boolean visible) {
    if (visible && !imageHere) {
      pane.getChildren().add(turtleImage);
      imageHere = true;
    } else if (!visible && imageHere) {
      pane.getChildren().remove(turtleImage);
      imageHere = false;
    }
  }
}

