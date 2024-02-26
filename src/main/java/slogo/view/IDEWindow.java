package slogo.view;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import slogo.model.turtle.TurtleModel;

public class IDEWindow {

  private Stage stage;


  public static final String STYLESHEET = "default.css";

  public static final String defaultLanguage = "french";

  public static final String DEFAULT_RESOURCE_PACKAGE = "View.";
  public static final String DEFAULT_RESOURCE_FOLDER = "/" + DEFAULT_RESOURCE_PACKAGE.replace(".", "/");

  private static final int WINDOW_WIDTH = 500;

  private static final int WINDOW_HEIGHT = 500;

  private static final String TITLE = "TURTLE";

  public static final Dimension DEFAULT_SIZE = new Dimension(900, 600);

  private TextInputPane t1 = new TextInputPane(100,100,"hi", "english");

  private TurtlePane tp1;

  private Controller controller;

  TurtleModel model;



  public IDEWindow (Stage stage, Controller controller) {
    this.stage = stage;
    this.controller = controller;
  }

  public void start(TurtleModel model) throws Exception {
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    this.model = model;
    stage.setScene(makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height, model));
    stage.setAlwaysOnTop(true);
    stage.show();


    // start somewhere, less typing for debugging

  }

  public Scene makeScene (int width, int height, TurtleModel model) throws FileNotFoundException {
    BorderPane root = new BorderPane();

    // must be first since other panels may refer to page
    ControlPane c1 = new ControlPane(200, 200, STYLESHEET, controller, defaultLanguage);
    root.setTop(c1.getRoot());
    this.t1 = new TextInputPane(200,200,STYLESHEET, defaultLanguage);
    root.setBottom(this.t1.getRoot());

    tp1 = new TurtlePane(400,400,STYLESHEET, model, defaultLanguage);
    root.setCenter(tp1.getRoot());
    // control the navigation
    // create scene to hold UI
    Scene scene = new Scene(root, width, height);
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
    tp1.update();
  }
}
