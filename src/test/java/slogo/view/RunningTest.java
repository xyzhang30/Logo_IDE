package slogo.view;

import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import slogo.model.command.Executioner;
import slogo.model.turtle.TurtleModel;
import util.DukeApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class RunningTest extends DukeApplicationTest {

  private Controller controller;

  private ControlPane cp1;

  private IDEWindow i1;

  @Override
  public void start(Stage stage) throws Exception {
    controller = new Controller(stage, new Executioner(), "english");
    i1 = new IDEWindow(stage, controller, "english");
    controller.start();
  }

  @Test
  public void testForwardCommand() {
    // Assuming "TextInput" is the id of your TextArea
    TextArea t1 = lookup("#TextInput").query();

    t1.setText("fd 50");

    Button button = lookup("#Run").query();
    clickOn(button);
    sleep(2000);

    assertEquals(50, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testMultipleCommandRunSimple() {
    TextArea t1 = lookup("#TextInput").query();

    t1.setText("fd 50 fd 25");

    Button button = lookup("#Run").query();
    clickOn(button);
    sleep(6000);

    assertEquals(75, controller.getModel().get(1.0).getAttributes().xpos());
  }

  @Test
  public void testPauseDisabledOnStart() {
    Button button = lookup("#Pause").query();
    clickOn(button);
    assertEquals(State.STOPPED, controller.getState());
  }

  @Test
  public void testPauseWhenRunning() {
    TextArea t1 = lookup("#TextInput").query();
    t1.setText("fd 50");

    Button button = lookup("#Run").query();
    clickOn(button);
    sleep(500);

    Button button1 = lookup("#Pause").query();
    clickOn(button1);
    assertEquals(State.PAUSED, controller.getState());
  }

  @Test
  public void testResume() {
    TextArea t1 = lookup("#TextInput").query();
    t1.setText("fd 50");

    Button button = lookup("#Run").query();
    clickOn(button);
    sleep(500);

    Button button1 = lookup("#Pause").query();
    clickOn(button1);
    sleep(500);
    clickOn(button1);
    assertEquals(State.RUNNING, controller.getState());
  }

  @Test
  public void testSimpleStep() {
    TextArea t1 = lookup("#TextInput").query();
    t1.setText("fd 50 fd 25");
    Button button = lookup("#Step").query();
    clickOn(button);
    sleep(3000);
    assertEquals(50, controller.getModel().get(1.0).getAttributes().xpos());
    sleep(3000);
    clickOn(button);
    sleep(3000);
    assertEquals(75, controller.getModel().get(1.0).getAttributes().xpos());
  }

}