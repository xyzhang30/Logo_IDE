package slogo.view;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;


public class ControlPane extends CreatePane implements Control {



  private final Controller controller;

  public ControlPane(int height, int width, String cssClassName, Controller controller, String language) {
    super(height, width, cssClassName, language);

    this.controller = controller;
    root = new HBox();
    create();

  }

  @Override
  public void create() {
    addButtons();
  }

  public void addButtons() {
    makeButton("Run", event -> controller.run());
    makeButton("Step", event -> controller.step());
    makeButton("Pause", event -> controller.pause());
    makeButton("Help", event -> controller.help());
  }
  //button handler in controller and then pass in map of the button handlers into controlpane

  public void makeButton (String property, EventHandler<ActionEvent> handler) {
    // represent all supported image suffixes
    final String IMAGE_FILE_SUFFIXES = String.format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
    Button result = new Button();
    String label = myResources.getString(property);
    if (label.matches(IMAGE_FILE_SUFFIXES)) {
      result.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(DEFAULT_RESOURCE_FOLDER + label))));
    }
    else {
      result.setText(label);
    }
    result.setOnAction(handler);
    getRoot().getChildren().addAll(result);
  }
}
