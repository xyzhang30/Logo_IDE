package slogo.view;

import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
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

public class ControlPaneTest extends DukeApplicationTest {

  private Controller controller;

  private ControlPane cp1;

  private IDEWindow i1;

  @Override
  public void start(Stage stage) throws FileNotFoundException {
    controller = new Controller(stage, new Executioner(), "english");
    i1 = new IDEWindow(stage, controller, "english");
    stage.setScene(i1.makeScene(800,800, new TurtleModel()));
    stage.show();
  }

  @Test
  public void testButtonLabels() {
    verifyThat("#Run", hasText("Run"));
    verifyThat("#Step", hasText("Step"));
    verifyThat("#Pause", hasText("Pause"));
    verifyThat("#Help", hasText("Help"));
    verifyThat("#Speed_Up", hasText("Faster"));
    verifyThat("#Slow_Down", hasText("Slower"));
  }

  @Test
  public void testSpeedUpButtonClick() {
    Button button = lookup("#Speed_Up").query();
    int initialSpeed = controller.getSpeed();
    clickOn(button);
    int newSpeed = controller.getSpeed();
    assertEquals(initialSpeed + 1, newSpeed, "Speed should be increased by one");
  }

  @Test
  public void testSlowDownButtonClick() {
    Button button = lookup("#Slow_Down").query();
    int initialSpeed = controller.getSpeed();
    clickOn(button);
    int newSpeed = controller.getSpeed();
    assertEquals(initialSpeed - 1, newSpeed, "Speed should be decreased by one");
  }

//  public void testColorPicker() {
//    // Click on the "SelectColor" ColorPicker
//    ColorPicker cp1 = lookup("#SelectColor").query();
//    clickOn(cp1);
//
//  }
}