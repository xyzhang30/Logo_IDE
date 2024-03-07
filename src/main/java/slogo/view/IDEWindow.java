package slogo.view;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo.model.api.TurtleModelApi;
import javafx.scene.paint.Color;

public class IDEWindow {

  private Stage stage;

  private Scene scene;


  public static final String STYLESHEET = "default.css";

  public static final String defaultLanguage = "english";

  private String language;

  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private static final String TITLE = "TURTLE";

  public static final Dimension DEFAULT_SIZE = new Dimension(1200, 800);

  private TextInputPane t1 = new TextInputPane(100,100, "english");

  private TurtlePane tp1;

  private Controller controller;

  private TurtleModelApi model;
  private CommandHistoryPane historyPane;

  private int speed;

  private static final int STARTSPEED = 2;
  private Map<String, Double> variableItems;


  public IDEWindow (Stage stage, Controller controller, String language) {
    this.stage = stage;
    this.controller = controller;
    this.language = language;
    speed = STARTSPEED;
    this.variableItems = variableItems;
  }

  public void start(TurtleModelApi model) throws Exception {
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    this.model = model;
    stage.setScene(makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height, model));
    stage.show();


    // start somewhere, less typing for debugging

  }

  public Scene makeScene (int width, int height, TurtleModelApi model) throws FileNotFoundException {
    Pane root = new AnchorPane();

    // must be first since other panels may refer to page
    ControlPane c1 = new ControlPane(DEFAULT_SIZE.height/10, DEFAULT_SIZE.width, controller, language);
    AnchorPane.setTopAnchor(c1.getRoot(), 0.0);
    root.getChildren().add(c1.getRoot());
    this.t1 = new TextInputPane(DEFAULT_SIZE.height/4, DEFAULT_SIZE.width, language);
    AnchorPane.setBottomAnchor(t1.getRoot(), 0.0);
    root.getChildren().add(t1.getRoot());

    tp1 = new TurtlePane(DEFAULT_SIZE.height/2,DEFAULT_SIZE.width/2, model, language, speed, controller);
    AnchorPane.setBottomAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.height/4);
    AnchorPane.setTopAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.height/10);
    AnchorPane.setLeftAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.width/4);
    root.getChildren().add(tp1.getRoot());

    UserDefPane commandPane = new UserDefPane(DEFAULT_SIZE.height/15, DEFAULT_SIZE.width/4, language);
    AnchorPane.setBottomAnchor(commandPane.getRoot(), (double) DEFAULT_SIZE.height / 8);
    AnchorPane.setTopAnchor(commandPane.getRoot(), 0.0);
    AnchorPane.setRightAnchor(commandPane.getRoot(), 0.0);
    root.getChildren().add(commandPane.getRoot());

    this.historyPane = new CommandHistoryPane(DEFAULT_SIZE.height/2, DEFAULT_SIZE.width/20, language);
    AnchorPane.setBottomAnchor(historyPane.getRoot(), (double) DEFAULT_SIZE.height / 8);
    AnchorPane.setTopAnchor(historyPane.getRoot(), (double) DEFAULT_SIZE.height/20);
    AnchorPane.setLeftAnchor(historyPane.getRoot(), 0.0);
    root.getChildren().add(historyPane.getRoot());



    // control the navigation
    // create scene to hold UI
    scene = new Scene(root, width, height);
    // uncomment to activate CSS styling
    scene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_FOLDER + STYLESHEET).toExternalForm());
    return scene;
  }

  public String getText() {
    String textEdit = t1.getTextInput();
    System.out.println(textEdit);
    return textEdit;
  }

  public void updateTurtle() {
    tp1.setSpeed(speed);
    tp1.update();
  }

  public CommandHistoryPane getHistoryPane(){
    return historyPane;
  }
  public Stage getStage() {
    return stage;
  }
  public TextArea getTextArea(){
    return t1.getTextArea();
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void clearLine() {
    tp1.clear();
  }

  public void resume() {
    tp1.startTimeline();
  }

  public void pause() {
    if (tp1.getPaused()) {
      resume();
    }
    else {
      tp1.stopTimeline();
    }
  }

  public void updateColor(Color c1) {
    tp1.updateColor(c1);
  }

  public void setStylesheet(String stylesheet) {
    scene.getStylesheets().remove(0);
    scene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_FOLDER + stylesheet).toExternalForm());
  }

  public void updateBackground(Color c1) {
    tp1.updateBackground(c1);
  }

  public void updateImage(File selectedFile) {
    tp1.updateImage(selectedFile);
  }

  public boolean prevComplete() {
    return tp1.complete();
  }

  public void clearText() {
    t1.clearText();
  }

  public void showError(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.initModality(Modality.APPLICATION_MODAL); // Set modality
    alert.setTitle(ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language).getString("errorWindowTitle"));

    Label messageText;
    try {
      messageText = new Label(ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language).getString("error" + message));
    } catch (Exception e) {
      messageText = new Label(message);
    }
    messageText.setWrapText(true);
    alert.getDialogPane().setContent(messageText);

    alert.show();
  }

}

