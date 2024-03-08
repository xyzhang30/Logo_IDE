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

  private static final int TURTLE_SIZE = 50;

  private static final String DEFAULT_RESOURCE_PACKAGE = "View.";

  private static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private static final String DEFAULT_IMAGE_PATH = "/images";

  private static final String DEFAULT_IMAGE = "turtle1.png";

  private boolean imageHere;

  private ImageView turtleImage;

  private double startDirection;

  private Pane pane;

  private double x;

  private double y;

  private double direction;



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
    x = startX;
    y = startY;
    direction = startDirection;
    imageHere = true;
    this.startDirection = startDirection;
    pane = new Pane();
    pane.setId("TurtleImagePane");
    // turtleImage = new ImageView(new Image(new File("src/main/resources/view/images/turtle1.png").toURI().toString()));
    turtleImage = new ImageView((new Image(getClass().
        getResource(DEFAULT_RESOURCE_FOLDER + DEFAULT_IMAGE_PATH + "/"
        + DEFAULT_IMAGE).toExternalForm())));
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
    this.x = x;
    this.y = y;
    this.direction = direction;
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
   * @param selectedFilePath the name of the file containing the image for the turtle.
   */
  @Override
  public void updateImage(String selectedFilePath) {
    if (!pane.getChildren().isEmpty()) {
      pane.getChildren().remove(0);
    }
    turtleImage = new ImageView((new Image(getClass().
        getResource(DEFAULT_RESOURCE_FOLDER + DEFAULT_IMAGE_PATH + "/"
            + selectedFilePath).toExternalForm())));
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

  @Override
  public double getX() {
    return x;
  }

  @Override
  public double getY() {
    return y;
  }

  @Override
  public double getDirection() {
    return direction;
  }

}

