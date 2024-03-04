package slogo.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class HelpWindowTest extends ApplicationTest {

  private HelpWindow helpWindow;

  @Override
  public void start(Stage stage) {
    helpWindow = new HelpWindow();
    helpWindow.show();
  }

  @Test
  public void testHelpWindowComponents() {
    // Verify that the title label is displayed
    verifyThat(".label", isNotNull());

    // Verify that exit button is visible
    verifyThat("Exit", isVisible());

  }

  @Test
  public void testClickCommandLink() {
    // Click on a command link
    clickOn("Forward"); // Assuming "forward" is one of the command links

  }

  @Test
  public void testClickBackButton() {
    // Click on the back button
    clickOn("Back");

    // Verify that the main help screen is displayed again
    VBox helpPane = lookup(".vbox").query();
    assertEquals(1, helpPane.getChildren().size()); // Assuming only the title label is displayed after clicking back
  }

  @Test
  public void testExitButton() {
    // Click on the exit button
    clickOn("Exit");

    // Verify that the help window is closed
    assertEquals(false, helpWindow.isShowing());
  }
}
