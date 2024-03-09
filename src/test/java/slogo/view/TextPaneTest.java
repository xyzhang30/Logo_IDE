package slogo.view;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.model.command.Executioner;
import util.DukeApplicationTest;


import static org.testfx.api.FxAssert.verifyThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class TextPaneTest extends DukeApplicationTest {

  private Controller controller;

  private TextInputPane t1;

  private IdeWindow i1;
  public void start(Stage stage) throws Exception {
    controller = new Controller(stage, new Executioner(), "english");
    i1 = new IdeWindow(stage, controller, "english");
    controller.start();
  }

  @Test
  public void testTextInput() {
    // Assuming "TextInput" is the id of your TextArea
    TextArea t1 = lookup("#TextInput").query();

    t1.setText("Testing");

    // Verify the text using the controller (adjust the method name accordingly)
    String enteredText = controller.getText();  // Assuming getText() is the method to retrieve text
    assertEquals("Testing", enteredText);
  }
}
