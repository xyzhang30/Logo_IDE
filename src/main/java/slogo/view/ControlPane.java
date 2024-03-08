package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.stage.DirectoryChooser;

/**
 * Control Pane class. Create buttons or other interactive elements on view
 */
public class ControlPane extends CreatePane implements Control {



  private final Controller controller;

  /**
   * Constructor
   * @param height = height of pane
   * @param width = width of pane
   * @param controller = controller necessary for handling events
   * @param language = language for element displays
   */
  public ControlPane(int height, int width, Controller controller, String language) {
    super(height, width, language);

    this.controller = controller;
    setRoot(new HBox());
    create();

  }

  /**
   * Adds all interactive elements to pane
   */
  @Override
  public void create() {
    addFeatures();
  }

  /**
   * Adds all interactive elements to display
   */

  @Override
  public void addFeatures() {
    makeButton("Run", event -> controller.run());
    makeButton("Step", event -> controller.step());
    makeButton("Pause", event -> controller.pause());
    makeButton("Help", event -> controller.help());
    makeButton("Speed_Up", event -> controller.speedUp());
    makeButton("Slow_Down", event -> controller.slowDown());
    makeButton("New_Application", event -> {
      try {
        controller.newInstance();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
    makeColorPicker("SelectColor", event -> controller.changeColor(((ColorPicker) event.getSource()).getValue()));
    makeColorPicker("SelectBackgroundColor", event -> controller.changeBackgroundColor(((ColorPicker) event.getSource()).getValue()));
    makeDropdown("DropdownSelector", "theme", event -> {
      ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
      String selectedOption = comboBox.getValue();
      controller.changeStylesheet(selectedOption);
    });
    makeButton("Select_Image", event -> openFile());

  }
  //button handler in controller and then pass in map of the button handlers into controlpane

  /**
   * Creates button
   * @param property = name to display
   * @param handler = event on push
   */
  private void makeButton (String property, EventHandler<ActionEvent> handler) {
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

  /**
   * Creates color picker to be added
   * @param property = name on display
   * @param handler = event on click
   */
  private void makeColorPicker(String property, EventHandler<ActionEvent> handler) {
    String label = getMyResources().getString(property);

    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setId(property);
    colorPicker.setOnAction(handler);
    colorPicker.setPromptText(label);
    getRoot().getChildren().add(colorPicker);
  }

  /**
   * Creates dropdown menu
   * @param property = name on display
   * @param type = name of xml file to use to parse options
   * @param handler = event on select
   */
  private void makeDropdown(String property, String type, EventHandler<ActionEvent> handler) {
    try {
      ViewParser v1 = new ViewParser();
      v1.readXml(type);
      ObservableList<String> options = FXCollections.observableArrayList(
          v1.getOptions()
      );
      ComboBox<String> dropdown = new ComboBox<>(options);
      dropdown.setId(property);
      dropdown.setOnAction(handler);
      String label = getMyResources().getString(property);
      dropdown.setPromptText(label);
      getRoot().getChildren().add(dropdown);
    }
    catch (FileNotFoundException f1) {
      System.out.println("Not found");
      // do nothing
    }
  }

  /**
   * Creates file chooser to allow somebody to pick a new image
   */
  private void openFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open File");

    // Set the initial directory to src/main/resources/view/images/
    String initialPath = "src/main/resources/view/images/";
    fileChooser.setInitialDirectory(new File(initialPath));

    // Add filters if necessary, e.g., to filter by file extension
    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));

    File selectedFile = fileChooser.showOpenDialog(new Stage());

    if (selectedFile != null) {
      // Pass the selected file to the controller
      controller.processSelectedPNGFile(selectedFile);
    }
  }


}



