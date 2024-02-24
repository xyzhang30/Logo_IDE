package slogo.view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import slogo.model.xmlParser.CommandXmlParser;

public class Controller extends Application {

  // how much to adjust updates per second
  public static final int SPEED_ADJUSTMENT = 1;

  private IDEWindow i1;

  private Stage stage;


  public Controller() {
    stage = new Stage();
    i1 = new IDEWindow(stage);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    i1.start();
  }


  public void run() {
    //System.out.println(i1.getText());
    System.out.println(i1.getText());
  }

  public void step() {
  }

  public void pause() {
  }

  public void help() {
  }

  public void feedHistory() {

  }
  public void feedVariables() {

  }
}
