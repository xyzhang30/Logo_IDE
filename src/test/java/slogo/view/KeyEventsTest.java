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

  @Test
  public void testUpKey() {
    // Scene scene = lookup("#Main").query().getScene();
    // scene.getRoot().requestFocus();
    // Pane pane = lookup("#Main").query();
    sleep(2000);
    push(KeyCode.UP);

    // press(KeyCode.UP);
    // release(KeyCode.UP);
    sleep(100);
    sleep(3000);
    assertEquals(50, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testDownKey() {
    // lookup("#Main").query().requestFocus();
    sleep(2000);
    press(KeyCode.DOWN);
    sleep(100);
    release(KeyCode.DOWN);
    sleep(3000);
    assertEquals(-50, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testRightKey() {
    // lookup("#Main").query().requestFocus();
    sleep(2000);
    press(KeyCode.RIGHT);
    sleep(100);
    release(KeyCode.RIGHT);
    sleep(3000);
    assertEquals(50, controller.getModel().get(1.0).getAttributes().ypos());
  }

  @Test
  public void testLeftKey() {
    // lookup("#Main").query().requestFocus();
    sleep(2000);
    press(KeyCode.LEFT);
    sleep(100);
    release(KeyCode.LEFT);
    sleep(3000);
    assertEquals(-50, controller.getModel().get(1.0).getAttributes().ypos());
  }
}
