package slogo.view;

import java.io.File;
import javafx.scene.paint.Color;

/**
 * The {@code TurtleBase} interface provides methods to interact with and update the display
 * of a turtle in the GUI.
 */
public interface TurtleBase {

  /**
   * Updates the turtle pane to reflect the latest attributes of the turtle model.
   */
  void update();

  /**
   * Sets the speed of the turtle animation.
   *
   * @param speed The speed value to set.
   */
  void setSpeed(int speed);

  /**
   * Clears the turtle's drawing on the pane.
   */
  void clear();

  /**
   * Starts the animation timeline for the turtle.
   */
  void startTimeline();

  /**
   * Stops the animation timeline for the turtle.
   */
  void stopTimeline();

  /**
   * Updates the color of the turtle's pen.
   *
   * @param color The new color of the turtle's pen.
   */
  void updateColor(Color color);

  /**
   * Updates the background color of the turtle pane.
   *
   * @param backgroundColor The new background color of the turtle pane.
   */
  void updateBackground(Color backgroundColor);

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFile The file representing the image to set for the turtle.
   */
  void updateImage(File selectedFile);

  /**
   * Checks if the animation timeline is currently paused.
   *
   * @return {@code true} if the timeline is paused, {@code false} otherwise.
   */
  boolean getPaused();
}
