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

public class IDEWindowTest extends DukeApplicationTest {

  private IDEWindow ideWindow;

  @Override
  public void start(Stage stage) throws FileNotFoundException {
    // Initialize your scene here
    TurtleModel mockModel = new TurtleModel();
    Controller controller = new Controller(stage, mockModel);
    ideWindow = new IDEWindow(stage, controller);
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

}
