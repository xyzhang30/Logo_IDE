package slogo.view;

import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public interface TurtleBase {

  /**
   * Updates the turtle pane to reflect the latest attributes of the turtle model.
   */
  void update();

  /**
   * Creates the initial turtle pane.
   * @throws FileNotFoundException if the image file for the turtle is not found.
   */
  void create() throws FileNotFoundException;

}
