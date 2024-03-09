package slogo.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The TurtleView class represents the graphical view of a turtle, including its image, position,
 * and visibility. It implements the TurtleV interface to provide methods for managing the turtle's
 * graphical representation.
 */
public class TurtleView implements TurtleV {

  private static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  private static final String DEFAULT_RESOURCE_FOLDER =
      "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");
  private static final String DEFAULT_IMAGE_PATH = "/images";
  private static final String DEFAULT_IMAGE = "turtle1.png";
  private final int turtleSize;
  private final double startDirection;
  private final Pane pane;
  private boolean imageHere;
  private ImageView turtleImage;
  private double positionX;

  private double positionY;

  private double direction;


  /**
   * Constructs a TurtleView with the specified dimensions, initial position, and starting
   * direction.
   *
   * @param turtleViewRecord an object containing information about the turtle view, including
   *                         width, height, initial position (startX, startY), and starting
   *                         direction.
   */
  public TurtleView(TurtleViewRecord turtleViewRecord) {
    positionX = turtleViewRecord.startX();
    positionY = turtleViewRecord.startY();
    direction = turtleViewRecord.startDirection();
    imageHere = true;
    startDirection = turtleViewRecord.startDirection();
    turtleSize = turtleViewRecord.turtleSize();
    pane = new Pane();
    pane.setId("TurtleImagePane");

    turtleImage = new ImageView((new Image(getClass()
        .getResource(DEFAULT_RESOURCE_FOLDER + DEFAULT_IMAGE_PATH + "/"
            + DEFAULT_IMAGE).toExternalForm())));

    pane.setTranslateX(turtleViewRecord.width() / 2);
    pane.setTranslateY(turtleViewRecord.height() / 2);
    pane.setPrefWidth(turtleViewRecord.width());
    pane.setPrefHeight(turtleViewRecord.height());

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
   * @param x         the x-coordinate of the turtle.
   * @param y         the y-coordinate of the turtle.
   * @param direction the direction of the turtle.
   * @param visible   true if the turtle is visible, false otherwise.
   */
  public void turtleUpdate(double x, double y, double direction, boolean visible) {
    updateDirection(direction);
    updatexCoordinate(x);
    updateyCoordinate(y);
    isVisible(visible);
    this.positionX = x;
    this.positionY = y;
    this.direction = direction;
  }

  private void updateDirection(double direction) {
    turtleImage.setRotate(direction);
  }

  private void updatexCoordinate(double x) {
    turtleImage.setTranslateX(x);
  }

  private void updateyCoordinate(double y) {
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
    turtleImage = new ImageView((new Image(getClass()
        .getResource(DEFAULT_RESOURCE_FOLDER + DEFAULT_IMAGE_PATH + "/"
            + selectedFilePath).toExternalForm())));
    initialize();
  }

  private void initialize() {
    turtleImage.setFitWidth(turtleSize);
    turtleImage.setFitHeight(turtleSize);
    turtleImage.setX(-((turtleSize) / 2));
    turtleImage.setY(-((turtleSize) / 2));
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

  /**
   * Gets the x-coordinate of the turtle.
   *
   * @return The x-coordinate of the turtle.
   */
  @Override
  public double getPositionX() {
    return positionX;
  }

  /**
   * Gets the y-coordinate of the turtle.
   *
   * @return The y-coordinate of the turtle.
   */
  @Override
  public double getPositionY() {
    return positionY;
  }

  /**
   * Gets the direction of the turtle.
   *
   * @return The direction of the turtle.
   */
  @Override
  public double getDirection() {
    return direction;
  }


}

