package slogo.view;

import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
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

public class TextPaneTest extends DukeApplicationTest {

  private Controller controller;

  private TextInputPane t1;

  private IDEWindow i1;
  public void start(Stage stage) throws Exception {
    controller = new Controller(stage, new Executioner(), "english");
    i1 = new IDEWindow(stage, controller, "english");
    controller.start();
  }

  @Test
  public void testTextInput() {
    // Assuming "TextInput" is the id of your TextArea
    TextArea t1 = lookup("#TextInput").query();
    clickOn(t1).write("Hello, TestFX!");

    // Verify the text using the controller (adjust the method name accordingly)
    String enteredText = controller.getText();  // Assuming getText() is the method to retrieve text
    assertEquals("Hello, TestFX!", enteredText);
  }
}
