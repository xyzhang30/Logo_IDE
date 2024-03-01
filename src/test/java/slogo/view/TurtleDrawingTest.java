
package slogo.view;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import slogo.view.TurtleView;


import static org.junit.jupiter.api.Assertions.*;

public class TurtleDrawingTest {

  // Initialize JavaFX for headless testing
  @BeforeAll
  public static void initJavaFX() {
    new JFXPanel();
  }

  @Test
  public void testTurtleUpdate() {
    TurtleView turtleView = new TurtleView(800, 600, 0, 0, 0);
    assertEquals(0, turtleView.getTurtleImage().getRotate(), "Initial rotation should be 0");

    turtleView.turtleUpdate(50, 75, 90);
    assertEquals(90, turtleView.getTurtleImage().getRotate(), "Rotation should be updated to 90 degrees");
    assertEquals(50, turtleView.getTurtleImage().getTranslateX(), "X-coordinate should be updated to 50");
    assertEquals(75, turtleView.getTurtleImage().getTranslateY(), "Y-coordinate should be updated to 75");
  }

}
