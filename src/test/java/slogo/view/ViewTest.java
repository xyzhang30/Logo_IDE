package slogo.view;

import java.io.FileNotFoundException;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import slogo.model.turtle.TurtleModel;
import util.DukeApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest extends DukeApplicationTest {

  private IDEWindow ideWindow;

  @Override
  public void start(Stage stage) throws FileNotFoundException {
    // Initialize your scene here
    TurtleModel mockModel = new TurtleModel();
    Controller controller = new Controller(stage, mockModel, language);
    ideWindow = new IDEWindow(stage, controller, language);
    Scene scene = ideWindow.makeScene(600, 400, mockModel);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void testTextRetrieval() {
    final String expectedText = "Test input";
    Platform.runLater(() -> {
      // Access JavaFX components after the UI is initialized
      TextArea textArea = ideWindow.getTextArea();

      // Set text in the text area
      textArea.setText(expectedText);

      // Call getText() method
      final String actualText = ideWindow.getText();

      // Verify that the retrieved text matches the expected text
      assertEquals(expectedText, actualText);
    });

    // Wait for JavaFX thread to process events
    sleep(100);
  }

  @Test
  public void testStartMethod() {
    // Run UI-related operations on JavaFX application thread
    Platform.runLater(() -> {
      // Create mock objects
      Stage mockStage = new Stage();
      TurtleModel mockModel = new TurtleModel();

      // Create Controller instance
      Controller controller = new Controller(mockStage, mockModel, language);

      // Call start method
      try {
        controller.start(); // Call start method
      } catch (Exception e) {
        // Handle exception if thrown
        System.out.println("Exception occurred while calling start method: " + e.getMessage());
      }
    });
  }

}
