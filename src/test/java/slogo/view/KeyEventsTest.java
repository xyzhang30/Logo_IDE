package slogo.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.model.command.Executioner;
import util.DukeApplicationTest;

public class KeyEventsTest extends DukeApplicationTest {

  private Controller controller;

  @Override
  public void start(Stage stage) {
    controller = new Controller(stage, new Executioner(), "english");
    controller.start();
  }


  // tried for a very long time couldn't get robots button click to register in test case
  @Test
  public void testUpKey() {
    controller.up();
    assertEquals(50, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testDownKey() {
    controller.down();
    assertEquals(-50, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testRightKey() {
    controller.right();
    sleep(4000);
    assertEquals(-50, controller.getModel().get(1.0).getAttributes().ypos());
  }

  @Test
  public void testLeftKey() {
    controller.left();
    sleep(4000);
    assertEquals(50, controller.getModel().get(1.0).getAttributes().ypos());
  }
}
