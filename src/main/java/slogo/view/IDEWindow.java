package slogo.view;

import java.awt.Dimension;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IDEWindow extends Application {

  private Stage stage;

  public static final String STYLESHEET = "default.css";

  private static final int WINDOW_WIDTH = 500;

  private static final int WINDOW_HEIGHT = 500;

  private static final String TITLE = "TURTLE";

  public static final Dimension DEFAULT_SIZE = new Dimension(900, 600);


  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle(TITLE);
    // add our user interface components to Frame and show it
    stage.setScene(makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height));
    stage.show();
    // start somewhere, less typing for debugging

  }

  public Scene makeScene (int width, int height) {
    BorderPane root = new BorderPane();

    // must be first since other panels may refer to page
    ControlPane c1 = new ControlPane(100, 100, "hi", new Controller());
    root.setCenter(c1.getRoot());
    // control the navigation
    // create scene to hold UI
    Scene scene = new Scene(root, width, height);
    // uncomment to activate CSS styling
    // scene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_FOLDER + STYLESHEET).toExternalForm());
    return scene;
  }
}
