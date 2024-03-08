package slogo.view;

import java.io.File;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The TurtleV interface defines methods for managing the graphical representation of a turtle.
 * Implementing classes are responsible for handling the turtle's image, position, visibility, and
 * related graphical updates.
 */
public interface TurtleV {

  /**
   * Gets the ImageView representing the turtle's image.
   *
   * @return the ImageView of the turtle's image.
   */
  ImageView getTurtleImage();

  /**
   * Updates the graphical representation of the turtle based on the specified position,
   * direction, and visibility.
   *
   * @param x         the x-coordinate of the turtle.
   * @param y         the y-coordinate of the turtle.
   * @param direction the direction of the turtle.
   * @param visible   true if the turtle is visible, false otherwise.
   */
  void turtleUpdate(double x, double y, double direction, boolean visible);

  /**
   * Gets the root Pane containing the graphical elements of the turtle.
   *
   * @return the root Pane of the turtle.
   */
  Pane getRoot();

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFile the file containing the image for the turtle.
   */
  void updateImage(File selectedFile);

  double getX();

  double getY();

  double getDirection();

}

