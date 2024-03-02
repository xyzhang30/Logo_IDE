package slogo.view;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import slogo.model.api.TurtleModelApi;
import javafx.scene.paint.Color;

public class IDEWindow {

  private Stage stage;

  private Scene scene;


  public static final String STYLESHEET = "default.css";

  public static final String defaultLanguage = "english";

  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private static final String TITLE = "TURTLE";

  public static final Dimension DEFAULT_SIZE = new Dimension(900, 600);

  private TextInputPane t1 = new TextInputPane(100,100, "english");

  private TurtlePane tp1;
  private ButtonPane buttonPane;

  private Controller controller;

  private TurtleModelApi model;

  private int speed;

  private static final int STARTSPEED = 2;


  public IDEWindow (Stage stage, Controller controller) {
    this.stage = stage;
    this.controller = controller;
    speed = STARTSPEED;
  }

  public void start(TurtleModelApi model) throws Exception {
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    this.model = model;
    stage.setScene(makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height, model));
    stage.setAlwaysOnTop(true);
    stage.show();


    // start somewhere, less typing for debugging

  }

  public Scene makeScene (int width, int height, TurtleModelApi model) throws FileNotFoundException {
    Pane root = new AnchorPane();

    // must be first since other panels may refer to page
    ControlPane c1 = new ControlPane(DEFAULT_SIZE.height/6, DEFAULT_SIZE.width, controller, defaultLanguage);
    AnchorPane.setTopAnchor(c1.getRoot(), 0.0);
    root.getChildren().add(c1.getRoot());
    this.t1 = new TextInputPane(DEFAULT_SIZE.height/4, DEFAULT_SIZE.width, defaultLanguage);
    AnchorPane.setBottomAnchor(t1.getRoot(), 0.0);
    root.getChildren().add(t1.getRoot());

    tp1 = new TurtlePane(DEFAULT_SIZE.height/2,DEFAULT_SIZE.width/2, model, defaultLanguage, speed);
    AnchorPane.setBottomAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.height/4);
    AnchorPane.setTopAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.height/6);
    AnchorPane.setLeftAnchor(tp1.getRoot(), (double) DEFAULT_SIZE.width/4);
    root.getChildren().add(tp1.getRoot());
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
  public ButtonPane getButtonPane() {
    return buttonPane;
  }

  public void clearLine() {
    tp1.clear();
  }

  public void resume() {
    tp1.startTimeline();
  }

  public void pause() {
    tp1.stopTimeline();
  }

  public void updateColor(Color c1) {
    tp1.updateColor(c1);
  }

  public void setStylesheet(String stylesheet) {
    scene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_FOLDER + stylesheet).toExternalForm());
    System.out.println(stylesheet);
  }
}
