package slogo.view;

import java.awt.Dimension;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo.model.api.TurtleModelApi;

/**
 * The {@code IDEWindow} class represents the Integrated Development Environment (IDE) window for
 * the SLogo application. It manages the graphical user interface components, including text input,
 * turtle panes, control panels, and more.
 */
public class IDEWindow {

  // Constants and fields

  /**
   * The default stylesheet for the IDE window.
   */
  public static final String STYLESHEET = "default.css";

  /**
   * The default language used in the IDE window.
   */
  public static final String defaultLanguage = "english";

  /**
   * The default resource package for the IDE window.
   */
  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";

  /**
   * The default resource folder for the IDE window.
   */
  public static final String DEFAULT_RESOURCE_FOLDER =
      "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");
  /**
   * The default size of the IDE window.
   */
  public static final Dimension DEFAULT_SIZE = new Dimension(1500, 1000);
  /**
   * The title of the IDE window.
   */
  private static final String TITLE = "TURTLE";
  /**
   * The starting speed for the turtle animation.
   */
  private static final int STARTSPEED = 5;
  /**
   * The stage for the IDE window.
   */
  private final Stage stage;
  /**
   * The controller for the IDE window.
   */
  private final Controller controller;
  /**
   * The scene for the IDE window.
   */
  private Scene scene;
  /**
   * The language used in the IDE window.
   */
  private String language;
  /**
   * The text input pane in the IDE window.
   */
  private TextInput textPane;
  /**
   * The turtle pane in the IDE window.
   */
  private TurtleBase turtlePane;
  /**
   * The root pane of the IDE window.
   */
  private Pane root;
  /**
   * The models representing turtles in the IDE window.
   */
  private Map<Double, TurtleModelApi> models;
  /**
   * The command history pane in the IDE window.
   */
  private CommandHistoryPane historyPane;
  private UserDefPane userPane;
  /**
   * The speed of the turtle animation.
   */
  private int speed;

  // Constructors

  /**
   * Constructs an {@code IDEWindow} with the specified stage, controller, and language.
   *
   * @param stage      The stage for the IDE window.
   * @param controller The controller for the IDE window.
   * @param language   The language used in the IDE window.
   */
  public IDEWindow(Stage stage, Controller controller, String language) {
    this.stage = stage;
    this.controller = controller;
    this.language = language;
    speed = STARTSPEED;
  }

  // Public methods

  /**
   * Starts the IDE window with the specified turtle models.
   *
   * @param models The turtle models in the IDE window.
   */
  public void start(Map<Double, TurtleModelApi> models) {
    stage.setTitle(TITLE);
    this.models = models;
    stage.setScene(makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height));
    stage.show();
  }

  /**
   * Creates the scene for the IDE window with the specified dimensions. Adds necessary panes
   *
   * @param width  The width of the IDE window.
   * @param height The height of the IDE window.
   * @return The scene for the IDE window.
   */
  public Scene makeScene(int width, int height) {
    root = new AnchorPane();

    if (this.language == null) {
      this.language = "english";
    }
    ControlPane c1 = new ControlPane(DEFAULT_SIZE.height / 10, DEFAULT_SIZE.width, controller,
        language);
    AnchorPane.setTopAnchor(c1.getRoot(), 0.0);
    root.getChildren().add(c1.getRoot());
    this.textPane = new TextInputPane(DEFAULT_SIZE.height / 4, DEFAULT_SIZE.width, language);
    AnchorPane.setBottomAnchor(textPane.getRoot(), 0.0);
    root.getChildren().add(textPane.getRoot());

    addTurtlePane();

    this.userPane = new UserDefPane(DEFAULT_SIZE.height / 15, DEFAULT_SIZE.width / 4, language,
        controller.getExecutioner());
    AnchorPane.setBottomAnchor(userPane.getRoot(), (double) DEFAULT_SIZE.height / 8);
    AnchorPane.setTopAnchor(userPane.getRoot(), 5.0);
    AnchorPane.setRightAnchor(userPane.getRoot(), 0.0);
    root.getChildren().add(userPane.getRoot());

    this.historyPane = new CommandHistoryPane(DEFAULT_SIZE.height / 2, DEFAULT_SIZE.width / 20,
        language);
    AnchorPane.setBottomAnchor(historyPane.getRoot(), (double) DEFAULT_SIZE.height / 8);
    AnchorPane.setTopAnchor(historyPane.getRoot(), (double) DEFAULT_SIZE.height / 20);
    AnchorPane.setLeftAnchor(historyPane.getRoot(), 0.0);
    root.getChildren().add(historyPane.getRoot());

    scene = new Scene(root, width, height);
    setStylesheet(STYLESHEET);
    root.setOnKeyPressed(this::handleKeyPressed);
    root.requestFocus();
    root.setId("Main");
    return scene;
  }

  /**
   * Adds turtle pane to the IDE window.
   */
  public void addTurtlePane() {
    TurtlePaneRecord recordTurtlePane = new TurtlePaneRecord(DEFAULT_SIZE.height / 2,
        DEFAULT_SIZE.width / 2, models, language, speed, controller);
    turtlePane = new TurtlePane(recordTurtlePane);
    AnchorPane.setBottomAnchor(turtlePane.getRoot(), (double) DEFAULT_SIZE.height / 4);
    AnchorPane.setTopAnchor(turtlePane.getRoot(), (double) DEFAULT_SIZE.height / 10);
    AnchorPane.setLeftAnchor(turtlePane.getRoot(), (double) DEFAULT_SIZE.width / 4);
    root.getChildren().add(turtlePane.getRoot());
  }

  /**
   * Gets the text input from the IDE window.
   *
   * @return The text input from the IDE window.
   */
  public String getText() {
    return textPane.getTextInput();
  }


  /**
   * Updates the turtle in the IDE window.
   */
  public void updateTurtle() {
    turtlePane.setSpeed(speed);
    turtlePane.update();
    root.requestFocus();
  }

  /**
   * Gets the command history pane from the IDE window.
   *
   * @return The command history pane.
   */
  public CommandHistoryPane getHistoryPane() {
    return historyPane;
  }

  /**
   * Retrieves the UserDefPane associated with this HelpWindow.
   *
   * @return the UserDefPane instance.
   */
  public UserDefPane getUserPane() {
    return userPane;
  }


  /**
   * Gets the stage of the IDE window.
   *
   * @return The stage of the IDE window.
   */
  public Stage getStage() {
    return stage;
  }

  /**
   * Gets the speed of the turtle animation.
   *
   * @return The speed of the turtle animation.
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Sets the speed of the turtle animation.
   *
   * @param speed The speed to set.
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Clears the line drawn by the turtle.
   */
  public void clearLine() {
    turtlePane.clear();
  }

  /**
   * Resumes the turtle animation.
   */
  public void resume() {
    turtlePane.startTimeline();
  }

  /**
   * Pauses the turtle animation.
   */
  public void pause() {
    if (turtlePane.getPaused()) {
      resume();
    } else {
      turtlePane.stopTimeline();
    }
  }

  /**
   * Updates the color of the turtle's pen.
   *
   * @param c1 The new color of the turtle's pen.
   */
  public void updateColor(Color c1) {
    turtlePane.updateColor(c1);
  }

  /**
   * Sets the stylesheet for the IDE window.
   *
   * @param stylesheet The stylesheet to set.
   */
  public void setStylesheet(String stylesheet) {
    if (!scene.getStylesheets().isEmpty()) {
      scene.getStylesheets().remove(0);
    }
    scene.getStylesheets()
        .add(getClass().getResource(DEFAULT_RESOURCE_FOLDER + stylesheet).toExternalForm());
  }

  /**
   * Updates the background color of the turtle pane.
   *
   * @param c1 The new background color of the turtle pane.
   */
  public void updateBackground(Color c1) {
    turtlePane.updateBackground(c1);
  }

  /**
   * Updates the image of the turtle based on the selected file.
   *
   * @param selectedFilePath The name of the file containing the image for the turtle.
   */
  public void updateImage(String selectedFilePath) {
    turtlePane.updateImage(selectedFilePath);
  }

  /**
   * Clears the text in the text input pane.
   */
  public void clearText() {
    textPane.clearText();
  }

  /**
   * Shows an error message dialog.
   *
   * @param message The error message to display.
   */
  public void showError(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.initModality(Modality.APPLICATION_MODAL);
    alert.setTitle(ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language)
        .getString("errorWindowTitle"));

    Label messageText;
    try {
      messageText = new Label(ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language)
          .getString("error" + message));
    } catch (Exception e) {
      messageText = new Label(message);
    }
    messageText.setWrapText(true);
    alert.getDialogPane().setContent(messageText);

    alert.show();
  }

  /**
   * Handles the key pressed event by invoking corresponding actions based on the pressed key.
   *
   * @param event The KeyEvent representing the key pressed event.
   */
  private void handleKeyPressed(KeyEvent event) {
    KeyCode keyCode = event.getCode();
    System.out.println("hello");
    switch (keyCode) {
      case UP:
        controller.up();
        break;
      case DOWN:
        controller.down();
        break;
      case LEFT:
        controller.left();
        break;
      case RIGHT:
        controller.right();
        break;
      default:
        // nothing
        break;
    }
  }

  /**
   * Loads the specified content into the controller to run.
   *
   * @param fileContent the content to be loaded in the controller to run.
   */
  public void loadFileContent(String fileContent) {
    controller.runHelp(fileContent);
  }
}




