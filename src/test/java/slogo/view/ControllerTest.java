package slogo.view;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import slogo.model.turtle.TurtleModel;
import util.DukeApplicationTest;

public class ControllerTest extends DukeApplicationTest {

  @Test
  public void testStartMethod() {
    // Run UI-related operations on JavaFX application thread
    Platform.runLater(() -> {
      // Create mock objects
      Stage mockStage = new Stage();
      TurtleModel mockModel = new TurtleModel();

      // Create Controller instance
      Controller controller = new Controller(mockStage, mockModel);

      // Call start method
      try {
        controller.start(); // Call start method
      } catch (Exception e) {
        // Handle exception if thrown
        System.out.println("Exception occurred while calling start method: " + e.getMessage());
      }

      // Here you can add assertions to verify the behavior of the start method,
      // such as checking if the stage is visible or if the scene is set properly.
    });
  }
}
