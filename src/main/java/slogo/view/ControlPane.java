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


public class ControlPane extends CreatePane {

  private ResourceBundle myResources;

  public static final String DEFAULT_RESOURCE_PACKAGE = "slogo.View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private final Controller controller;

  public ControlPane(int height, int width, String cssClassName, Controller controller) {
    super(height, width, cssClassName);
    // myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + cssClassName);
    this.controller = controller;
    root = new HBox();
    create();

  }

  @Override
  public void create() {
    addButtons();
  }

  private void addButtons() {
    makeButton("Run", event -> controller.run());
    makeButton("Step", event -> controller.step());
    makeButton("Pause", event -> controller.pause());
    makeButton("Help", event -> controller.help());
  }
  //button handler in controller and then pass in map of the button handlers into controlpane

  private void makeButton (String property, EventHandler<ActionEvent> handler) {
    // represent all supported image suffixes
    final String IMAGE_FILE_SUFFIXES = String.format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
    Button result = new Button();
    String label = property;//myResources.getString(property);
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
