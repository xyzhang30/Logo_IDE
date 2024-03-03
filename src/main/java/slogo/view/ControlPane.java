package slogo.view;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;


public class ControlPane extends CreatePane implements Control {



  private final Controller controller;

  public ControlPane(int height, int width, Controller controller, String language) {
    super(height, width, language);

    this.controller = controller;
    setRoot(new HBox());
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
    makeButton("Speed_Up", event -> controller.speedUp());
    makeButton("Slow_Down", event -> controller.slowDown());
    makeColorPicker("SelectColor", event -> controller.changeColor(((ColorPicker) event.getSource()).getValue()));
    makeColorPicker("SelectBackgroundColor", event -> controller.changeBackgroundColor(((ColorPicker) event.getSource()).getValue()));
    makeDropdown("DropdownSelector", event -> {
      ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
      String selectedOption = comboBox.getValue();
      controller.changeStylesheet(selectedOption);
    });
  }
  //button handler in controller and then pass in map of the button handlers into controlpane

  public void makeButton (String property, EventHandler<ActionEvent> handler) {
    // represent all supported image suffixes
    final String IMAGE_FILE_SUFFIXES = String.format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
    Button result = new Button();
    String label = getMyResources().getString(property);
    result.setId(property);
    if (label.matches(IMAGE_FILE_SUFFIXES)) {
      result.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(DEFAULT_RESOURCE_FOLDER + label))));
    }
    else {
      result.setText(label);
    }
    result.setOnAction(handler);
    getRoot().getChildren().addAll(result);
  }

  public void makeColorPicker(String property, EventHandler<ActionEvent> handler) {
    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setId(property);
    colorPicker.setOnAction(handler);
    getRoot().getChildren().add(colorPicker);
  }

  public void makeDropdown(String property, EventHandler<ActionEvent> handler) {
    ObservableList<String> options = FXCollections.observableArrayList(
        "dark.css",
        "duke.css",
        "default.css"
    );
    ComboBox<String> dropdown = new ComboBox<>(options);
    dropdown.setId(property);
    dropdown.setOnAction(handler);
    getRoot().getChildren().add(dropdown);
  }
}

