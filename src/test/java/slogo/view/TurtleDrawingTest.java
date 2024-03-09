
package slogo.view;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import slogo.model.api.TurtleModelApi;
import slogo.model.command.Executioner;
import slogo.model.turtle.TurtleModel;


import static org.junit.jupiter.api.Assertions.*;

public class TurtleDrawingTest {

  // Initialize JavaFX for headless testing
  @BeforeAll
  public static void initJavaFX() {
    new JFXPanel();
  }

  @Test
  public void testTurtleUpdate() {
    Platform.runLater(() -> {
      TurtleView turtleView = new TurtleView(new TurtleViewRecord(800, 600, 0,
          0, 0, 50));
      assertEquals(0, turtleView.getTurtleImage().getRotate(), "Initial rotation should be 0");

      turtleView.turtleUpdate(50, 75, 90, true);
      assertEquals(90, turtleView.getTurtleImage().getRotate(), "Rotation should be updated to 90 degrees");
      assertEquals(50, turtleView.getTurtleImage().getTranslateX(), "X-coordinate should be updated to 50");
      assertEquals(75, turtleView.getTurtleImage().getTranslateY(), "Y-coordinate should be updated to 75");
      assertTrue(turtleView.getImageHere(), "Turtle Should be Visible");
    });
  }
  @Test
  public void multipleTurtleUpdateTest() {
    Platform.runLater(() -> {
      Map<Double, TurtleModelApi> map = new HashMap<>();
      TurtleModel t1 = new TurtleModel();
      TurtleModel t2 = new TurtleModel();
      map.put(1.0, t1);
      map.put(2.0, t2);
      TurtlePaneRecord record = new TurtlePaneRecord(750, 500,
          map, "english", 500, new Controller(new Stage(), new Executioner(), "english"));
      TurtlePane tb = new TurtlePane(record);
      t1.setPosX(50);
      t1.setPosY(50);
      t1.setActive(true);
      t2.setPosX(100);
      t2.setPosY(100);
      t2.setActive(true);

      tb.update();
      // sleep(1000);
      assertEquals(50, tb.getTurtleV(1.0).getTurtleImage().getTranslateX(), "x coord should be 50");
      assertEquals(50, tb.getTurtleV(1.0).getPositionY(), "y coord should be 50");
      assertEquals(100, tb.getTurtleV(2.0).getPositionX(), "x coord should be 100");
      assertEquals(100, tb.getTurtleV(2.0).getPositionY(), "y coord should be 100");
    });
  }
}
