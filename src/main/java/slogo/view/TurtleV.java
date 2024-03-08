package slogo.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The {@code TurtleV} interface defines methods for managing the graphical representation of a turtle.
 * Implementing classes are responsible for handling the turtle's image, position, visibility, and
 * related graphical updates.
 */
public interface TurtleV {

  /**
   * Gets the ImageView representing the turtle's image.
   *
   * @return The ImageView of the turtle's image.
   */
  ImageView getTurtleImage();

  /**
   * Updates the graphical representation of the turtle based on the specified position,
   * direction, and visibility.
   *
   * @param x         The x-coordinate of the turtle.
   * @param y         The y-coordinate of the turtle.
   * @param direction The direction of the turtle.
   * @param visible   {@code true} if the turtle is visible, {@code false} otherwise.
   */
  void turtleUpdate(double x, double y, double direction, boolean visible);

  /**
   * Gets the root Pane containing the graphical elements of the turtle.
   *
   * @return The root Pane of the turtle.
   */
  Pane getRoot();

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFilePath The name of the file containing the image for the turtle.
   */
  void updateImage(String selectedFilePath);

  /**
   * Gets the x-coordinate of the turtle.
   *
   * @return The x-coordinate of the turtle.
   */
  double getX();

  /**
   * Gets the y-coordinate of the turtle.
   *
   * @return The y-coordinate of the turtle.
   */
  double getY();

  /**
   * Gets the direction of the turtle.
   *
   * @return The direction of the turtle.
   */
  double getDirection();
}


