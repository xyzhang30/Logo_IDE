package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * Control Pane class. Create buttons or other interactive elements on view
 */
public class ControlPane extends CreatePane implements Control {


  private static final String buttonPath = "buttons";
  private static final String imagePath = "src/main/resources/view/images/";
  private final Controller controller;
  private final ViewParser viewParser;

  /**
   * Constructor
   * @param height = height of pane
   * @param width = width of pane
   * @param controller = controller necessary for handling events
   * @param language = language for element displays
   */
  public ControlPane(int height, int width, Controller controller, String language) {
    super(height, width, language);
    viewParser = new ViewParser();
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
    try {
      viewParser.readXml(buttonPath);
      List<String> buttonNames = viewParser.getOptions();

      for (String buttonName : buttonNames) {
        String eventName = buttonName.replace("_", "");
        makeButton(buttonName, event -> invokeEventHandler(eventName));
      }
    } catch (FileNotFoundException e) {
      controller.showMessage("FileNotFound");
      e.printStackTrace();
    }
    // reflection was much more difficult for non buttons / parameters
    makeColorPicker("selectColor", event -> controller.changeColor(((ColorPicker) event.getSource()).getValue()));
    makeColorPicker("selectBackgroundColor", event -> controller.changeBackgroundColor(((ColorPicker) event.getSource()).getValue()));
    makeDropdown("dropdownSelector", "theme", event -> {
      ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
      String selectedOption = comboBox.getValue();
      controller.changeStylesheet(selectedOption);
    });
    makeButton("select_Image", event -> openFile());
    makeLabel("ArrowKeyMovementAmount");
  }

  private void invokeEventHandler(String handlerName) {
    try {
      Method method = Controller.class.getDeclaredMethod(handlerName);
      method.invoke(controller);
    }
    catch (Exception e1) {
      try {
        System.out.println("run button handler name " + handlerName);
        Method method = Controller.class.getDeclaredMethod(handlerName);
        method.invoke(controller);
      }
      catch (Exception e2) {
        controller.showMessage("NoSuchMethod");
//        e2.printStackTrace();
        if (e2 instanceof InvocationTargetException) {
          Throwable cause = e2.getCause();
          if (cause != null) {
            cause.printStackTrace(); // Print the underlying cause
          }
        }
      }
    }
  }

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
      viewParser.readXml(type);
      ObservableList<String> options = FXCollections.observableArrayList(viewParser.getOptions());
      ComboBox<String> dropdown = new ComboBox<>(options);
      dropdown.setId(property);
      dropdown.setOnAction(handler);
      String label = getMyResources().getString(property);
      dropdown.setPromptText(label);
      getRoot().getChildren().add(dropdown);
    }
    catch (FileNotFoundException f1) {
      controller.showMessage("FileNotFound");
    }
  }

  /**
   * Creates file chooser to allow somebody to pick a new image
   */
  private void openFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open File");

    // Set the initial directory to src/main/resources/view/images/

    fileChooser.setInitialDirectory(new File(imagePath));

    // Add filters if necessary, e.g., to filter by file extension
    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));

    File selectedFile = fileChooser.showOpenDialog(new Stage());

    if (selectedFile != null) {
      // Pass the selected file to the controller
      String selectedFilePath = selectedFile.getName();
      controller.processNewImage(selectedFilePath);
    }
  }

  private void makeLabel(String property) {
    Label label = new Label(getMyResources().getString(property) + ": " +
        Controller.KEY_MOVE_AMOUNT);
    getRoot().getChildren().add(label);
  }

}



